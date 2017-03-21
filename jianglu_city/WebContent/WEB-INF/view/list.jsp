<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css"></link>
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#qx").click(function(){
		$(".ids").attr("checked",true);		
	});
	$("#fx").click(function(){
		$(".ids").each(function(){
			if($(this).attr("checked")){
				$(this).attr("checked",false)
			}
			else{
				$(this).attr("checked",true)
			}
		})
	});
	$("#ps").click(function(){
		
	var ids = "";
		$(".ids").each(function(){
			if($(this).attr("checked")){
				ids +=","+$(this).val();
			}
			
		})
		ids = ids.substring(1);
		location.href="${pageContext.request.contextPath }/city/deleteAll.controller?ids="+ids;
	});
	$("#px").click(function(){
		var ids = "";
		$(".ids").each(function(){
			if($(this).attr("checked")){
				ids +=","+$(this).val();
			}
			
		})
		ids = ids.substring(1);
		location.href="${pageContext.request.contextPath }/city/updateAllPage.controller?ids="+ids;
	})
	
});

</script>
</head>
<body>

	<h1>城市列表         </h1>
	<form action="${pageContext.request.contextPath }/city/list.controller" method="post">
	<table class="table table-hover table-bordered" >
		<tr>
			<td colspan="11" >
				城市名称  ：<input type="text" value="${city.city_name }" name="city_name" >
					  <input type="checkbox" name="city_tese" value="古城" >古城
					  <input type="checkbox" name="city_tese" value="旅游" >旅游
					  <input type="checkbox" name="city_tese" value="新型" >新型
				
				 <input type="submit" value="查询" >
			</td>
		</tr>
		<tr>
			<td><input type="button" value="全选" id="qx" ><input type="button" value="反选" id="fx"></td>
			<td>城市编号</td>
			<td>城市名称</td>
			<td>城市特色</td>
			<td>市长名称</td>
			<td>市长电话</td>
			<td>市长邮箱</td>
			<td>城市等级</td>
			<td>操作 <a href="${pageContext.request.contextPath }/city/toAddPage.controller"><input type="button" value="新增" ></a></td>
		</tr>
	<c:forEach items="${list }" var="l" >
		<tr>
			<td><input type="checkbox" value="${l.id }" class="ids" ></td>
			<td>${l.id }</td>
			<td>${l.city_name }</td>
			<td>${l.city_tese }</td>
			<td>${l.name }</td>
			<td>${l.tel }</td>
			<td>${l.email }</td>
			<td>${l.cityType.tname}</td>
			<td>
				 <a href="${pageContext.request.contextPath }/city/toUpdatePage.controller?id=${l.id}"><input type="button" value="修改" ></a>
				 <a href="${pageContext.request.contextPath }/city/deleteCity.controller?id=${l.id}"><input type="button" value="删除" ></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="11" align="center" >
			     共有${listCount }条数据
         当前为${page}/${pageCount }页
         ${first }
         ${prev }
         ${next }
         ${last }
		</td>
	</tr>
	<tr>
		<td colspan="11" align="center" ><input type="button" value="批量删除" id="ps" ><input type="button" value="批量修改" id="px" ></td>
	</tr>
	</table>
	</form>
</body>
</html>