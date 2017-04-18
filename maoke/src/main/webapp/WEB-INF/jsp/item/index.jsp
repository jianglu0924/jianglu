<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/ecps/console/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.form-div{
		margin: 10px 0px 10px 20px;
	}
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ztree/js/jquery.ztree.core-3.4.js"></script>
<script type="text/javascript">
	var setting = {
			data:{
				key:{
					name:"title",
					url:"href"
				},
				simpleData:{
					enable:true,
					idKey:"id",
					pIdKey:"fid"
				}
			},callback: {
                onClick: zTreeOnClick
            }
		};
	 function zTreeOnClick(event, treeId, treeNode) {
       if(treeNode.url!="menu"){
       var flag = $("#item-tabs").tabs('exists',treeNode.title);
       if(!flag){
           $("#item-tabs").tabs('add',{
               title:treeNode.title,
               href:'${pageContext.request.contextPath}/'+treeNode.url,
               closable:true
           });
       }else{
           $("#item-tabs").tabs('select',treeNode.title);
       }
   }
}; 
var zNodes =${menu};
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
        




</script>
</head>  
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:250px;padding:10px;">
		<div id="treeDemo" class="ztree" ></div>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center'">
		<div id="item-tabs" class="easyui-tabs" data-options="fit:true,border:0">
			<div title="首页" style="padding:10px">
			<center>
				<div style="height: 200px"></div>
				<span style="color: red; font-size: 50px;font-weight: bold;font-family: '楷体'">毛&nbsp;嗑&nbsp;商&nbsp;城&nbsp;欢&nbsp;迎&nbsp;您</span>
			</center>
		</div>
		</div>
	</div>
</body>
</html>