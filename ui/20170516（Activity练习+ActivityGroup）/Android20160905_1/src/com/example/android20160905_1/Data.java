package com.example.android20160905_1;

import java.io.Serializable;

public class Data implements Serializable{
	String name;
	String qq;

	public Data(String name, String qq) {
		this.name = name;
		this.qq = qq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

}
