<%@page import="eSattim.com.model.UserBean"%>
<%@page import="eSattim.com.model.RegisterBean"%>
<%@page import="eSattim.com.dao.SiparisDao"%>
<%@page import="eSattim.com.model.SiparisBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
RegisterBean kullanici = (RegisterBean)session.getAttribute("alici");
ArrayList<SiparisBean> siparislerim = SiparisDao.UIDSiparis(kullanici.getUSER_ID());
request.setAttribute("siparislerim", siparislerim);

%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Siparislerim | E-Sattim</title>
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
							<a href="home.jsp"><img
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
			<div class="table-responsive cart_info">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Ürün Resmi</th>
							<th>Ürün Adı</th>
							<th>Sipariş Durumu</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${siparislerim}" var="siparislerim">
							<tr>
								<td><img style="width: 80px; height: 40px;"
									src="<c:url value="/resimGetir?mresim=${siparislerim.URUN_ID} "/>"
									alt="" /></td>
								<td>${siparislerim.URUN_AD}</td>
								<td>${siparislerim.SIPARIS_DURUM}</td>
							</tr>
							<c:set var="sira" value="${sira+1}"></c:set>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>


	<script src="Bootstrap/js/jquery.js"></script>
	<script src="Bootstrap/js/bootstrap.min.js"></script>
	<script src="Bootstrap/js/jquery.scrollUp.min.js"></script>
	<script src="Bootstrap/js/jquery.prettyPhoto.js"></script>
	<script src="Bootstrap/js/main.js"></script>
</body>
</html>