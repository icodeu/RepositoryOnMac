package com.icodeyou.pocketcode.model;

public class Course {
	private String course_id;
	private String lesson_id;
	private String course_time;
	private String course_name;
	private String course_path;
	private boolean is_play;

	public Course(String course_id, String course_name, String course_time,
			String course_path, String lesson_id) {
		setCourse_id(course_id);
		setLesson_id(lesson_id);
		setCourse_time(course_time);
		setCourse_name(course_name);
		setCourse_path(course_path);
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public void setLesson_id(String lesson_id) {
		this.lesson_id = lesson_id;
	}

	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public void setCourse_path(String course_path) {
		this.course_path = course_path;
	}
	
	public void setIs_play(boolean is_play) {
		this.is_play = is_play;
	}

	public String getCourse_id() {
		return course_id;
	}

	public String getLesson_id() {
		return lesson_id;
	}

	public String getCourse_time() {
		return course_time;
	}

	public String getCourse_name() {
		return course_name;
	}

	public String getCourse_path() {
		return course_path;
	}
	
	public boolean getIs_play() {
		return is_play;
	}
}
