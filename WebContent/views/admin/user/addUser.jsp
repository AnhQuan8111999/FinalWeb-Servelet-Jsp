<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<form action="/finalweb10/admin/user/add" method="post">
					<div class="form-group">
						<label>Name : </label> <input class="form-control" type="text" name="name">
					</div>
					<div class="form-group">
						<label>UserName : </label> <input class="form-control" required="required" type="text" name="username">
					</div>
					<div class="form-group">
						<label>Password : </label> <input class="form-control" required="required" type="Password" name="password">
					</div>
					<div class="form-group">
						<label>Tuổi:</label> <input class="form-control" required="required" type="number" name="age" placeholder="Nhập tuổi">
					</div>
					<div class="form-group">
						<label>Gender : </label> <input type="radio" name="gender" value="M" checked="checked">Nam <input type="radio" name="gender" value="F">Nu
					</div>
					<div class="form-group">
						<label>ROLE : </label> <label>Role: </label> <select name="role" class="form-control">
							<option value="ROLE_MEMBER">ROLE_MEMBER</option>
							<option value="ROLE_ADMIN" selected>ROLE_ADMIN</option>
						</select>
					</div>
					<div class="form-group">
						<label>Ảnh URL:</label> <input value="${user.image}" name="image" class="form-control" type="text"></input>
					</div>
					<div class="form-group">
						<button class="btn btn-primary" type="submit">Them</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>