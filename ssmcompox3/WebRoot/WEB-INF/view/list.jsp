<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css2/index2.css" type="text/css"></link></head>
    <script type="text/javascript" src="<%=request.getContextPath() %>/Jquery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
    
      function add(){
        location.href = "<%=request.getContextPath() %>/user/toAdd.controller";
      }
      function update(id){
        location.href = "<%=request.getContextPath() %>/user/toUpdate.controller?id="+id;
      }
      
      function del(id){
        location.href = "<%=request.getContextPath() %>/user/delete1.controller?id="+id;
      }
    </script>
  <body>
  	<form action="<%=request.getContextPath() %>/user/list.controller" method="post">
  		<table border="1" width="400px">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${user.name}"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age" value="${user.age}"/></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><input type="text" name="hobby" value="${user.hobby}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="查询"/></td>
			</tr>
		</table>
		<br/>
    <table>
    	<tr>
    		<th colspan="11">员工管理系统</th>
    	</tr>
      <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>个人爱好</td>
        <td>用户出生日期</td>
        <td>公司</td>
        <td>职位</td>
        <td>操作<input type="button" value="添加" onclick="add();" /></td>
      </tr>
      <c:forEach items="${list}" var="li" varStatus="o">
        <tr>
        <!--  
          <td>${o.index+1+startIndex}</td>
        -->
        	<td>${o.index+1}</td>
          <td>${li.name}</td>
          <td>${li.age}</td>
          <td>${li.hobby}</td>
          <td>${li.birthday}</td>
          
          
          <td>${li.company.cname}</td>
          <td>${li.position.pname}</td>
          <td>
            <input type="button" value="修改" onclick="update('${li.id}');" />
            <input type="button" value="删除" onclick="del('${li.id}');" />
          </td>
        </tr>
      </c:forEach>
      <tr>
       <th colspan="8">
       
       
         共有${listCount }条数据
         当前为${page}/${pageCount }页
         ${first }
         ${prev }
         ${next }
         ${last }
       </th>
      </tr>
    </table>
    </form>
  </body>
</html>
