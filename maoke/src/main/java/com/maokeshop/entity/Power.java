package com.maokeshop.entity;

/**
 * Title:  树形菜单的实体
 * Description:
 * Company: www.baidu.com
 * @author 蒋路
 * @date 2017年4月17日下午7:40:15
 * @version 1.0
 */
public class Power {

	private Integer id;
	private String title;
	private String url ;
	private Integer fid ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
}
