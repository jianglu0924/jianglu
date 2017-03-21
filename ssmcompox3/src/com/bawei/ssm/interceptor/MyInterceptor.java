package com.bawei.ssm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bawei.ssm.dto.Emp;

public class MyInterceptor implements HandlerInterceptor{
	
	private List<String> excludeURIS;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object o) throws Exception {
		// TODO Auto-generated method stub
		
		//true代表放行
		boolean flag = false;
		System.out.println("已经进入自定义的拦截器>>>>>>>>>>>>>>>>>");
		
		//当前触发的uri
		
		
		
		String URI = request.getRequestURI();
		//  /ssmcompox3/user/list.controller
		System.out.println(URI);
		
		//哪些uri不需要拦截
		
		System.out.println(excludeURIS);
		
		
		Emp emp = (Emp) request.getSession().getAttribute("emp1");
		
		if(excludeURIS.contains(URI)){   //不需要拦截，直接放行
			flag = true;
		}else{
			
			if(emp != null){   //已经登陆，直接放行
				flag = true;
			}else{    //去登陆页面
				flag = false;
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		}
		
		return flag;
	}
	

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	public List<String> getExcludeURIS() {
		return excludeURIS;
	}


	public void setExcludeURIS(List<String> excludeURIS) {
		this.excludeURIS = excludeURIS;
	}
	
	
	
	

	

}
