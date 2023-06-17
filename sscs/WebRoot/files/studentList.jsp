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

		function link() {
			document.getElementById("fom").action = "yuangong.htm";
			document.getElementById("fom").submit();
		}
	</SCRIPT>
	
	<script type="text/javascript">
	
	  function rem(sno) {
		
		var  flag=  window.confirm("是否删除");
		
		if(flag){
			alert("删除成功");
		   window.location.href="servlet/AdminServlet?sno="+sno+"&method=stuRemove";
		}
	}
	
	
	</script>

	<body>
		<form name="fom" id="fom" method="post" action="servlet/AdminServlet?method=stuFindLike">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="57" background="images/bo1.jpg">

									<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td width="24"><img src="images/wen.png" width="20" height="20" /></td>
											<td>
												<select name="clazzno">
													<option value="0">--请选择班级--</option>
													
													<c:forEach items="${claList }" var="cla">
													  
													   <c:if test="${cla.clazzno==clazzno }">
													      <option value="${cla.clazzno }"  selected="selected">${cla.cname }</option>
													   </c:if>
													   
													   <c:if test="${cla.clazzno!=clazzno }">
													      <option value="${cla.clazzno }">${cla.cname }</option>
													   </c:if>
													  
													   
													</c:forEach>
												</select>&emsp;
												<span class="newfont06">姓名 : </span><input name="sname" type="text" size="12" value="${sname }"  />
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
						<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

													<tr>
														<td height="20" colspan="15" align="center" bgcolor="#EEEEEE" class="tablestyle_title" style="text-align: center;"> 学生列表 </td>
													</tr>
													<tr>
														<td width="10%" height="20" align="center" bgcolor="#EEEEEE">学生编号</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">姓名</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">性别</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">班级</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">教室</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">出生年月</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
														<td width="19%" align="center" bgcolor="#EEEEEE">操作</td>
													</tr>
													
													
													<!--定义总的人数   int  count=0  -->
								         			<c:set var="count" value="0"></c:set>
								         			
								         			<!--统计男生人数  -->
								         			<c:set var="man"  value="0"></c:set>
													<c:forEach items="${list }" var="stu"  varStatus="vs">
													
													   <c:if test="${stu.gender=='男' }">
													     <tr bgcolor="#88aacc">
													   </c:if>
													   
													   <c:if test="${stu.gender!='男' }">
													      <tr bgcolor="FFC0CB">
													   </c:if>
													
														 
															<td height="20" ><a href="listyuangongmingxi.html">${stu.sno }</a></td>
															<td ><a href="listyuangongmingxi.html">${stu.sname }</a></td>
															<td >${stu.gender }</td>
															<td >${stu.clazz.cname }</td>
															<td >${stu.clazz.clazzroom }</td>
															<td height="20" >${stu.birth }</td>
															<td height="20" >${stu.phone }</td>
															<td ><a href="javascript:void(0)" onclick="rem(${stu.sno})">删除</a>&nbsp;|&nbsp;<a href="servlet/AdminServlet?sno=${stu.sno }&method=stuFindOne">修改</a></td>
														     <%-- <td bgcolor="#FFFFFF">${vs.count }----${vs.index }</td> --%>
														</tr>
														
														<!-- count=count+1 -->
													   <c:set var="count" value="${count+1 }"></c:set>
													   
													   <c:if test="${stu.gender=='男' }">
													       <c:set var="man" value="${man+1 }"></c:set>
													   </c:if>
													   
													</c:forEach>
													<tr>
														<td height="20" colspan="15" align="center" bgcolor="#EEEEEE" class="tablestyle_title" style="text-align: center;">
														
														   班级的总人数是${count },男生的人数是${man },女生人数${count-man }
														
														
														 </td>
													</tr>
													
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
							</tr>
							<tr>
								<td height="33">
									<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
										
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