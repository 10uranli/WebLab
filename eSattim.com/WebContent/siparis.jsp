<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eSattim.com.dao.*"%>
<%@page import="eSattim.com.model.*"%>
<%
	ArrayList<UrunBean> sepet = (ArrayList<UrunBean>) session.getAttribute("sepet");
	request.setAttribute("sepet", sepet);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Sepet| E-Sattim</title>
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="Bootstrap/css/font-awesome.min.css" rel="stylesheet">
<link href="Bootstrap/css/prettyPhoto.css" rel="stylesheet">
<link href="Bootstrap/css/price-range.css" rel="stylesheet">
<link href="Bootstrap/css/animate.css" rel="stylesheet">
<link href="Bootstrap/css/main.css" rel="stylesheet">
<link href="Bootstrap/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="Bootstrap/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="Bootstrap/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="Bootstrap/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="Bootstrap/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href=""><i class="fa fa-phone"></i> +2 95 01 88
										821</a></li>
								<li><a href=""><i class="fa fa-envelope"></i>
										admin@esattim.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href=""><i class="fa fa-facebook"></i></a></li>
								<li><a href=""><i class="fa fa-twitter"></i></a></li>
								<li><a href=""><i class="fa fa-linkedin"></i></a></li>
								<li><a href=""><i class="fa fa-dribbble"></i></a></li>
								<li><a href=""><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img
								src="Bootstrap/images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<c:if test="${not empty alici}">
									<li><a href="userprofil.jsp"><i class="fa fa-user"></i>${alici.USER_AD}</a></li>
									<li><a href="sepet.jsp"><i class="fa fa-shopping-cart"></i>
											Sepet(${sepet.size()})</a></li>
									<li><a href="siparislerim.jsp"><i class="fa fa-money"></i>Siparişlerim</a></li>
									<li><a href="/eSattim.com/logout"><i class="fa fa-sign-out"></i>Çıkış yap</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<section id="cart_items">
		<div class="container">
			<center>
				<h2>Siparis Listeniz</h2>
			</center>
			<div class="table-responsive cart_info">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Ürün Adı</th>
							<th>Ürün Fiyatı</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="toplamucret" value="${0}" />
						<c:set var="sira" value="${0}" />
						<c:forEach items="${sepet}" var="sepet">
							<tr>
								<td>${sepet.urunad}</td>
								<td>${sepet.urunfiyat}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<form action="siparisGonder" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="comment">Siparişin Gönderileceği Adres:</label>
						<textarea class="form-control" rows="5" name="adres" required></textarea>
					</div>
				</div>
				<div class="cold-md-6">
					<div class="row">
						<div class="col-md-6">
							<label for="sel1">Taksit Sayısı:</label> <select
								class="form-control" name="taksit">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
							</select>
						</div>
						<div class="col-md-6">
							<label for="sel1">Kargo Seçimi</label> <select
								class="form-control" name="kargo">
								<option>UPS</option>
								<option>Aras Kargo</option>
								<option>Yurtiçi Kargo</option>
								<option>Ptt Kargo</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="well pull-right">
								<button class="btn btn-success" type="submit">Siparişi
									Bitir</button>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
	</form>

	<script src="Bootstrap/js/jquery.js"></script>
	<script src="Bootstrap/js/bootstrap.min.js"></script>
	<script src="Bootstrap/js/jquery.scrollUp.min.js"></script>
	<script src="Bootstrap/js/jquery.prettyPhoto.js"></script>
	<script src="Bootstrap/js/main.js"></script>
</body>
</html>