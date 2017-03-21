package com.bawei.ssm.dto;

public class Company {

	private int cid;
	private String cname;
	
	
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Cumpany [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
