package com.example.android20170617_1;

public class User {
	private int id;
	private String name;
	private String mima;

	public User() {

	}

	public User(int id, String name, String mima) {
		this.id = id;
		this.name = name;
		this.mima = mima;
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

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

}
