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
<style type="text/css">
<!--
body {
	margin-left: 450px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="140" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><img src="images/zuo.jpg" width="600" height="140" border="0" /></td>
        <td width="64%" align="right" class=left-font02>您是第${count }个访问本网站的人 <br>目前在线人数是${online} </td>
      </tr></td>
    </table>
  </tr>
</table>
</body>
</html>
