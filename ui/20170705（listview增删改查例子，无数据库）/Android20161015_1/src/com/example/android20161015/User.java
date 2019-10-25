package com.example.android20161015;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String age;
	private String qq;

	public User(String name, String age, String qq) {
		this.name = name;
		this.age = age;
		this.qq = qq;
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
