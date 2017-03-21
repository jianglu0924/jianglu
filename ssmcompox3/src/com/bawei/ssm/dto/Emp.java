package com.bawei.ssm.dto;

public class Emp {
	
	private String name;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", password=" + password + "]";
	}
}
