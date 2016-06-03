<%@page import="eSattim.com.dao.RegisterDao"%>
<%@page import="eSattim.com.model.RegisterBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="eSattim.com.dao.UserDao"%>
<%@page import="eSattim.com.model.UserBean"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<RegisterBean> kl = new RegisterDao().AllCustomer();
	request.setAttribute("kl", kl);
	ArrayList<RegisterBean> adm = new RegisterDao().adminGetir();
	request.setAttribute("adm", adm);
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
								<li id="welcome"><b>Üye İşlemleri Sayfası</b></li>
								<li><a href="/eSattim.com/logout" class="logout"> <span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
										log out
								</a></li>
							</ul>
						</div>
					</header>
				</div>

				<div id="tab" class="btn-group btn-group-justified"
					data-toggle="buttons-radio">
					<a href="#CustomerList" class="btn  btn-large btn-danger active"
						data-toggle="tab">Kullanıcı Listele-Sil-Rol Ekle</a> <a
						href="#CustomerAll" class="btn btn-large btn-danger"
						data-toggle="tab">Tüm Kullanıcılar</a> <a href="#AdminList"
						class="btn btn-large btn-danger" data-toggle="tab">Admin Sil</a>
				</div>

				<div class="tab-content">
					<div class="tab-pane fade fade in active " id="CustomerList">


						<center>
							<form action="araServlet" method="post">
								<input type="text" class="form-control" name="arama" required
									style="text-align: center;"
									placeholder="Kullanıcı Email ile Arama Yapın" />
								<button class="btn btn-default" type="submit">Ara!</button>
							</form>
						</center>

					</div>
					<div class="tab-pane fade" id="CustomerAll">

						<table class="table">
							<thead>
								<tr>
									<th>ID:</th>
									<th>Ad:</th>
									<th>Soyad:</th>
									<th>Email:</th>
									<th>Gsm NO:</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${kl}" var="kul">
									<tr>
										<td>${kul.USER_ID}</td>
										<td>${kul.USER_AD}</td>
										<td>${kul.USER_SOYAD}</td>
										<td>${kul.USER_EMAIL}</td>
										<td>${kul.USER_GSM}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

					<div class="tab-pane fade " id="AdminList">
						<table class="table">
							<thead>
								<tr>
									<th>ID:</th>
									<th>Ad</th>
									<th>Email:</th>
									<th>Çıkar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${adm}" var="adm">
									<tr>
										<td>${adm.USER_ID}</td>
										<td>${adm.USER_AD}</td>
										<td>${adm.USER_EMAIL}</td>
										<td><a href=adminSil?id=${adm.USER_ID}>Admin Çıkar</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

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