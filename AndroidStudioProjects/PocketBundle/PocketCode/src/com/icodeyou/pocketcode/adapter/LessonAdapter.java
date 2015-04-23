package com.icodeyou.pocketcode.adapter;

import java.net.URI;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.trinea.android.common.util.ImageUtils;

import com.icodeyou.pocketcode.R;
import com.icodeyou.pocketcode.model.Lesson;
import com.icodeyou.pocketcode.utils.ImageCacheUtils;

public class LessonAdapter extends BaseAdapter {
	
	private Context context;
	private List<Lesson> lessonList;
	
	public LessonAdapter(Context context, List<Lesson> lessonList){
		this.context = context;
		this.lessonList = lessonList;
	}

	@Override
	public int getCount() {
		return lessonList.size();
	}

	@Override
	public Object getItem(int position) {
		return lessonList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Lesson lesson = lessonList.get(position);
		if (convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.lesson_item, null);
		}
		ImageView lesson_pic = (ImageView) convertView.findViewById(R.id.lesson_pic);
		ImageCacheUtils imageCacheUtils = new ImageCacheUtils(context, lesson.getLesson_path(), lesson.getLesson_name());
		if (!imageCacheUtils.isImageExists()){
			//联网下载
			imageCacheUtils.downloadAndSetImage(lesson_pic);
			imageCacheUtils.downloadImage();
		}else{
			//直接从文件中读取并设置
			String sdpath = Environment.getExternalStorageDirectory() + "/";
			String SavePath = sdpath + "PocketCodeImages";
			String pathName = SavePath + "/"+lesson.getLesson_name() + ".jpg";
			Bitmap bitmap = BitmapFactory.decodeFile(pathName);
			lesson_pic.setImageBitmap(bitmap);
		}
		TextView lesson_name = (TextView) convertView.findViewById(R.id.lesson_name);
		lesson_name.setText(lesson.getLesson_name());
		TextView user_count = (TextView) convertView.findViewById(R.id.user_count);
		user_count.setText(lesson.getUser_count());
		TextView lesson_time = (TextView) convertView.findViewById(R.id.lesson_time);
		lesson_time.setText(lesson.getLesson_time());
		TextView lesson_desc = (TextView) convertView.findViewById(R.id.lesson_desc);
		lesson_desc.setText("         " + lesson.getLesson_desc());
		return convertView;
	}
}
