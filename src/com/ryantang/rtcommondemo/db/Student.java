package com.ryantang.rtcommondemo.db;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	

	public Student() {
		name = null;
		age = 0;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
