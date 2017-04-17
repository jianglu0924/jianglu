package com.maokeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maokeshop.service.BrandService;

@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/toItemIndex")
	public String toItemIndex(){
		
		return "item/index";
	}
}
