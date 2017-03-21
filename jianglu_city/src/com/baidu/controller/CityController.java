package com.baidu.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.baidu.entity.City;
import com.baidu.entity.CityCustom;
import com.baidu.entity.CityType;
import com.baidu.entity.User;
import com.baidu.service.CityService;
import com.baidu.utils.PageUtil;

import sun.net.InetAddressCachePolicy;

@Controller
@Scope("prototype")
@RequestMapping("/city")
public class CityController {

	@Resource(name="cityService")
	private CityService cityService ;
	
	/**
	 * author:蒋路
	 * date:2017年3月12日下午8:12:24
	 * function: 列表分页
	 * @String
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request,City city){
		Map<String,Object> map = new HashMap<String,Object>();
		
		//收集分页数据
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		Integer pageSize = 2;
		Integer startIndex = (page-1)*pageSize;
		String city_name = city.getCity_name()==null?null:city.getCity_name().trim().equals("")?null:city.getCity_name();
		String city_tese = city.getCity_tese();
		map.put("city_tese", city_tese);
		map.put("city_name", city_name);
 		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		List<City> list = cityService.listCity(map);
		String url = "/city/list.controller";
		Integer count = cityService.findCount(map);
		PageUtil.page(request, url, pageSize, list, count, page,map);
		return "list";
		
	}
	
	/**
	 * author:蒋路
	 * date:2017年3月12日下午8:13:42
	 * function:添加页面
	 * @String
	 */
	@RequestMapping("/toAddPage.controller")
	public String toAddPage(){
		
		return "city_add";
		
	}
	//ajax返回城市级别
	@ResponseBody
	@RequestMapping("/findCityType.controller")
	public List<CityType> findCityType(){
		

		List<CityType> list =  cityService.findCityType();
		
		return list;
	}
	/**
	 * author:蒋路
	 * date:2017年3月12日下午8:14:48
	 * function:添加城市
	 */
	@RequestMapping("/addCity.controller")
	public String addCity(City city){
		
		cityService.addCity(city);
		
		return "redirect:list.controller";
	}
	
	@ResponseBody
	@RequestMapping("/findCityByName.controller")
	public boolean findCityByName(City city){
		
		city = cityService.findCityByName(city);
		if(city==null)
			return true;
		return false;
	}
	
	/**
	 * author:蒋路
	 * date:2017年3月13日下午1:58:41
	 * function: 修改回县
	 * @String
	 */
	@RequestMapping("/toUpdatePage.controller")
	public String toUpdatePage(HttpServletRequest request,City city){
		
		city = cityService.findCityById(city);
		request.setAttribute("city1", city);
		return "city_update";
	}
	
	/**
	 * author:蒋路
	 * date:2017年3月13日下午3:49:45
	 * function: 修改城市
	 * @String
	 */
	@RequestMapping("/updateCity.controller")
	public String updateCity(City city){
		
		cityService.updateCity(city);
		return "redirect:list.controller";
	}
	
	/**
	 * author:蒋路
	 * date:2017年3月13日下午4:55:25
	 * function: 删除的方法
	 * @String
	 */
	@RequestMapping("/deleteCity.controller")
	public String deleteCity(City city){
		
		cityService.deleteCityById(city);
		
		return "redirect:list.controller";
	}
	
	/**
	 * author:蒋路
	 * date:2017年3月13日下午8:23:50
	 * function: 批量删除
	 * @String
	 */
	@RequestMapping("/deleteAll.controller")
	public String deleteAll(String ids){
		cityService.deleteAll(ids);
		return "redirect:list.controller";
	}
	
	/**
	 * author:蒋路
	 * date:2017年3月15日上午10:45:48
	 * function: 批量修改的查询
	 * @String
	 */
	@RequestMapping("/updateAllPage.controller")
	public String updateAllPage(HttpServletRequest request, String ids){
		
		String[] split = ids.split(",");
		Integer[] idss = new Integer[10];
		for (int i = 0; i < split.length; i++) {
			idss[i] = Integer.parseInt(split[i]);
		}
		List<City> list = cityService.findCityByIds(idss);
		request.setAttribute("list", list);
		return "city_updateAll";
	}
	
	@RequestMapping("/updateAllCity")
	public String updateAllCity(CityCustom cityCustom){
		
		cityService.updateAllCity(cityCustom);
		
		return "redirect:list.controller";
	}
	
	
	
	@RequestMapping("/uploadFile")
	public String uploadFile(MultipartFile pictureFile) throws IllegalStateException, IOException{
		
		
		String originalFilename = pictureFile.getOriginalFilename();
		
		String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
		
		String filePath = "E:\\upload\\";
		
		File file = new File(filePath+newFileName);
		
		pictureFile.transferTo(file);
		User u= new User();
		u.setFileName(newFileName);
		cityService.addUser(u);
		
		return null;
	}
	
	/**
	 * author:蒋路
	 * date:2017年3月15日下午2:52:57
	 * function:  自定义属性编辑器
	 * @void
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		
	}
	
}
