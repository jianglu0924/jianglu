<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css2/index2.css" type="text/css"></link></head>
    <script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
   
  <body>
    <form action="<%=request.getContextPath() %>/user/login.controller" method="post" >
      <table>
      	<tr>
      		<th colspan="11">登陆页面</th>
      	</tr>
        <tr>
          <td>姓名</td>
          <td><input type="text" name="name"/></td>
        </tr>
        <tr>
          <td>密码</td>
          <td><input type="text" name="password"/></td>
        </tr>
        <tr>
          <td colspan="2" >
            <input type="submit" value="登陆"  />
            <input type="button" value="返回" onclick="history.go(-1)" />
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>
