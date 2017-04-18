<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en">

<head>
	<title>Desktop SSO Demo Login Page</title>
	<link rel="STYLESHEET" type="text/css" href="wangyu.css">
</head>


<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">

<br>

<div align="center">

	<table border="0" cellpadding="0" cellspacing="0" width="748" class="toptable">
		<tr>
			<td height="100" width="300">
                                <h3>欢迎! <%=request.getAttribute("SSOUser")%></h3><br>
				<h3>登陆成功！单点登录Demo1！</h3><br>
                                <br>
				<h3><A href="?action=logout">LogOut</A></h3>
			</td>
		</tr>
               
                
	</table>
	
     
</div>

</body>
</html>
