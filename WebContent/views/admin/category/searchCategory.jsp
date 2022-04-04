<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<a href="/finalweb10/admin/category/add" class="btn btn-primary">Them moi</a>
				<form class="form-inline" action="/finalweb10/admin/category/search" method="post">
					<input class="form-control" name="keyword" type="text" placeholder="Tim theo ten" value="${keyword}">
					<button type="submit" class="btn btn-danger">Tim</button>
				</form>
				<table class="table table-hover">
					<tr class="table-header">
						<th>ID</th>
						<th>Name</th>
						<th>Option</th>
					</tr>
					<c:forEach items="${categoryList}" var="category">
						<tr>
							<td>${category.id }</td>
							<td>${category.name }</td>
							<td><a class="btn btn-success" href="/finalweb10/admin/category/update?id=${category.getId() }">Sua</a> | <a class="btn btn-danger"
								href="/finalweb10/admin/category/delete?id=${category.getId() }">Xoa</a></td>
						</tr>
					</c:forEach>
					
					<!-- Phan trang -->
					<c:forEach begin="1" end="${maxPage}" step="1" var="pageNo">
						<a href="/finalweb10/admin/category/search?pageNo=${pageNo}&?keyword=${keyword}">${pageNo}</a>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
</body>
</html>