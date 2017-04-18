package com.maokeshop.service;

import java.util.List;
import java.util.Map;

import com.maokeshop.entity.EbBrand;
import com.maokeshop.entity.Power;

public interface BrandService {

	int testMysql();

	List<Power> getPower();

	List<EbBrand> listBrand(Map<String, Object> map);

	Integer getBrandCount(Map<String, Object> map);

	List<EbBrand> validateBrandName(String brandName);

}
