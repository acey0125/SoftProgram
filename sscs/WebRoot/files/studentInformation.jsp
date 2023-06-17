<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<style type="text/css">
			<!-- body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				background-image: url(images/leff.bmp);
			}
			.tabfont01 {
				font-family: "宋体";
				font-size: 9px;
				color: #555555;
				text-decoration: none;
				text-align: center;
			}
			.font051 {
				font-family: "宋体";
				font-size: 12px;
				color: #333333;
				text-decoration: none;
				line-height: 20px;
			}
			.font201 {
				font-family: "宋体";
				font-size: 12px;
				color: #FF0000;
				text-decoration: none;
			}
			.button {
				font-family: "宋体";
				font-size: 14px;
				height: 37px;
			}
			html {
				overflow-x: auto;
				overflow-y: auto;
				border: 0;
			}
			-->
		</style>

		<link href="css/css.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript">

		</script>
		<style type="text/css">
			<!-- .style3 {
				font-size: 18px
			}
			.style5 {
				font-size: 14px;
				text-decoration: none;
				font-family: "宋体";
			}
			.style6 {
				font-size: 12px;
				height: 20px;
				width: 45px;
				background-image: url(../images/button04.gif);
				border-top-width: 0px;
				border-right-width: 0px;
				border-bottom-width: 0px;
				border-left-width: 0px;
				font-family: "宋体";
			}
			.style7 {
				font-size: 12px;
				height: 20px;
				width: 75px;
				background-image: url(../images/button09.gif);
				border-top-width: 0px;
				border-right-width: 0px;
				border-bottom-width: 0px;
				border-left-width: 0px;
				font-family: "宋体";
			}
			.style10 {
				color: #000000
			}
			-->
		</style>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<SCRIPT language=JavaScript>
		function sousuo() {
			window.open("gaojisousuo.htm", "", "depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
		}

		function selectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					obj[i].checked = true;
				}
			}
		}

		function unselectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					if (obj[i].checked == true) obj[i].checked = false;
					else obj[i].checked = true;
				}
			}
		}
	</SCRIPT>

	<body>
		<form name="fom" id="fom" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="57" background="images/bo1.jpg" class="style10">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

													<tr>
														<td height="20" colspan="2" align="center" bgcolor="#EEEEEE" class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															个人信息列表 &nbsp;</td>
													</tr>
													<tr>
														<td width="21%" height="20" align="right" bgcolor="#FFFFFF" >姓名</td>
														<td width="74%" bgcolor="#FFFFFF">${admin.sname }</td>
													</tr>
													
													<tr>
														<td height="20" align="right" bgcolor="#FFFFFF">学号:</td>
														<td bgcolor="#FFFFFF">${admin.sno }</td>
													</tr>
													<tr>
														<td height="20" align="right" bgcolor="#FFFFFF">密码:</td>
														<td bgcolor="#FFFFFF">${admin.pwd }</td>
													</tr>
													
													<tr>
														<td height="20" align="right" bgcolor="#FFFFFF">班级:</td>
														<td bgcolor="#FFFFFF">${admin.clazzno }</td>
													</tr>
													<tr>
														<td height="20" align="right" bgcolor="#FFFFFF">性别:</td>
														<td bgcolor="#FFFFFF">${admin.gender }</td>
													</tr>
													<tr>
														<td align="right" bgcolor="#FFFFFF">出生年月:</td>
														<td bgcolor="#FFFFFF">${admin.birth }</td>
													</tr>
													<tr>
														<td align="right" bgcolor="#FFFFFF">联系方式:</td>
														<td bgcolor="#FFFFFF">${admin.phone }</td>
													</tr>
													<tr>
														<td align="right" bgcolor="#FFFFFF">备注:</td>
														<td bgcolor="#FFFFFF">${admin.remark}</td>
													</tr>
													
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>