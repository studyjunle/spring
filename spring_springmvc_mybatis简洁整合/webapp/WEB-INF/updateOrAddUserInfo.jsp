<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>更新用户页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.js"></script>
</head>

<body>
	<table border="1">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
		<tr>
			<td><input type="text" value="${userList.username }" name="username" size="20px"></td>
			<td><input type="text" value="${userList.sex }" name="sex" size="20px"></td>
			<td>
				<input type="text" value="<fmt:formatDate value='${userList.brithday }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="brithday" size="20px">
			</td>
			<td><input type="text" value="${userList.address }"	name="address" size="20px"></td>
			<input type="hidden" value="${userList.id }" name="id" />
			<c:if test="${userList != null }">
				<td><input type="button" value="更新" onclick="updateUser()" /></td>
			</c:if>
			<c:if test="${userList == null }">
				<td><input type="button" value="添加" onclick="addUser()" /></td>
			</c:if>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function userConfig() {
		//获取name=xxxx值的方法
		var username = $("[name='username']")[0].value;
		var sex = $("[name='sex']").val();
		var address = $("[name='address']").get(0).value;
		var brithday = $("[name='brithday']").val();
		var id = $("[name='id']").val();
		
		var jsonUser = JSON.stringify({
			"username" : username,
			"sex" : sex,
			"address" : address,
			"brithday" : brithday,
			"id" : id
		});
		
		return jsonUser;
	}
	
	function updateUser() {
		$.ajax({
			url : "${pageContext.request.contextPath }/user/updateUserById.do",
			type : "post",
			async : false,
			contentType : "application/json;charset=utf-8",
			data : userConfig(),
			success : function(data) {
				if (data.updateMsg > 0) {
					alert("更新成功");
					window.location.href="${pageContext.request.contextPath}/user/findAllUser.do";
				}
			},
			error : function(data) {
				alert("更新失败" + data);
			}
		});
	}
	
	function addUser() {
		$.ajax({
			url : "${pageContext.request.contextPath }/user/addUser.do",
			type : "post",
			async : false,
			contentType : "application/json;chartset=utf-8",
			data : userConfig(),
			success : function(data) {
				if (data.addMsg > 0) {
					alert("添加用户成功");
					window.location.href="${pageContext.request.contextPath }/user/findAllUser.do";
				}
			},
			error : function(data) {
				alert("添加用户失败" + data);
			}
		});
	}
</script>
</html>
