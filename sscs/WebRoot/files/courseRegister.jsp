<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />

		<script language="JavaScript" type="text/javascript">
			function tishi() {
				var a = confirm('数据库中保存有该课程基本信息，您可以修改或保留该信息。');
				if (a != true) return false;
				window.open("冲突页.htm", "", "depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
			}

			function check() {
				document.getElementById("aa").style.display = "";
			}
		</script>
		<style type="text/css">
			<!-- .atten {
				font-size: 12px;
				font-weight: normal;
				color: #F00;
			}
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				background-image: url(images/leff.bmp);
			}
			-->
		</style>
		
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
		<form name="fom" id="fom" method="post" action="servlet/AdminServlet?method=couRegister">
	
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
						<table id="subtree1" style="DISPLAY: ;" width="100%" border="10" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr><td height="40" class="font42">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="CContent">
					<tr>
						<th class="tablestyle_title">课程信息录入   ${msg }</th>
					</tr>
					<tr>
						<td class="CPanel">
							<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
								<TR>
									<TD width="100%">
										<fieldset style="height:100%;">
											<legend>课程信息</legend>
											<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
												<tr>
													<td>课程编号:</td>
													<td>
														<input class="text" type="number" name="cno" style="width:154px" value="" />
													</td>
												</tr>
												<tr>
													<td>课程名称:</td>
													<td>
														<input name="name" type="text" class="text" style="width:154px" value="" />
													</td>
												</tr>

												<tr>
													<td>学分:</td>
													<td>
														<input class="text" type="number" min = "1" max = "10" name="credit" style="width:154px" value="" />
													</td>
												</tr>

												<tr>
													<td>开课日期:</td>
													<td>
														<input class="text" name='periodstart' style="width:154px" value="" onfocus="WdatePicker()"/>
													</td>
												</tr>
												
												<tr>
													<td>结课日期:</td>
													<td>
														<input class="text" type="text" name="periodend" style="width:154px" value="" onfocus="WdatePicker()"/> </td>
												</tr>
											</table>
											<br />
										</fieldset>
									</TD>

								</TR>

							</TABLE>

						</td>
					</tr>

					<TR>
						<TD colspan="2" align="center" height="50px">
							<input type="submit" name="Submit" value="保存" class="right-button02" />
						</TD>
					</TR>
				</table>
									
		
					</td>
									</tr>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		
		</form>
			
	</body>

</html>