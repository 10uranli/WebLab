<%@page import="eSattim.com.model.KategoriBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, eSattim.com.model.*, eSattim.com.dao.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	ArrayList<KategoriBean> katagoriler = KategoriDao.kategoriler();
	ArrayList<UrunBean> urunler = UrunDao.tumUrunler();
	ArrayList<UrunBean> se = (ArrayList<UrunBean>) request.getSession().getAttribute("sepet");
	request.setAttribute("katagoriler", katagoriler);
	request.setAttribute("urunler", urunler);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Home | E-Sattim.com</title>
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
<link rel="shortcut icon" href="Bootstrap/images/ico/favicon.ico">
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
								<li><a href="#"><i class="fa fa-phone"></i> +90 500 000
										00 00</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i>
										info@esattim.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
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
							<a href="home.jsp"><img src="Bootstrap/images/home/logo.png"
								alt="" /></a>
						</div>

					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<c:if test="${not empty admin}">
									<li><a href="admin.jsp"><i class="fa fa-cogs"></i>
											Admin Paneli</a></li>
									<li><a href="/eSattim.com/logout"><i
											class="fa fa-user"></i>Çıkış yap</a></li>
								</c:if>
								<c:if test="${not empty alici}">
									<li><a href="userprofil.jsp"><i class="fa fa-user"></i>${alici.USER_AD}</a></li>
									<li><a href="sepet.jsp"><i class="fa fa-shopping-cart"></i>
											Sepet(${sepet.size()})</a></li>
									<li><a href="siparislerim.jsp"><i class="fa fa-money"></i>Siparişlerim</a></li>
									<li><a href="/eSattim.com/logout"><i
											class="fa fa-sign-out"></i>Çıkış yap</a></li>
								</c:if>
								<c:if test="${empty alici && empty admin}">
									<li><a href="loginreg.jsp"><i class="fa fa-lock"></i>
											Giriş</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->

	<section id="slider">
		<!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0"
								class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1>
										<span>e</span>-Sattim.com
									</h1>
									<h2>Alışveriş Durağınız</h2>
									<p>e-Sattim.com Keyifli Alışverişler Diler.</p>
									<button type="button" class="btn btn-default get">Alışverişe
										Başla</button>
								</div>
								<div class="col-sm-6">
									<img src="Bootstrap/images/home/girl1.jpg"
										class="girl img-responsive" alt="" /> <img
										src="Bootstrap/images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1>
										<span>e</span>-Sattim.com
									</h1>
									<h2>Alışveriş Durağınız</h2>
									<p>e-Sattim.com Keyifli Alışverişler Diler.</p>
									<button type="button" class="btn btn-default get">Alışverişe
										Başla</button>
								</div>
								<div class="col-sm-6">
									<img src="Bootstrap/images/home/girl2.jpg"
										class="girl img-responsive" alt="" /> <img
										src="Bootstrap/images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>

							<div class="item">
								<div class="col-sm-6">
									<h1>
										<span>e</span>-Sattim.com
									</h1>
									<h2>Alışveriş Durağınız</h2>
									<p>e-Sattim.com Keyifli Alışverişler Diler.</p>
									<button type="button" class="btn btn-default get">Alışverişe
										Başla</button>
								</div>
								<div class="col-sm-6">
									<img src="Bootstrap/images/home/girl3.jpg"
										class="girl img-responsive" alt="" /> <img
										src="Bootstrap/images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>

						</div>

						<a href="#slider-carousel" class="left control-carousel hidden-xs"
							data-slide="prev"> <i class="fa fa-angle-left"></i>
						</a> <a href="#slider-carousel"
							class="right control-carousel hidden-xs" data-slide="next"> <i
							class="fa fa-angle-right"></i>
						</a>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!--/slider-->

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>KATEGORİLER</h2>
						<div class="panel-group category-products">
							<!--Kategori-Listesi-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<c:forEach items="${katagoriler}" var="katagoriler">
											<a href="kurunget?katagoriNo=${katagoriler.getId()}"
												class="list-group-item">${katagoriler.getKtgAd()}</a>
										</c:forEach>
										<c:choose>
											<c:when test="${not empty katagoriUrun}">
												<a href="home.jsp"
													class="list-group-item">Tüm Ürünler</a>
											</c:when>
										</c:choose>

									</h4>
								</div>
							</div>
						</div>
						<!--/category-products-->
					</div>
				</div>

				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<!--features_items-->
						<h2 class="title text-center">Ürünler</h2>
						<c:choose>
							<c:when test="${not empty katagoriUrun}">
								<c:forEach items="${katagoriUrun}" var="katagoriUrun">
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img style="width: 320px; height: 150px;"
														src="<c:url value="/resimGetir?mresim=${katagoriUrun.urunid} "/>"
														alt="" />
													<h2>${katagoriUrun.urunfiyat}TL</h2>
													<p>${katagoriUrun.urunad}</p>
													<a href="sepetekle?urunID=${katagoriUrun.urunid}"
														id="sepet" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Sepete Ekle</a> 
												</div>

											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach items="${urunler}" var="urunler">
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img style="width: 320px; height: 150px;"
														src="<c:url value="/resimGetir?mresim=${urunler.urunid} "/>"
														alt="" />
													<h2>${urunler.urunfiyat}TL</h2>
													<p>${urunler.urunad}</p>

													<a href="sepetekle?urunID=${urunler.urunid}" id="sepet"
														class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Sepete Ekle</a> 
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<!--features_items-->




				</div>
			</div>
		</div>
	</section>

	<footer id="footer">
		<!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2>
								<span>e</span>-Sattim.com
							</h2>
							<p>Ondokuz Mayıs University - Computer Engeneering</p>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="pull left address">
							<img src="Bootstrap/images/home/map.png" alt="" />
							<p>Kurupelit Kampüsü, 55270 Atakum/Samsun Telefon: (0362) 312
								1919 Kuruluş: 1 Nisan 1975, Samsun</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2016 e-Sattim.com Inc. All
						rights reserved.</p>
					<p class="pull-right">
						
							
					</p>
				</div>
			</div>
		</div>

	</footer>
	<!--/Footer-->


	<script src="Bootstrap/js/jquery.js"></script>
	<script src="Bootstrap/js/bootstrap.min.js"></script>
	<script src="Bootstrap/js/jquery.scrollUp.min.js"></script>
	<script src="Bootstrap/js/price-range.js"></script>
	<script src="Bootstrap/js/jquery.prettyPhoto.js"></script>
	<script src="Bootstrap/js/main.js"></script>
	<script type="text/javascript">
	</script>
</body>
</html>