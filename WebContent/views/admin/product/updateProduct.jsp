<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form html</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<form action="/finalweb10/admin/product/update" method="post">
					<div class="form-group">
						<label>ID:</label> <input value="${product.id }" class="form-control" name="id" type="text" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Tên:</label> <input value="${product.name }" class="form-control" type="text" name="name" placeholder="Nhap ten">
					</div>
					<div class="form-group">
						<label>Giá:</label> <input value="${product.price }" class="form-control" type="text" name="price" placeholder="Nhap gia">
					</div>
					<div class="form-group">
						<label>description:</label> <input value="${product.description }" class="form-control" type="text" name="description" placeholder="Nhap description">
					</div>
					<div class="form-group">
						<label>Image URL:</label> <input value="${product.image }" class="form-control" type="text" name="image" placeholder="Nhap image">
					</div>
					<div class="form-group">
						<label>Category:</label> <select class="form-control" name="categoryId">
							<c:forEach items="${categoryList}" var="category">
								<option value="${category.id}">${category.name }</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<input class="btn btn-primary" type="submit" value="Update">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>