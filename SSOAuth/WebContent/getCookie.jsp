<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println("获取Cookie");
		Cookie[] cookies = request.getCookies();
		
		String url = request.getParameter("url");

		StringBuffer sb = new StringBuffer();
		String cookieName = "";
		String cookieVal = "";
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("SSOID")){
					cookieName = cookie.getName();
					cookieVal = cookie.getValue();
				}
			}
		}
		sb.append("document.cookie = '"+cookieName+"='+"+" cookie('"+cookieVal+"')"+" + ';path=/SSOWebDemo1';");
		System.out.print(sb.toString());
		response.getOutputStream().write(sb.toString().getBytes());
		out.clear();
		out = pageContext.pushBody();
	%>
</body>
</html>