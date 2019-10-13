<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="picPath" value="E:/upload"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>index.jsp</title>
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="jquery.form.js"></script>
	<script type="text/javascript">
		// 是用ajax提交表单数据	页面不会跳转	--用于本页请求数据然后回显数据
		function findAllUserForm() {
			var option = {
					type : "post",
					url : "${pageContext.request.contextPath }/user/findAllUser.do",
					success : function () {
						alert("提交成功");
					}
			};
			$("#findAllUserForm").ajaxSubmit(option);
		}
		
		function findUserByIdForm() {
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/user/findUserById.do",
				data : "id=266",
				dataType : "json",
				success : function (data) {
					/* var table = $("#table");
					var content = "<tr><td>" + data.username + "</td></tr>";
					table.append(content); */
					$("#test").val(data.username);
				}
			});
		}
		// 上传文件
		function uploadFile(that) {
			var file = that.files[0];
			var formData = new FormData();
			formData.append("file", file);
			dataType : "json",
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/user/uploadFile.do",
				data : formData,
				contentType : false,
				processData : false,
				success : function (data) {
					// 回显数据等
					var span = "<span>" + "${picPath}" + data.filePath + "</span></br>";
					$("#fileDisplay").append(span);
				},
				error : function() {
					
				}
			});
		}
	</script>
  </head>
  
  <body>
	<form id="findAllUserForm" action="${pageContext.request.contextPath }/user/findAllUser.do" method="post">
		<input type="submit" value="查询所有用户"/>
	</form>
	
	<form action="${pageContext.request.contextPath }/user/addUserView.do" method="post">
		<input type="submit" value="添加用户"/>
	</form>
	
	<form action="${pageContext.request.contextPath }/user/findUserById.do" method="post">
		要查询的用户id:<input type="text" name="id"/>
		<input type="submit" value="查询"/>
	</form>
	
	<form action="${pageContext.request.contextPath }/user/findUserByName.do" method="post">
		要查询用户的用户名:<input type="text" name="username"/>
		<input type="submit" value="查询"/>
	</form>
	
	<input type="button" value="查询ID为88的用户信息" onclick="findUserByIdForm()"/>
	<table border="1" id="table">
		<tr>
			<td>
				<input type="text" id="test" disabled="disabled"/>
			</td>
		</tr>
	</table>
	
	<hr>
	<input type="file" onchange="uploadFile(this)"/>
	<div id="fileDisplay">
		
	</div>
  </body>
</html>
