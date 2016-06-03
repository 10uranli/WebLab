<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">




<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" contesnt="">
<meta name="author" content="">

<title>e-Sattim.com | Hoş Geldiniz</title>

<!-- Bootstrap Core CSS -->
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="Bootstrap/css/full-slider.css" rel="stylesheet">

<script>
	$('#myModal').modal('show');
</script>

</head>

<body>

	<!-- Full Page Image Background Carousel Header -->
	<header id="myCarousel" class="carousel slide">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for Slides -->
		<div class="carousel-inner">
			<div class="item active">
				<!-- Set the first background image using inline CSS below. -->
				<div class="fill"
					style="background-image: url('Bootstrap/img/1.jpg');"></div>
				<div class="carousel-caption">
					<button class="btn btn-success" data-toggle="modal"
						data-target="#myModal">Kayıt-Giriş</button>
					<button type="button" class="btn btn-warning">
						<b><a href="home.jsp">Üye Olmadan Devam Et</a></b>
					</button>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill"
					style="background-image: url('Bootstrap/img/2.jpg');"></div>
				<div class="carousel-caption">
					<div class="carousel-caption">
						<button class="btn btn-success" data-toggle="modal"
							data-target="#myModal">Kayıt-Giriş</button>
						<button type="button" class="btn btn-warning">
							<b><a href="home.jsp">Üye Olmadan Devam Et</a></b>
						</button>
					</div>
				</div>
			</div>
			<div class="item">
				<!-- Set the third background image using inline CSS below. -->
				<div class="fill"
					style="background-image: url('Bootstrap/img/3.jpg');"></div>
				<div class="carousel-caption">
					<div class="carousel-caption">
						<button class="btn btn-success" data-toggle="modal"
							data-target="#myModal">Kayıt-Giriş</button>
						<button type="button" class="btn btn-warning">
							<b><a href="home.jsp">Üye Olmadan Devam Et</a></b>
						</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="icon-prev"></span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span class="icon-next"></span>
		</a>

	</header>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						<b>e-Sattim.com</b>
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12"
							style="border-right: 1px dotted #C2C2C2; padding-right: 30px;">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs">
								<li class="active"><a href="#Login" data-toggle="tab">Giriş
										Yap</a></li>
								<li><a href="#Registration" data-toggle="tab">Üye Ol</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane active" id="Login">
									<form role="form" class="form-horizontal" action="login"
										method="post">
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">
												Email</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" name="emaillog"
													placeholder="Email" required />
											</div>
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1"
												class="col-sm-2 control-label"> Şifre</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" name="sifrelog"
													placeholder="Sifre" required />
											</div>
										</div>
										<div class="row">
											<div class="col-sm-2"></div>
											<div class="col-sm-10">
												<button type="submit" class="btn btn-primary btn-sm">
													Giriş Yap</button>
												<a href="javascript:;">Şifrenizi mi unuttunuz ?</a>
											</div>
										</div>
									</form>
								</div>
								<div class="tab-pane" id="Registration">
									<form role="form" class="form-horizontal" action="register"
										method="post">
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">
												İsim :</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="isim"
													placeholder="İsim.." />
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">
												Soyisim :</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="soyisim"
													placeholder="Soyisim.." />
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">
												Email :</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" name="email"
													placeholder="Email.." />
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">
												Şifre :</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" name="sifre"
													placeholder="Şifre" />
											</div>
										</div>


										<div class="row">
											<div class="col-sm-2"></div>
											<div class="col-sm-10">
												<button type="submit" class="btn btn-primary btn-sm">
													Kaydet ve Devam Et</button>
												<button type="reset" class="btn btn-default btn-sm">
													İptal Et</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="Bootstrap/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="Bootstrap/js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 10000
		//changes the speed
		})
	</script>
	<c:if test="${not empty alici }">
		<jsp:forward page="home.jsp"></jsp:forward>
	</c:if>
</body>
</html>
