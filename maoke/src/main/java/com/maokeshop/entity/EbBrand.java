package com.maokeshop.entity;

/**
 * Title: 商品品牌的实体 
 * Company: www.maokeshop.com
 * @author 蒋路
 * @date 2017年4月17日上午7:29:45
 * @version 1.0
 */
public class EbBrand {

	private Integer brand_id;
	private String brand_name;
	private String brand_desc;
	private String imgs;
	private String website;
	private String brand_sort;

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getBrand_desc() {
		return brand_desc;
	}

	public void setBrand_desc(String brand_desc) {
		this.brand_desc = brand_desc;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBrand_sort() {
		return brand_sort;
	}

	public void setBrand_sort(String brand_sort) {
		this.brand_sort = brand_sort;
	}

}
