package com.baidu.entity;

import java.util.Date;

/**
  城市表t_city
城市编号id
城市名称city_name
城市特色(复选框)  特色:古城、旅游、新型
市长名称name
市长电话tel
市长邮箱email
等级编号tid

 *
 */

public class City {
	
	private Integer id ;
	private String name ;
	private String city_name ;
	private String city_tese;
	private String tel;
	private String email;
	private Integer tid;
	private Date datea;
	private CityType cityType;
	
	
	public Date getDatea() {
		return datea;
	}
	public void setDatea(Date datea) {
		this.datea = datea;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCity_tese() {
		return city_tese;
	}
	public void setCity_tese(String city_tese) {
		this.city_tese = city_tese;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public CityType getCityType() {
		return cityType;
	}
	public void setCityType(CityType cityType) {
		this.cityType = cityType;
	}
	
	
}
