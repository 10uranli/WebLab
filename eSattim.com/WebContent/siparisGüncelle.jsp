<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	HttpSession se = request.getSession(true);
	int id = Integer.parseInt(request.getParameter("id"));
	request.setAttribute("id", id);
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
<link rel="stylesheet" type="text/css" href="Bootstrap/css/uruncss.css">
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
							class="glyphicon glyphicon-home" aria-hidden="true"></span>
							<span>eSattim|AnaSayfa</span>
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
								<li id="welcome"><b>Sipariş Güncelleme Sayfası</b></li>
								<li><a href="/eSattim.com/logout" class="logout"> <span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
										log out
								</a></li>
							</ul>
						</div>
					</header>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-md-6">
							<form action="SiparisDurumGuncelle" method="post">
								<center>
									<input name="sipid" class="form-control" type="text"
										value="${id}"> <select class="form-control"
										name="durum" >
										<option>Siparis Hazirlaniyor</option>
										<option>Siparis Kargo Subesinde</option>
										<option>Siparis Kargo Dagitiminda</option>
										<option>Siparis Teslim Edildi</option>
										<option>İptal</option>
									</select>
									<button class="btn btn-primary" type="submit">Sipariş
										Durumunu Güncelle</button>
								</center>
							</form>
						</div>
					</div>
				</div>


				<div class="row">
					<footer id="admin-footer" class="clearfix">
						<div class="pull-left">
							<b> </b>
						</div>
						<div class="pull-right"></div>
					</footer>
				</div>
			</div>
		</div>
	</div>
</body>
</html>