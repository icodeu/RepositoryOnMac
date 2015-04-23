package com.icodeyou.pocketcode;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.icodeyou.pocketcode.adapter.CourseAdapter;
import com.icodeyou.pocketcode.model.Course;
import com.icodeyou.pocketcode.utils.HttpUtils;

public class CourseActivity extends Activity {

	private ListView course_list;
	private CourseAdapter adapter;
	private List<Course> courseList;

	private VideoView videoView;
	private String path;

	private int mLayout = VideoView.VIDEO_LAYOUT_ZOOM;
	private GestureDetector mGestureDetector;
	private boolean isFullScreen = false;
	private int currentWhich;
	private long currentPosition;
	
	private boolean isFirstPlay = true;
	
	private static final String CURRENT_WHICH = "current_which";
	private static final String CURRENT_POSITION = "current_position";

	private Handler getJsonHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			String jsonString = (String) msg.obj;
			try {
				JSONArray jsonArray = new JSONArray(jsonString);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = jsonArray.getJSONObject(i);
					courseList.add(new Course(object.getString("course_id"),
							object.getString("course_name"), object
									.getString("course_time"), object
									.getString("course_path"), object
									.getString("lesson_id")));
				}
				if (isFirstPlay == true){
					path = courseList.get(0).getCourse_path();
					courseList.get(0).setIs_play(true);
					videoView.setVideoPath(path);
					currentWhich = 0;
				}else{
					path = courseList.get(currentWhich).getCourse_path();
					courseList.get(currentWhich).setIs_play(true);
					videoView.setVideoPath(path);
					videoView.seekTo(currentPosition);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			course_list.setAdapter(adapter);
			course_list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					Course course = courseList.get(position);
					// 处理播放该course的逻辑
					clearPlayAll();
					course.setIs_play(true);
					path = courseList.get(position).getCourse_path();
					if (videoView != null) {
						videoView.setVideoPath(path);
						videoView.start();
						currentWhich = position;
					}
				}

				private void clearPlayAll() {
					for (Course course : courseList) {
						course.setIs_play(false);
					}
					adapter.notifyDataSetChanged();
				}
			});
			adapter.notifyDataSetChanged();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
			return;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_course);
		
		isFirstPlay = true;
		if (savedInstanceState != null){
			isFirstPlay = false;
			currentWhich = savedInstanceState.getInt(CURRENT_WHICH);
			currentPosition = savedInstanceState.getLong(CURRENT_POSITION);
		}

		String lesson_id = getIntent().getStringExtra("lesson_id");

		course_list = (ListView) this.findViewById(R.id.course_list);

		courseList = new ArrayList<Course>();
		adapter = new CourseAdapter(this, courseList);

		HttpUtils getJsonHttpUtils = new HttpUtils(MainActivity.WEB_PATH
				+ "getCourse.php?lesson_id=" + lesson_id, getJsonHandler);
		getJsonHttpUtils.getJsonString();

		videoView = (VideoView) findViewById(R.id.videoView);
		MediaController mediaController = new MediaController(this);
		videoView.setMediaController(mediaController);

		mGestureDetector = new GestureDetector(this, new MyGestureListener());
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		currentPosition = videoView.getCurrentPosition();
		outState.putInt(CURRENT_WHICH, currentWhich);
		outState.putLong(CURRENT_POSITION, currentPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		if (videoView != null)
			videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (mGestureDetector.onTouchEvent(event))
			return true;

		// 处理手势结束
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_UP:
			endGesture();
			break;
		}

		return super.onTouchEvent(event);
	}

	/** 手势结束 */
	private void endGesture() {
	}

	private class MyGestureListener extends SimpleOnGestureListener {
		/** 双击 */
		@Override
		public boolean onDoubleTap(MotionEvent e) {
//			if (mLayout == VideoView.VIDEO_LAYOUT_ZOOM)
//				mLayout = VideoView.VIDEO_LAYOUT_ORIGIN;
//			else
//				mLayout++;
//			if (videoView != null)
//				videoView.setVideoLayout(mLayout, 0);
			if (isFullScreen == false){
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				
				isFullScreen = true;
			}else{
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				isFullScreen = false;
			}
			return true;
		}
	}

}
