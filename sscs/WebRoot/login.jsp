<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>学生信息管理系统</title>
		<style>
    body{
   		 background:url(images/bo1.jpg) no-repeat center top;
   		 background-size:cover;
   		 background-attachment:fixed;
		}
    </style>
		<style type="text/css">
			<!--
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
			}
			-->
		</style>
		<link href="css/css.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript">
		   function change() {
			
			
			 document.getElementById("img").src="rand.jpg?a="+Math.random();
			 
			
		}
		
		
		</script>
	</head>

	<body >
		<table width="100%" height="20%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" height="150" > </td>
			</tr>
		</table>
		<form action="servlet/UserServlet?method=login" method="post">
			<table width="45%" height="50%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
				<tr>
					<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
		
							<tr>
								<td>
									<table width="70%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
										<tr>
											<td align="center"><img src="images/head3.png" width="230" height="230" /></td>
										</tr>
										<tr>
											<td height="40" align="center">&nbsp;</td>
										</tr>
		
									</table>
								</td>
								<td><img src="images/line2.png" width="20" height="300" /></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="31%" height="35" class="login-text06"> 欢迎登录
									<br />
								</td>
							</tr>
							<tr>
								<td width="31%" height="35" class="login-text02">用 户 名 称：
									<br />
								</td>
								<td width="10%">
									<input name="uid" type="text" size="30" />${msg }
								</td>
							</tr>
							<tr>
								<td height="35" class="login-text02">密　			   码：
									<br />
								</td>
								<td>
									<input name="pwd" type="password" size="30" />
								</td>
							</tr>
		
							<tr>
								<td height="35" class="login-text02">验  证  图  片：
									<br />
								</td>
								<td><img src="rand.jpg" width="149" height="40" id="img"/> <a href="javascript:void(0)" onclick="change()" class="login-text03">换张图片</a></td>
							</tr>
							<tr>
								<td height="35" class="login-text02">请输入验证码：</td>
								<td>
									<input name="yzm" type="text" size="30" />${msg2 }
								</td>
							</tr>
							<tr>
								<td colspan="3" height="35" class="login-text02">
								    管理员登录   
									<input type="radio" name="role" value="admin" />
									学生登录
									<input type="radio" name="role" value="student" />
									教师登录
									<input type="radio" name="role" value="teacher" />
								</td>
							</tr>
		
							<tr>
								<td height="35">&nbsp;</td>
								<td>
									<input name="Submit2" type="submit" class="right-button02" value="确认登陆" />&nbsp;&nbsp;&nbsp;  
									<input name="Submit232" type="submit" class="right-button02" value="重 置" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
</table>
	</body>

</html>