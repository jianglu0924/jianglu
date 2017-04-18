<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#item-datagrid").datagrid({
		width:"700px",
		height:"250px",
		title:"商品品牌",
		url:"${pageContext.request.contextPath}/brand/listBrand.controller",
		pagination:true,
		columns:[[
		          {field:"brand_id",title:"品牌编号",width:100},
		          {field:"imgs",title:"品牌log]",width:100,
		        	  formatter: function(value,row,index){
		        			  return "<img width='60' height='60' src='http://PC-20160927GUWP:8080/pic/'"+row.imgs+"'>";
		        	  }
		          
		          },
		          {field:"brand_name",title:"品牌名称",width:100},
		          {field:"brand_desc",title:"品牌描述",width:100},
		          {field:"website",title:"品牌网址",width:100},
		          {field:"brand_sort",title:"排序编号",width:100},
		          ]],
		fitColumns:true,
		fit:true,
		pageList:[3,6,9],
		pageSize:3,
		singleSelect:true,
		toolbar:[{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){


			}},'-',
			{
				text:'修改',
				iconCls:'icon-edit',
				handler:function(){
				}},'-',{
		 			text:"增加",
		 			iconCls:'icon-add',
		 			handler: function(){
		 				var flag = $("#item-tabs").tabs('exists','添加品牌');
		 		       if(!flag){
		 		           $("#item-tabs").tabs('add',{
		 		               title:'添加品牌',
		 		               href:'addBrandPage.controller',
		 		               closable:true
		 		           });
		 		       }else{
		 		           $("#item-tabs").tabs('select','添加品牌');
		 		       }
		 				
		 			}}
		]
		
	});
	
	/* $("#brand-dialog").dialog({
		width:"600px",
		height:"500px",
		title:"对话框",
		closable:true
	}) */
	


})
</script>
<table id="item-datagrid" ></table>
<!-- <div id="brand-dialog" >
	<form id="brand-form" >
		<div class="form-div" >
 		<input id="brand-name" name="brand_name" ><br>
 		</div>
 		<div class="form-div" >
 		<input id="brand-desc" name="brand_desc" ><br>
 		</div>
 		<div class="form-div" >
 		<input id="brand-website" name="website" ><br>
 		</div>
 		<div class="form-div" >
 		<input id="brand-imgs" name="imgs" ><br>
 		</div>
 		<div class="form-div" >
 		<input id="brand-sort" name="brand_sort" ><br>
 		</div>
	</form>

</div> -->
</body>
</html>