package com.maokeshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maokeshop.entity.EbBrand;
import com.maokeshop.entity.Power;
import com.maokeshop.mapper.BrandMapper;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;

	public int testMysql() {
		return brandMapper.testMysql();
	}

	public List<Power> getPower() {
		return brandMapper.getPower();
	}

	public List<EbBrand> listBrand(Map<String, Object> map) {
		return brandMapper.listBrand(map);
	}

	public Integer getBrandCount(Map<String, Object> map) {
		return brandMapper.getBrandCount(map);
	}

	public List<EbBrand> validateBrandName(String brandName) {
		return brandMapper.validateBrandName(brandName);
	}
	
}
