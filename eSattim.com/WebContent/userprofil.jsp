<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, eSattim.com.model.*, eSattim.com.dao.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-Sattim.com-Kullanıcı Bilgilerini Güncelle..</title>
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
<body>
	<header id="header"> <!--header-->
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
							<c:if test="${not empty alici}">
									<li><a href="userprofil.jsp"><i class="fa fa-user"></i>${alici.USER_AD}</a></li>
									<li><a href="sepet.jsp"><i class="fa fa-shopping-cart"></i>
											Sepet(${sepet.size()})</a></li>
									<li><a href="siparislerim.jsp"><i class="fa fa-money"></i>Siparişlerim</a></li>
									<li><a href="/eSattim.com/logout"><i
											class="fa fa-sign-out"></i>Çıkış yap</a></li>
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
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-bottom--> </header>
	<div class="container">
		<div class="row">
			<form action="profilGuncelle" method="post">
				<h2>Kullanıcı Profili:</h2>
				<p>Güncellemek istediğiniz alanları değiştirip butona
					tıklayınız.</p>
				<div class="form-group">
					<input name="id" type="hidden" class="form-control"
						value="${alici.USER_ID}" required>
				</div>
				<h5>ADINIZ :</h5>
				<div class="form-group">
					<input name="name" type="text" class="form-control"
						value="${alici.USER_AD}" required>
				</div>
				<h5>SOYADINIZ :</h5>
				<div class="form-group">
					<input name="surname" type="text" class="form-control"
						value="${alici.USER_SOYAD}" required>
				</div>
				<h5>EMAIL ADRESİNİZ:</h5>
				<div class="form-group">
					<input name="email" type="text" class="form-control"
						value="${alici.USER_EMAIL}" required>
				</div>
				<h5>ŞİFRENİZ:</h5>
				<div class="form-group">
					<input name="pass" type="password" class="form-control"
						value="${alici.USER_PASS}" required>
				</div>
				<h5>GSM NUMARANIZ:</h5>
				<div class="form-group">
					<input name="gsm" type="text" class="form-control"
						value="${alici.USER_GSM}" required>
				</div>
				<button class="btn btn-default" type="submit">Güncelle</button>

			</form>

		</div>
	</div>
</body>
</html>