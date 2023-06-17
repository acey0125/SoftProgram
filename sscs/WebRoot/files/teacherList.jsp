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
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		
	</head>
	
	<script type="text/javascript">
	
	  function rem(tno) {
		
		var  flag=  window.confirm("是否删除");
		
		if(flag){
			alert("删除成功");
		   window.location.href="servlet/AdminServlet?tno="+tno+"&method=teaRemove";
		}
	}
	
	
	</script>
	
	
	
	<body>
		<form name="fom" id="fom" method="post" action="servlet/AdminServlet?method=teaFindLike">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="57" background="images/bo1.jpg">

									<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td width="24"><img src="images/wen.png" width="20" height="18" /></td>
											<td>
												<select name="teano">
													<c:forEach items="${list1 }" var="tea">
													  													   
													      <option value="${tea.tno }"  selected="selected">${tea.tno }</option>
													   
													</c:forEach>
													<option value="0"  selected="selected">--请选择编号--</option>
												</select>&emsp;
												<span class="newfont06">姓名 : </span><input name="tname" type="text" size="12" value="${tname }"  />
												<input name="Submit" type="submit" class="right-button02" value="查 询" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0" ">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
													 <thead>
													<tr>
														<td height="20" colspan="15" align="center" bgcolor="#EEEEEE" class="tablestyle_title" style="text-align: center;"> 教师列表 </td>
													</tr>
													<tr>
														<td width="9%" height="20" align="center" bgcolor="#EEEEEE">编号</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">姓名</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">密码</td>														
														<td width="9%" align="center" bgcolor="#EEEEEE">联系方式</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">入职日期</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">备注</td>
														<td width="19%" align="center" bgcolor="#EEEEEE">操作</td>
													
													
													<c:forEach items="${list }" var="tea"  varStatus="vs">
													
													   <c:if test="${vs.count%2==0 }">
													     <tr bgcolor="#88aacc">
													   </c:if>
													   
													   <c:if test="${vs.count%2!=0 }">
													      <tr bgcolor="FFC0CB">
													   </c:if>
													
															<td align="center" height="20" >${tea.tno }</td>
															<td align="center">${tea.tname }</td>
															<td align="center">${tea.pwd }</td>
															<td align="center">${tea.phone }</td>
															<td align="center">${tea.hiredate }</td>
															<td align="center">${tea.remark }</td>
															<td align="center"><a href="javascript:void(0)" onclick="rem(${tea.tno})" >删除</a>&nbsp;|&nbsp;<a href="servlet/AdminServlet?tno=${tea.tno }&method=teaFindOne">修改</a></td>
														     <%-- <td bgcolor="#FFFFFF">${vs.count }----${vs.index }</td> --%>
														</c:forEach>
														</tr>
													 </thead>
													  <tbody id="tab">
										  
										  
										  				</tbody>
													
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>