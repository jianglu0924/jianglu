package com.bawei.ssm.dto;

public class User {
     
	private int id;
	private String name;
	private Integer age;
	
	
	//爱好
	private String hobby;
	private String birthday;
	
	
	
	//公司的id
	private int c_id;
	//职位的id
	private int p_id;
	
	//引用自定义类型。
	private Company company;
	private Position position;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int cId) {
		c_id = cId;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int pId) {
		p_id = pId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, Integer age, String hobby,
			String birthday, int cId, int pId, Company company,
			Position position) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hobby = hobby;
		this.birthday = birthday;
		c_id = cId;
		p_id = pId;
		this.company = company;
		this.position = position;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", birthday=" + birthday + ", c_id=" + c_id
				+ ", company=" + company + ", hobby=" + hobby + ", id=" + id
				+ ", name=" + name + ", p_id=" + p_id + ", position="
				+ position + "]";
	}
	
	
}
