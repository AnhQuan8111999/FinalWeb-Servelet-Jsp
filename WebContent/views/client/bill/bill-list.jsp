<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gio hang</title>
</head>
<body>
	<h2>Thong tin don hang:</h2>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nguoi mua</td>
			<td>Ngay mua</td>
			<td>Tong tien</td>
			<td>Lua chon</td>
		</tr>
		<c:forEach items="${bills}" var="bill">
			<tr>
				<td>${bill.id }</td>
				<td>${bill.buyer.name }</td>
				<td>${bill.buyDate }</td>
				<td>${bill.priceTotal }</td>
				<td><a href="/finalweb10/member/bill-product?billid=${bill.id }">Xem chi tiet</a> 
				| <a href="/finalweb10/member/bill/delete?billid=${bill.id }">Xoa don</a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>