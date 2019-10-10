<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery.js"></script>
	
  </head>
  
  <body>
	<input type="button" value="ajax" onclick="a();"/>
	<script type="text/javascript">
		function b() {
			var jsonUser = JSON.stringify({
				"username" : "张三1",
				"sex" : "男"
			});

			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/user/requestJson.do',
				contentType : 'application/json;charset=utf-8',
				data : jsonUser,
				success : function(data) {
					alert(data.username);
				},
				error : function() {

				}
			})
		}
		
		function a() {
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/user/requestPojo.do',
				data : "username=李四&sex=男",
				success : function(data) {
					alert(data.username);
				},
				error : function() {

				}
			})
		}
	</script>
</body>
</html>
