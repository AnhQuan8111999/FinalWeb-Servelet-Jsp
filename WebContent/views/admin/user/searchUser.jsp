<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<a href="/finalweb10/admin/user/add" class="btn btn-primary">Them moi</a>
				<form class="form-inline" action="/finalweb10/admin/user/search" method="post">
					<input class="form-control" name="keyword" type="text" placeholder="Tim theo ten">
					<button type="submit" class="btn btn-danger">Tim</button>
				</form>
				<table class="table table-hover">
					<tr class="table-header">
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>UserName</th>
						<th>PassWord</th>
						<th>role</th>
						<th>Gender</th>
						<th>Option</th>
					</tr>
					<tr>
						<c:forEach items="${users }" var="user">
							<tr>
								<td>${user.id }</td>
								<td>${user.name }</td>
								<td>${user.age }</td>
								<td>${user.username }</td>
								<td>${user.password }</td>
								<td>${user.role }</td>
								<td>${user.gender }</td>
								<td><a class="btn btn-success" href="/finalweb10/admin/user/update?uid=${ user.getId()}">Sua</a> | <a class="btn btn-danger"
									href="/finalweb10/admin/user/delete?uid=${ user.getId()}">Xoa</a></td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>