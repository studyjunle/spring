<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hello.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	测试
	<hr>
	<table border="1">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${findUserList }" var="user">
			<tr>
				<td>${user.username }</td>
				<td>${user.sex }</td>
				<td>
					<%-- <a href="${pageContext.request.contextPath }/user/update1.do?id=${user.id}">修改</a> --%>
					<a href="${pageContext.request.contextPath }/rest/user/update/${user.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<table border="1">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${findAllUserList }" var="user">
			<tr>
				<td>${user.username }</td>
				<td>${user.sex }</td>
				<td>${user.brithday }</td>
				<td>${user.address }</td>
				<td>
					<a href="${pageContext.request.contextPath }/rest/user/update/${user.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
