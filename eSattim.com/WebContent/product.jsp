<%@page import="eSattim.com.dao.RegisterDao"%>
<%@page import="eSattim.com.model.RegisterBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@page import="eSattim.com.dao.KategoriDao"%>
<%@page import="eSattim.com.model.KategoriBean"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<KategoriBean> ktg = new KategoriDao().kategoriler();
	request.setAttribute("ktg", ktg);
	ResultSet resultset = null;
%>
<!DOCTYPE html>
<html>
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
								<li id="welcome"><b>Ürün İşlemleri Sayfası</b></li>
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
					<a href="#Urun" class="btn  btn-large btn-danger active"
						data-toggle="tab">ÜRÜNLER</a> <a href="#Kategori"
						class="btn btn-large btn-danger" data-toggle="tab">KATEGORİLER</a>
				</div>

				<div class="tab-content">
					<div class="tab-pane fade fade in active" id="Urun">
						<div id="tab" class="btn-group btn-group-justified"
							data-toggle="buttons-radio">
							<a href="#Ulist" class="btn btn-large btn-warning active"
								data-toggle="tab"> Ürünleri Listele</a> <a href="#Uadd"
								class="btn btn-large btn-warning" data-toggle="tab">Ürün
								ekle</a> <a href="#Udell" class="btn btn-large btn-warning"
								data-toggle="tab">Ürün Sil</a>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade fade in active " id="Ulist">
								<form action="ktgUrunList" method="post">
									<center>
										<h3>Ürün Kategorisi :</h3>
										<%
											try {
												Connection con = null;
												final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
												final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
												final String User = "onur";
												final String Password = "1234Onur.";

												Class.forName(OJDBC_DRIVER);
												con = (Connection) DriverManager.getConnection(DB_URL, User, Password);
												Statement statement = con.createStatement();
												resultset = statement.executeQuery("SELECT * FROM KTG_TBL");
										%>
										<select name="ktgsec">
											<%
												while (resultset.next()) {
											%>
											<option><%=resultset.getString(2)%></option>
											<%
												}
											%>
										</select>
										<%
											//**Should I input the codes here?**
											} catch (Exception e) {
												out.println("wrong entry" + e);
											}
										%>
										<button class="btn btn-default" type="submit">Ürünleri
											Listele</button>
									</center>
								</form>
							</div>
							<div class="tab-pane fade " id="Uadd">
								<form action="UEkleServlet" method="post"
									enctype="multipart/form-data">
									<div class="container">
										<div class="row">
											<div class="col-lg-4 col-lg-offset-4">
												<div class="input-group">
													<h3>Ürün Kategorisi :</h3>
													<%
														try {
															Connection con = null;
															final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
															final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
															final String User = "onur";
															final String Password = "1234Onur.";

															Class.forName(OJDBC_DRIVER);
															con = (Connection) DriverManager.getConnection(DB_URL, User, Password);
															Statement statement = con.createStatement();
															resultset = statement.executeQuery("SELECT * FROM KTG_TBL");
													%>
													<select name="ktgsec">
														<%
															while (resultset.next()) {
														%>
														<option><%=resultset.getString(2)%></option>
														<%
															}
														%>
													</select>
													<%
														//**Should I input the codes here?**
														} catch (Exception e) {
															out.println("wrong entry" + e);
														}
													%>

													<h3>Ürün İsmi :</h3>
													<input type="text" class="form-control" name="urunname"
														required />
													<h3>Ürün Fiyatı :</h3>
													<input type="text" class="form-control" name="urunfiyat"
														required />
													<h3>Ürün Açıklaması :</h3>
													<input type="text" class="form-control" name="urunaciklama"
														required />
													<h3>Ürün Anahtar Kelimeleri :</h3>
													<input type="text" class="form-control" name="urunanahtar"
														required /> <input type="file" name="photo" required/><br />
													<button class="btn btn-default" type="submit">Ürün
														Ekle</button>
												</div>
												<!-- /input-group -->
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="tab-pane fade " id="Udell">
								<center>
									<form action="urunIdSil" method="post">
										<div class="container">
											<div class="row">
												<div class="col-lg-4 col-lg-offset-4">
													<div class="input-group">
														<h3>Lütfen Silmek İstediğiniz Ürün ID'sini Giriniz :</h3>
														<input type="text" class="form-control" name="urunId"
															required />
														<button class="btn btn-default" type="submit">Ürün
															Sil</button>
													</div>
													<!-- /input-group -->
												</div>
											</div>
										</div>
									</form>
								</center>
							</div>
						</div>

					</div>
					<div class="tab-pane fade" id="Kategori">
						<div id="tab" class="btn-group btn-group-justified"
							data-toggle="buttons-radio">
							<a href="#Klist" class="btn btn-large btn-warning active"
								data-toggle="tab"> Kategorileri Listele</a> <a href="#Kadd"
								class="btn btn-large btn-warning" data-toggle="tab">Kategori
								ekle</a> <a href="#Kdell" class="btn btn-large btn-warning"
								data-toggle="tab">Kategori Sil</a>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade fade in active " id="Klist">
								<center>
									<table class="table">
										<thead>
											<tr>
												<th>Kategori ID:</th>
												<th>Kategori Adı:</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${ktg}" var="kategori">
												<tr>
													<td>${kategori.getId()}</td>
													<td>${kategori.getKtgAd()}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</center>
							</div>
							<div class="tab-pane fade" id="Kadd">
								<form action="kategoriServlet" method="post">

									<div class="container">
										<div class="row">
											<div class="col-lg-4 col-lg-offset-4">
												<div class="input-group">
													<h3>Lütfen Eklemek İstediğiniz Kategori İsmini Giriniz
														:</h3>
													<input type="text" class="form-control" name="ktgname"
														required />
													<button class="btn btn-default" type="submit">Kategori Ekle</button>
												</div>
												<!-- /input-group -->
											</div>
										</div>
									</div>
								</form>
							</div>

							<div class="tab-pane fade" id="Kdell">
								<form action="KtgSilServlet" method="post">
									<center>
										<h3>Silmek İstediğiniz Kategoriyi Seçiniz:</h3>
										<h5>NOT:Kategoriyle beraber o kategoriye ait tüm
											ürünlerde silinecektir!</h5>
										<%
											try {
												Connection con = null;
												final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
												final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
												final String User = "onur";
												final String Password = "1234Onur.";

												Class.forName(OJDBC_DRIVER);
												con = (Connection) DriverManager.getConnection(DB_URL, User, Password);
												Statement statement = con.createStatement();
												resultset = statement.executeQuery("SELECT * FROM KTG_TBL");
										%>
										<select name="ktgsec">
											<%
												while (resultset.next()) {
											%>
											<option><%=resultset.getString(2)%></option>
											<%
												}
											%>
										</select>
										<%
											//**Should I input the codes here?**
											} catch (Exception e) {
												out.println("wrong entry" + e);
											}
										%>
										<button class="btn btn-default" type="submit">Kategori
											Sil</button>
									</center>
								</form>
							</div>

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