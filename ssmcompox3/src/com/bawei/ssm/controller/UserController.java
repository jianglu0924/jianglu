package com.bawei.ssm.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bawei.ssm.dto.Company;
import com.bawei.ssm.dto.Emp;
import com.bawei.ssm.dto.Position;
import com.bawei.ssm.dto.User;
import com.bawei.ssm.service.UserService;
import com.bawei.ssm.utils.PageUtil;
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping("/list.controller")	
	public String list(HttpServletRequest request,
			/*
			 * 注意，默认的这个user对象会被放置到request作用域。也就是隐示
			 */
			User user){
		System.out.println(userService);
		System.out.println(user);
		
		//获取页码值
		Integer pageNum = request.getParameter("page") == null ? 1:Integer.parseInt(request.getParameter("page"));
		//pageSize
		Integer pageSize = 2;
		//计算起始索引位置
		Integer startIndex = (pageNum-1)*pageSize;
		//获取总的记录数
		Integer count = userService.count(user);
		System.out.println(count);
		//url其实就是list页面访问的url
		String url = "/user/list.controller";
		//封装分页所需要的参数
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		
		
		//准备查询的条件
		map.put("name", user.getName());
		map.put("age", user.getAge());
		map.put("hobby", user.getHobby());
		//指定的页面所需要的数据
		List<User> list = userService.list(map);
		System.out.println(list.size());
		PageUtil.page(request, url, pageSize, list, count, pageNum,map);
		request.setAttribute("user", user);
		return "list";
	}
	
	//去添加页面  toAdd.controller
	@RequestMapping("/toAdd.controller")	
	public String toAdd(){
		return "add";
	}
	
	
	//findCompany.controller  @ResponseBody将返回的数据打成json或者xml   
	@ResponseBody      
	@RequestMapping("/findCompany.controller")	
	public List<Company> findCompany(){
		List<Company> list = userService.findCompany();
		return list;
	}
	
	
	
	//findPosition.controller
	
	@ResponseBody      
	@RequestMapping("/findPosition.controller")	
	public List<Position> findPosition(){
		List<Position> list = userService.findPosition();
		return list;
	}
	
	
	//add.controller
	@RequestMapping("/add.controller")	
	public String add(User user){
		
		System.out.println(user);
		userService.add(user);
		return "redirect:list.controller";
	}
	
	//toUpdate.controller
		@RequestMapping("/toUpdate.controller")	
		public String toUpdate(HttpServletRequest request,User user){
			System.out.println(user.getId());
			
			User u = userService.findUserById(user);
			
			request.setAttribute("u", u);
			
			return "update";
		}
	
	//update.controller
		
		@RequestMapping("/update.controller")	
		public String update(User user){
			System.out.println(user);
			userService.update(user);
			return "redirect:list.controller";
		}
	
		
		
		//delete1.controller
		@RequestMapping("/delete1.controller")	
		public String delete(User user){
			System.out.println(user);
			userService.delete(user);
			return "redirect:list.controller";
		}
		
		
		//去登陆页面
		@RequestMapping("/toLogin.controller")	
		public String toLogin(User user){
			return "login";
		}
		
		
		
		//去登陆页面
		@RequestMapping("/login.controller")	
		public String login(HttpServletRequest request,Emp emp){
			System.out.println(emp);
			
			Emp emp1 = userService.login(emp);
			
			HttpSession session = request.getSession();
			if(emp1 != null){   //可以登陆
				session.setAttribute("emp1", emp1);
				return "redirect:list.controller";
			}else{
				return "login";
			}
		}
		
	//**************************************
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

}
