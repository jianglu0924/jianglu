<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js" ></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"${pageContext.request.contextPath }/city/findCityType.controller",
		dataType:"json",
		type:"post",
		async:false,
		success:function(o){
			
			$(".tid").append("<option>---请选择---</option> ");
			for ( var j in o) {
				$(".tid").append("<option value='"+o[j].t_id+"' >"+o[j].tname+"</option> ");
			}
		}
		
	});
	
	
	var p = 0;
	for ( var o in f) {
		alert(f[o].tid)
		$("[name=citys["+p+"].tid]").val(f[o].tid);
		p = p*1+1 
	}
	
	
	var aa = "${city1.city_tese}";
	var s = aa.split(",");
	for ( var o in s) {
		$("[name=city_tese][value='"+s[o]+"']").attr("checked",true);
	}
});
/* function ckName(){
	var falg = true;
	var name = $("[name=city_name]").val();
	if(name=="${city1.city_name}")
		return true;
	
	$.ajax({
		url:"${pageContext.request.contextPath }/city/findCityByName.controller",
		dataType:"json",
		data:{city_name:name},
		type:"post",
		async:false,
		success:function(o){
			if(o){
			}
			else{
				$("#msg").text("城市名已存在");
				falg=o;
			}
		}
	});
	return falg;  
} */
</script>
<title>添加页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/city/updateAllCity.controller" method="post" >
	
	<table class="table table-hover table-bordered" >
	<c:forEach items="${list }" var="city1" varStatus="o" >
		<tr>
			<td>城市名称 <input type="hidden" value="${city1.id }" name="cities[${o.index }].id" >  <input type="text" name="cities[${o.index }].city_name" value="${city1.city_name }" ><span id="msg" ></span> </td>
		</tr>
		<tr>
			<td>市长名字   <input type="text" name="cities[${o.index }].name" value="${city1.name }" ></td>
		</tr>
		<tr>
			<td>市长电话   <input type="text" name="cities[${o.index }].tel" value="${city1.tel }" ></td>
		</tr>
		<tr>
			<td>市长邮箱   <input type="text" name="cities[${o.index }].email" value="${city1.email }" ></td>
		</tr>
		<tr>
			<td>城市特色   <input type="checkbox" name="cities[${o.index }].city_tese" value="古城" >古城
					  <input type="checkbox" name="cities[${o.index }].city_tese" value="旅游" >旅游
					  <input type="checkbox" name="cities[${o.index }].city_tese" value="新型" >新型
			 </td>
		</tr>
		<tr>
			<td>城市级别   <select name="cities[${o.index }].tid" class="tid" >   </select> </td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
	</c:forEach>
	
		<tr>
			<td><input type="submit" value="提交" > </td>
		</tr>
	</table>
</form>	
	
</body>
</html>