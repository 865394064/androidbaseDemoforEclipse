package com.example.android20170409_1;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String age;
	private String qq;
	private int id;

	public User(int id, String name, String age, String qq) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.qq = qq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

}
