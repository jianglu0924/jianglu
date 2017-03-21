package com.bawei.ssm.dto;

public class Position {

	private int pid;
	private String pname;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public Position(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Position [pid=" + pid + ", pname=" + pname + "]";
	}
	
	
}
