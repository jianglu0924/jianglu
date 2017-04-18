<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="${pageContext.request.contextPath}/images/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/images/jquery.cookie.js"></script>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
  	<script type="text/javascript">
			$.ajax({
				type:"get",
				url:"http://127.0.0.1:8080/SSOAuth/getCookie.jsp",
				dataType:"jsonp",
				jsonp:"callback",
				jsonpCallback:"cookie",
				success:function (json){
					if(json!=""){
						$.cookie("SSOID", json); 
					}
					location.href="test.jsp?cookie="+json;
				}
			});
	</script>
  </body>
</html>
