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
		<title></title>
		<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
		
		<script language="JavaScript" type="text/javascript">
			function tishi() {
				var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
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
	
	<%
	
	   //获得session中的数据
	   Object   obj= session.getAttribute("admin");
	    
	   if(obj==null){
	      
	      response.sendRedirect("/sscs/login.jsp");
	      
	      return;
	   
	   } 
	
	
	 %>
	
	
	<body>
		<form name="fom" id="fom" method="post" action="servlet/AdminServlet?method=adminRegister">

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
						<table id="subtree1" style="DISPLAY: " width="100%" border="10" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
						<table width="100%" border="0" cellpadding="0" cellspacing="1" class="CContent">
										<tr>
											<th class="tablestyle_title">管理员信息录入${requestScope.msg }</th>
										</tr>

										<tr>
											<td class="font42">
											<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
												<TR>
													<TD width="100%">
														<fieldset style="height:100%;">
															<legend>管理员信息</legend>
															<table border="0" cellpadding="2" cellspacing="1" style="width:100%">

																<tr>
																	<td>管理员名称 :</td>
																	<td>
																		<input name="uname" type="text" class="text" style="width:154px" value="" />
																	</td>
																</tr>
																
																	<tr>
																	<td>管理员账号 :</td>
																	<td>
																		<input name="uid" type="text" class="text" style="width:154px" value="" />
																	</td>
																</tr>

																<tr>
																	<td>管理员密码:</td>
																	<td>
																		<input class="text" type="password" name="pwd" style="width:154px" value="" />
																	</td>
																</tr>

																<tr>
																	<td>管理员年龄:</td>
																	<td>
																		<input class="text" type="number" name="age" style="width:154px" value="" />
																	</td>
																</tr>
																
																<tr>
																	<td>入职日期:</td>
																	<td>
																		<input class="text" name="enterdate" style="width:154px" value="" onfocus="WdatePicker()"/>
																	</td>
																</tr>
																
																<tr>
																	<td >备注（可不填）:</td>
																	<td>
																		<textarea name="remark" cols="100" rows="8"></textarea>
																	</td>
																</tr>
															</table>
															<br />
														</fieldset>
													</TD>

												</TR>

											</table>
									</td>
							<TR>
								<TD align="center"  height="50px">
									<input type="submit" name="Submit" value="保存" class="right-button02"/>
								</TD>
							</TR>
									
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>				
		</form>
	</body>
	</body>

</html>