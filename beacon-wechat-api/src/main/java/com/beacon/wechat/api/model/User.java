package com.beacon.wechat.api.model;

public class User extends Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4587061511212442759L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
