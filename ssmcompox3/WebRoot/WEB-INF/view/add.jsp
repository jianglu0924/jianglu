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
    <script type="text/javascript">
      $(document).ready(function(){

        //公司信息数据的查询。
        $.ajax({
          type:"post",
          url:"<%=request.getContextPath() %>/user/findCompany.controller",
          data:{},
          dataType:"json",
          success:function(com){
            for(var i=0;i<com.length;i++){
              $("#company").append("<option value='"+com[i].cid+"' >"+com[i].cname+"</option>");
            }
          }
        });


        //职位信息数据的查询。
        $.ajax({
          type:"post",
          url:"<%=request.getContextPath() %>/user/findPosition.controller",
          data:{},
          dataType:"json",
          success:function(g){
            for(var i=0;i<g.length;i++){
              $("#position").append("<option value='"+g[i].pid+"' >"+g[i].pname+"</option>");
            }
          }
        });
      
      });
    </script>
  
  <body>
    <form action="<%=request.getContextPath() %>/user/add.controller" method="post" >
      <table>
      	<tr>
      		<th colspan="11">员工信息添加页面</th>
      	</tr>
        <tr>
          <td>姓名</td>
          <td><input type="text" name="name"/></td>
        </tr>
        <tr>
          <td>年龄</td>
          <td><input type="text" name="age"/></td>
        </tr>
        <tr>
          <td>个人爱好</td>
          <td><input type="text" name="hobby"/></td>
        </tr>
        <tr>
          <td>用户出生日期</td>
          <td><input type="text" name="birthday" onclick="WdatePicker();" /></td>
        </tr>
        <tr>
          <td>公司</td>
          <td>
            <select name="c_id" id="company" >
               <option value="" >---请选择---</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>职位</td>
          <td>
          <select name="p_id" id="position" >
               <option value="" >---请选择---</option>
          </select>
          </td>
        </tr>
        <tr>
          <td colspan="2" >
            <input type="submit" value="提交"  />
            <input type="button" value="返回" onclick="history.go(-1)" />
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>
