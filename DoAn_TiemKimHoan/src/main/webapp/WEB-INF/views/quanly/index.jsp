<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="<c:url value='/assets/fontawesome-free-5.15.4-web/css/all.css' />"
	rel="stylesheet">
<!-- BOOTSTRAP STYLES-->
<link href="<c:url value='/assets/css/bootstrap.css' />"
	rel="stylesheet">
<link href="<c:url value='/assets/js/morris/morris-0.4.3.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/assets/css/custom.css' />" rel="stylesheet">
<title>CỬA HÀNG TRANG SỨC</title>
<base href="${pageContext.servletContext.contextPath}/">
</head>

</html>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.htm">QUẢN LÝ</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				Last access : 30 May 2014 &nbsp; <a href="#"
					class="btn btn-danger square-btn-adjust">Logout</a>
			</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img
						src="<c:url value='/assets/img/find_user.png' />"
						class="user-image img-responsive" /></li>


					<li><a class="active-menu" href="quanly/index.htm"><i
							class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
					<li><a href="quanly/canhan.htm"><i
							class="fa fa-user fa-3x"></i> Thông tin cá nhân</a></li>


					<li><a href="#"><i class="fa fa-clock-o fa-3x"></i> Quản
							Lý Đơn Hàng<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="quanly/hoadon.htm">ĐƠN NHẬP/XUẤT HÀNG</a></li>
							<li><a href="quanly/qlDatHang.htm">ĐƠN ĐẶT HÀNG</a></li>

						</ul></li>

					<li><a href="#"><i class="fa fa-sitemap fa-3x"></i> Quản
							lý Sản Phẩm<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="quanly/qlKhoHang.htm">LOẠI SẢN PHẨM</a></li>
							<li><a href="quanly/qlKhoHang.htm">KHO HÀNG</a></li>

						</ul></li>



					<li><a href="quanly/khachhang.htm"><i
							class="fa fa-sitemap fa-3x"></i> Quản lý Khách Hàng</a> <!-- <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul> --></li>

					<li><a href="quanly/nhanvien.htm"><i
							class="fa fa-sitemap fa-3x"></i> Quản lý Nhân viên</a></li>
					<li><a href="quanly/dichvu.htm"><i
							class="fa fa-sitemap fa-3x"></i> Quản lý Dịch Vụ<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="dichvu.htm">BẢO HÀNH SAU MUA</a></li>

						</ul></li>

					<li><a href="quanly/khuyenmai.htm"><i
							class="fa fa-sitemap fa-3x"></i> Quản lý Khuyến Mãi<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="quanly/khuyenmai.htm">KHUYẾN MÃI</a></li>
							<li><a href="quanly/khuyenmai.htm">ƯU ĐÃI KHÁCH HÀNG</a></li>

						</ul></li>
					<li><a href="quanly/thongke.htm"><i
							class="fa fa-table fa-3x"></i> Thống Kê <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="quanly/thongke.htm">Thống kê Hóa Đơn</a></li>
							<li><a href="quanly/thongke.htm">Thống kê Doanh Số</a></li>

						</ul></li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Admin Dashboard</h2>
					</div>
				</div>

				<hr />

				<div class="row">


					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">Bar Chart Example</div>
							<div class="panel-body">
								<div id="morris-bar-chart"></div>
							</div>
						</div>
					</div>


				</div>

				<!-- /. ROW  -->
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-6">
						<!--    Striped Rows Table  -->
						<div class="panel panel-default">
							<div class="panel-heading" style="color: blue;">Top Sản
								Phẩm bán chạy</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped">
										<thead>
														<tr>
															<th>MÃ SP</th>
															<th>TÊN SP</th>
															<th>Xem Chi Tiết</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="x" items="${arraysSP}">

															<tr>
																<td>${x.maSp}</td>
																<td>${x.tenSp}</td>
																<td><a
																	href="quanly/qlKhoHang/${x.maSp}.htm?xemThongTin">Xem</a></td>
															</tr>

														</c:forEach>
													</tbody>
									</table>
								</div>
							</div>
						</div>
						<!--  End  Striped Rows Table  -->
					</div>
					<div class="col-md-6">
						<!--    Bordered Table  -->
						<div class="panel panel-default">
							<div class="panel-heading" style="color: blue;">Top Khách
								Hàng tiềm năng trong 5 tháng gần nhất</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="table-responsive table-bordered">
									<table class="table">
										<thead>
										<tr>

											<th>MÃ KHÁCH HÀNG - SĐT</th>
											<th>TÊN KHÁCH HÀNG</th>
											<th>TIỀM NĂNG</th>
											<th>thêm</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${arrays}">
											<tr>
												<td>${a.sdt}</td>
												<td>${a.hoTen}</td>
												<td>${a.danhGiaTiemNang}</td>
												<td><a href="quanly/khachhang/${a.sdt}.htm?xemThongTin" onclick="document.geElementById('formKhachHang').style.display='none'">Xem</a></td>
											</tr>
										</c:forEach>

									</tbody>
									</table>
								</div>
							</div>
						</div>
						<!--  End  Bordered Table  -->
					</div>
				</div>
				<!-- /. ROW  -->

			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	


	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script type="text/javascript"
		src="<c:url value='/assets/js/jquery-1.10.2.js' />"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script type="text/javascript"
		src="<c:url value='/assets/js/bootstrap.min.js' />"></script>
	<!-- METISMENU SCRIPTS -->
	<script type="text/javascript"
		src="<c:url value='/assets/js/jquery.metisMenu.js' />"></script>
	<!-- MORRIS CHART SCRIPTS -->
	<script type="text/javascript"
		src="<c:url value='/assets/js/morris/raphael-2.1.0.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/js/morris/morris.js' />"></script>
	<!-- CUSTOM SCRIPTS -->
	<script type="text/javascript"
		src="<c:url value='/assets/js/custom.js' />"></script>
</body>
</html>