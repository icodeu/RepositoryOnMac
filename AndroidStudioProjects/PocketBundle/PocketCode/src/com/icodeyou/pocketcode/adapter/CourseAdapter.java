package com.icodeyou.pocketcode.adapter;

import java.util.List;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.icodeyou.pocketcode.R;
import com.icodeyou.pocketcode.model.Course;

public class CourseAdapter extends BaseAdapter {
	
	private Context context;
	private List<Course> courseList;
	
	public CourseAdapter(Context context, List<Course> courseList){
		this.context = context;
		this.courseList = courseList;
	}

	@Override
	public int getCount() {
		return courseList.size();
	}

	@Override
	public Object getItem(int position) {
		return courseList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Course course = courseList.get(position);
		if (convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.course_item, null);
		}
		ImageView course_play = (ImageView) convertView.findViewById(R.id.course_play);
		TextView course_name = (TextView) convertView.findViewById(R.id.course_name);
		TextView course_time = (TextView) convertView.findViewById(R.id.course_time);
		if (course.getIs_play()){
			course_play.setImageResource(R.drawable.isplay);
			course_name.setTextColor(Color.rgb(255, 153, 51));
		}
		else{
			course_play.setImageResource(R.drawable.notplay);
			course_name.setTextColor(Color.GRAY);
			
		}
		course_name.setText(course.getCourse_name());
		course_time.setText(course.getCourse_time());
		course_time.setTextColor(Color.GRAY);
		return convertView;
	}
}
