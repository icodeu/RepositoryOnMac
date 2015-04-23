package com.icodeyou.pocketcode.model;

public class Lesson {
	private String lesson_id;
	private String lesson_name;
	private String lesson_time;
	private String user_count;
	private String lesson_path;
	private String lesson_desc;

	public Lesson(String lesson_id, String lesson_name, String lesson_time, String user_count, String lesson_path, String lesson_desc) {
		setLesson_id(lesson_id);
		setLesson_name(lesson_name);
		setLesson_time(lesson_time);
		setUser_count(user_count);
		setLesson_path(lesson_path);
		setLesson_desc(lesson_desc);
	}
	
	public void setLesson_path(String lesson_path) {
		this.lesson_path = lesson_path;
	}
	
	public void setLesson_desc(String lesson_desc) {
		this.lesson_desc = lesson_desc;
	}

	public void setLesson_id(String lesson_id) {
		this.lesson_id = lesson_id;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}

	public void setLesson_time(String lesson_time) {
		this.lesson_time = lesson_time;
	}
	
	public void setUser_count(String user_count) {
		this.user_count = user_count;
	}

	public String getLesson_id() {
		return lesson_id;
	}
	
	public String getUser_count() {
		return user_count;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public String getLesson_time() {
		return lesson_time;
	}
	
	public String getLesson_desc() {
		return lesson_desc;
	}
	
	public String getLesson_path() {
		return lesson_path;
	}
}
