package com.kafkademo.model;

import java.io.Serializable;

public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
	}
	
	public User(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	private String name;
	private String lastName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lastName=" + lastName + "]";
	}

	
}
