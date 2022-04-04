<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Shop Item - Start Bootstrap Template</title>
<!-- Bootstrap core CSS -->
<link href="/finalweb10/style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/finalweb10/style/client/shop-item.css" rel="stylesheet">
</head>
<body>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<jsp:include page="/views/client/common/menu.jsp"></jsp:include>
			</div>
			<!-- /.col-lg-3 -->
			<div class="col-lg-9">
				<div class="card mt-4">
					<img class="card-img-top img-fluid" src="/finalweb10/download?image=${product.image }" alt="">
					<div class="card-body">
						<h3 class="card-title">${product.name }</h3>
						<h4>${product.price }vnd</h4>
						<p class="card-text">${product.description }</p>
						<a href="/finalweb10/add-to-cart?pid=${product.id }" class="btn btn-danger">Add to cart</a>
					</div>
				</div>
			</div>
			<!-- /.col-lg-9 -->
		</div>
	</div>
	<!-- /.container -->
	<jsp:include page="/views/client/common/footer.jsp"></jsp:include>
</body>
</html>
