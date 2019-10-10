<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
  	<!-- 接收int参数 -->
	<form action="${pageContext.request.contextPath }/user/receiveInt.do" method="post">
		id：<input type="text" name="id"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<!-- 接收string参数 -->
	<form action="${pageContext.request.contextPath }/user/receiveString.do" method="post">
		username：<input type="text" name="username"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<!-- 接收javaBean参数 -->
	<form action="${pageContext.request.contextPath }/user/receiveUser.do" method="post">
		姓名：<input type="text" name="username"/><br/>
		性别：<input type="text" name="sex"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<!-- 接收包装类参数 -->
	<form action="${pageContext.request.contextPath }/user/receiveUserCustomer.do" method="post">
		姓名：<input type="text" name="user.username"/><br/>
		性别：<input type="text" name="user.sex"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<!-- 接收数组参数 -->
	<form action="${pageContext.request.contextPath }/user/receiveArray.do" method="post">
		ID1:<input type="checkbox" name="ids" value="1"/>
		ID2:<input type="checkbox" name="ids" value="2"/>
		ID3:<input type="checkbox" name="ids" value="3"/>
		ID4:<input type="checkbox" name="ids" value="4"/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<!-- 接收list集合的数据 -->
	<form action="${pageContext.request.contextPath }/user/receiveList.do" method="post">
		姓名：<input type="text" name="userList[0].username"/><br/>
		性别：<input type="text" name="userList[0].sex"/><br/>
		姓名：<input type="text" name="userList[1].username"/><br/>
		性别：<input type="text" name="userList[1].sex"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<!-- 接收map集合的数据 -->
	<form action="${pageContext.request.contextPath }/user/receiveMap.do" method="post">
		姓名：<input type="text" name="userMap['username']"/><br/>
		性别：<input type="text" name="userMap['sex']"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<!-- 接收requestParam参数 -->
	<form action="${pageContext.request.contextPath }/user/requestParamInt.do" method="post">
		sid：<input type="text" name="sid"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr>
  </body>
</html>
