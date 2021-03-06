package com.prototype.enlist;

public class PersonInfo implements Cloneable {

	private String name;
	private int age;
	private Nation nation = new Nation();
	
	public void show(){
		System.out.println("My name is " + name + ", age is " + age + ", come from " + nation.getNation());
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setNation(String nation) {
		this.nation.setNation(nation);
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	
	// 深复制时注意在此需要修改
	@Override
	protected Object clone() throws CloneNotSupportedException {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setName(this.name);
		personInfo.setAge(this.age);
		personInfo.setNation(this.nation.getNation());
		return personInfo;
	}
	
}
