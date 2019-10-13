<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>list.jsp</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.js"></script>
  </head>
  
  <body>
  	<h1>查询的数据</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>地址</th>
			<th id="a">操作</th>
		</tr>
		<c:if test="${userList != null}">
			<c:forEach items="${userList }" var="user">
				<tr>
					<td><input type="checkbox" value= "${user.id }" name="id"/></td>
					<td>${user.username }</td>
					<td>${user.sex }</td>
					<td><fmt:formatDate value="${user.brithday }" pattern="yyyy年MM月dd日HH点mm分ss秒"/></td>
					<td>${user.address }</td>
					<td>
						<input type="button" value="修改" onclick="updateView(${user.id})"/>
						<input type="button" value="删除" onclick="deleteTip(${user.id});"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${user != null}">
			<tr>
				<td>${user.username }</td>
				<td>${user.sex }</td>
				<td><fmt:formatDate value="${user.brithday }" pattern="yyyy年MM月dd日HH点mm分ss秒"/></td>
				<td>${user.address }</td>
				<td>
					<input type="button" value="修改" onclick="updateView(${user.id})"/>
					<input type="button" value="删除" onclick="deleteTip(${user.id});"/>
				</td>
			</tr>
		</c:if>
	</table>
	<div><input type="button" value="批量删除" onclick="deleteTips()"/></div>
  </body>
  <script type="text/javascript">
  	function deleteTip(id) {
  		if (window.confirm("是否确认要删除？")) {
  			$.ajax({
				type : "get",
				url : "${pageContext.request.contextPath}/rest/user/deleteUserById/" + id,
				async : false,
				success : function() {
					alert("删除成功");
					location.reload(true);
				},
				error : function() {
					alert("删除失败");
				}
			});
  		}
  	}
  	
  	function updateView(id) {
  		self.location.href = "${pageContext.request.contextPath}/rest/user/updateUserView/" + id;
  	}
  	
  	// 批量删除
  	function deleteTips() {
  		// 获取所有被选择的input元素
  		debugger;
  		var ids = $(":checked");
  		var idArray = new Array();
		if (ids.length != 0) {
			for(var i = 0; i < ids.length; i++) {
				idArray.push(ids[i].value);
			}
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/user/deleteUserByIdArray",
				type : "post",
				data : "idArray=" + idArray,
				async : false,
				success : function (data) {
					if (data.length == ids.length) {
						alert("用户删除成功");
						window.location.href="${pageContext.request.contextPath}/user/findAllUser.do"
					} else {
						alert("有一部分数据无法删除");
					}
				}
			});
		}
  	}
  </script>
</html>
