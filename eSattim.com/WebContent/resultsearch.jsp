<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="eSattim.com.dao.KisilerDao"%>
<%@page import="eSattim.com.model.KisilerBean"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	HttpSession se = request.getSession();
	se.getAttribute("rehber");
%>
<c:if test="${empty rehber}">
	<%
		response.setHeader("Refresh", "1; URL=customer.jsp");
	%>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Kullanıcı Listele</title>
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
								<li id="welcome"><b>Üye İşlemleri Sayfası</b></li>
								<li><a href="#" class="logout"> <span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
										log out
								</a></li>
							</ul>
						</div>
					</header>
				</div>
				<c:if test="${empty rehber}">
					<center><h1>Kullanıcı Bulunamadı!</h1></center>
				</c:if>
				<c:if test="${not empty rehber}">
					<div class="container">
						<div class="row">
							<div class="col-lg-8">
								<h2>Kullanıcılar</h2>
								<p>Arama Sonucu Listelenen Kullanıcılar:</p>
								<table class="table">
									<thead>
										<tr>
											<th>ID</th>
											<th>İSİM</th>
											<th>SOYİSİM</th>
											<th>EMAİL</th>
											<th>ROLL</th>
											<th>Rol Ekle</th>
											<th>Sil</th>
										</tr>
									</thead>
									<c:forEach items="${rehber}" var="kisi">
										<tbody>
											<tr>
												<td>${kisi.id}</td>
												<td>${kisi.isim}</td>
												<td>${kisi.soyisim}</td>
												<td>${kisi.email}</td>
												<td>${kisi.roll}</td>
												<td><a href=customerAdmin?id=${kisi.id}>Admin
														Yap</a></td>
												<td><a href=customerDel?id=${kisi.id}>Sil</a></td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</c:if>

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