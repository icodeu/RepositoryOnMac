package com.prototype.enlist;

public class Main {

	public static void main(String[] args) {

		PersonInfo person1 = new PersonInfo();
		person1.setName("Alice");
		person1.setAge(18);
		person1.setNation("China");
		
		PersonInfo person2 = null;
		try {
			person2 = (PersonInfo) person1.clone();
			person2.setName("Bob");
			person2.setAge(20);
			person2.setNation("US");
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		person1.show();
		person2.show();
		
		
	}

}
