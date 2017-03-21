<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js" ></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"${pageContext.request.contextPath }/city/findCityType.controller",
		dataType:"json",
		type:"post",
		success:function(o){
			
			$("[name=tid]").append("<option>---请选择---</option> ");
			for ( var j in o) {
				$("[name=tid]").append("<option value='"+o[j].t_id+"' >"+o[j].tname+"</option> ");
			}
			
		}
		
	});
});
function ckName(){
	var falg = true;
	var name = $("[name=city_name]").val();
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
}
</script>
<title>添加页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/city/addCity.controller" method="post" onsubmit="return  ckName()" >
	<table class="table table-hover table-bordered" >
		<tr>
			<td>城市名称   <input class="easyui-textbox" type="text" name="city_name" ><span id="msg" ></span> </td>
		</tr>
		<tr>
			<td>市长名字   <input class="easyui-textbox" type="text" name="name" ></td>
		</tr>
		<tr>
			<td>市长电话   <input class="easyui-textbox" type="text" name="tel" ></td>
		</tr>
		<tr>
			<td>市长邮箱   <input class="easyui-textbox" type="text" name="email" ></td>
		</tr>
		<tr>
			<td>时间  <input class="easyui-textbox" type="text" name="datea" ></td>
		</tr>
		<tr>
			<td>城市特色   <input class="easyui-checkbox" type="checkbox" name="city_tese" value="古城" >古城
					  <input type="checkbox" name="city_tese" value="旅游" >旅游
					  <input type="checkbox" name="city_tese" value="新型" >新型
			 </td>
		</tr>
		<tr>
			<td>城市级别   <select name="tid"  >   </select> </td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" > <input  type="button"  > </td>
		</tr>		
	
	</table>
</form>	
	
</body>
</html>