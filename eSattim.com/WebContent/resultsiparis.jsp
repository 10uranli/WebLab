<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="eSattim.com.dao.*"%>
<%@page import="eSattim.com.model.SiparisBean"%>
<%

	request.getAttribute("spr");
	request.getAttribute("sprUID");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Admin Yönetici Sayfası</title>
<!-- Bootstrap -->
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="Bootstrap/css/font-awesome.min.css">

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="Bootstrap/css/admincss.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="Bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid display-table">
		<div class="row display-table-row">
			<!-- SİDE MENU -->
			<div class="col-md-2 display-table-cell valign-top" id="side-menu">
				<h1>ADMİN SAYFASI</h1>
				<ul>

					<li class="link"><a href="home.jsp"> <span
							class="glyphicon glyphicon-home" aria-hidden="true"></span> <span>eSattim|AnaSayfa</span>
					</a></li>
					<li class="link"><a href="admin.jsp"> <span
							class="glyphicon glyphicon-th" aria-hidden="true"></span> <span>Admin
								Ana Sayfası</span>
					</a></li>
					<li class="link"><a href="customer.jsp"> <span
							class="glyphicon glyphicon-user" aria-hidden="true"></span> <span>Üye
								İşlemleri</span>
					</a></li>

					<li class="link"><a href="product.jsp"> <span
							class="glyphicon glyphicon-gift" aria-hidden="true"></span> <span>Ürün
								İşlemleri</span>
					</a></li>

					<li class="link"><a href="order.jsp"> <span
							class="glyphicon glyphicon-send" aria-hidden="true"></span> <span>Sipariş
								İşlemleri</span>
					</a></li>
				</ul>
			</div>

			<!-- MAİN AREA-->
			<div class="col-md-10 display-table-cell valign-top box">
				<div class="row">
					<header id="nav-header" class="clearfix">
						<div class="col-md-12">
							<ul class="pull-right">
								
								<li><a href="/eSattim.com/logout" class="logout"> <span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
										log out
								</a></li>
							</ul>
						</div>
					</header>
				</div>

				<center>
					<table class="table">
						<thead>
							<tr>
								<th>Siparis ID:</th>
								<th>Ürün ID:</th>
								<th>Ürün Ad:</th>
								<th>Müşteri ID:</th>
								<th>Müşteri Ad:</th>
								<th>Müşteri Email:</th>
								<th>Siparis Durumu:</th>
								<th>Kargo Tercihi:</th>
								<th>Taksit Sayısı:</th>
								<th>Adres:</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${spr}" var="siparis">
								<tr>
									<td>${siparis.SIPARIS_ID}</td>
									<td>${siparis.URUN_ID}</td>
									<td>${siparis.URUN_AD}</td>
									<td>${siparis.MUSTERI_ID}</td>
									<td>${siparis.MUSTERI_AD}</td>
									<td>${siparis.MUSTERI_EMAIL}</td>
									<td>${siparis.SIPARIS_DURUM}</td>
									<td>${siparis.KARGO_TERCIH}</td>
									<td>${siparis.TAKSIT_SAY}</td>
									<td>${siparis.ADRES}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</center>







				<div class="row">
					<footer id="admin-footer" class="clearfix">
						<div class="pull-left">
							
						</div>
						<div class="pull-right">e-Sattim.com Yönetim Sayfası</div>
					</footer>
				</div>
			</div>
		</div>
	</div>
</body>
</html>