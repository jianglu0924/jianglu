package com.maokeshop.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.maokeshop.entity.EbBrand;
import com.maokeshop.entity.Power;
import com.maokeshop.service.BrandService;

/**
 * Title: 处理品牌的controller
 * Description: 前台使用easyUi
 * Company: www.baidu.com
 * @author 蒋路
 * @date 2017年4月18日上午8:56:10
 * @version 1.0
 */
@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/toItemIndex")
	public String toItemIndex(HttpServletRequest request){
		List<Power> list = brandService.getPower();
		String string = JSONObject.toJSONString(list);
		request.setAttribute("menu", string);
		System.out.println(string);
		return "item/index";
	}
	
	//去往brandList前台页面
	@RequestMapping("/getBrandList")
	public String getBrandList(){
		
		return "item/brand_list";
	}
	
	/**
	 * @author jianglu
	 *@date 2017年4月18日上午8:54:03
	 *@function 分页展示品牌信息
	 */
	@RequestMapping("/listBrand")
	@ResponseBody
	public Map<String, Object> listBrand(Integer page,Integer rows){
		
		Integer startPage=(page-1)*rows;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startPage", startPage);
		map.put("pageSize", rows);
		List<EbBrand> list = brandService.listBrand(map);
		Integer count = brandService.getBrandCount(map);
		
		//清空map 向map内添加前台需要的数据
		map.clear();
		map.put("rows", list);
		map.put("total", count);
		return map;
	}
	
	@RequestMapping("/addBrandPage")
	public String addBrandPage(){
		
		return "item/add_brand";
	}
	
	@RequestMapping("/validateBrandName")
	public void validateBrandName(String brandName,Writer writer) throws IOException{
		
		String falg = "yes";
		
		List<EbBrand> list = brandService.validateBrandName(brandName);
		
		if(list.size()>0){
			falg="no";
		}
		writer.write(falg);
	}
	
	@RequestMapping("addBrand")
	@ResponseBody
	public boolean addBrand(EbBrand brand){
		
		boolean b =  brandService.addBrand(brand);
		if(b)
			return true;
		return false;
	}
	
	
}
