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
				<a href="/finalweb10/admin/product/add" class="btn btn-primary">Them moi</a>
				<form class="form-inline" action="/finalweb10/admin/product/search" method="post">
					<input class="form-control" name="keyword" type="text" placeholder="Tim theo ten">
					<button type="submit" class="btn btn-danger">Tim</button>
				</form>
				<table class="table table-hover">
					<tr class="table-header">
						<th>ID</th>
						<th>Name</th>
						<th>Price</th>
						<th>description</th>
						<th>Image</th>
						<th>Danh muc</th>
						<th>Option</th>
					</tr>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.id }</td>
							<td>${product.name }</td>
							<td>${product.price }</td>
							<td>${product.description }</td>
							<td><img src="/finalweb10/download?image=${product.image }" width="100" /></td>
							<td>${product.category.name }</td>
							<td><a class="btn btn-success" href="/finalweb10/admin/product/update?id=${product.getId() }">Sua</a> | <a class="btn btn-danger"
								href="/finalweb10/admin/product/delete?id=${product.getId() }">Xoa</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>