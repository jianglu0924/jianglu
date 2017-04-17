package com.maokeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.maokeshop.service.BrandService;

@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;
}
