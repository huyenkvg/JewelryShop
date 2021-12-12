<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
				<a class="navbar-brand" href="quanly/index.htm">QUẢN LÝ</a>
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
							<li><a href="quanly/dichvu.htm">BẢO HÀNH SAU MUA</a></li>

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
					<li><a href="quanly/blank.htm"><i
							class="fa fa-square-o fa-3x"></i> Blank Page</a></li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>QUẢN LÝ ĐƠN ĐẶT HÀNG</h2>
						<h5>Welcome HUYEN_KUTE , Love to see you back.</h5>



							<form:form action="quanly/qlDatHang.htm"
								modelAttribute="donDatHangDangXem" class="col-md-5"
								method="POST">

								<h3>THÔNG TIN ĐƠN ĐẶT HÀNG</h3>
								<div class="form-group">
									<label>Mã Đơn Hàng </label>
									<form:input path="maDh" class="form-control" id="inputSuccess" />
								</div>
								<div class="form-group">
									<label>Mã Khách Hàng</label>
									<form:input path="maKhachHang" class="form-control"
										id="inputSuccess" />
								</div>

								<div class="form-group">
									<label>Phương Thức Mua Hàng: </label> Online
									<form:input path="phuongThuc" class="form-control"
										id="inputSuccess" type="hidden" />
								</div>
								<div class="form-group">
									<label>Ngày Đặt Hàng</label>
									<input name="ngayDH" class="form-control" id="inputSuccess" value = "${donDatHangDangXem.ngay}"/>
								</div>
								<div class="form-group">
									<label>Địa Chỉ Giao Hàng</label> <form:input path="diaChi"
										class="form-control" id="inputSuccess" required="required"/>
								</div>
								<div class="form-group">
									<label>Mã Giảm Giá </label> 
									<form:input path="maGiamGia" class="form-control"
										id="inputSuccess" type="text" />
								</div>
								<div class="form-group"
									style="margin-left: 50; padding: 0px 0px 0px 270px;">
									<button name="btnLapHD" type="submit" class="btn btn-success">Lập
										Hóa Đơn</button>
								</div>

							</form:form>
							<br>


						<div class="panel-body col-md-7">

							<h3>Chi Tiết Đơn Đặt Hàng</h3>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>MÃ SẢN PHẨM</th>
											<th>KÍCH THƯƠC</th>
											<th>SỐ LƯỢNG</th>
											<th>GIÁ TIỀN</th>
											<th>GHI CHÚ</th>
											<th></th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${listCTDH}">
											<tr>
												<td>${a.maSanPham}</td>
												<td>${a.size}</td>
												<td>${a.soLuong}</td>
												<td>${a.gia}</td>
												<td>${a.ghiChu}</td>

											</tr>
										</c:forEach>


									</tbody>
								</table>


							</div>
						</div>

					</div>

					<!-- =================================================================================================== -->
					<div class="col-md-12">
						<div class="panel-heading col-md-6 text-info">
							<h3>
								<span>Danh Sách Đơn Đặt Hàng</span>
							</h3>
						</div>
						<div>

							<form role="form" action="quanly/qlDatHang.htm">
								<div class="form-group col-md-5">
									<label class="control-label" for="inputSuccess">Tìm
										Kiếm (Mã Đơn Hàng):</label>
									<c:if test="${messageTimKiem!= null}">
										<label class="control-label"
											style="color: red; float: right; font-size: 13px;"">
											${messageTimKiem}</label>
									</c:if>
									<input name="idDDH" type="text" class="form-control"
										id="inputSuccess">
								</div>

								<div class="form-group col-md-1 ">
									<button type="submit" class="btn btn-primary">Tìm</button>
								</div>
							</form>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>MÃ ĐƠN HÀNG</th>
											<th>MÃ KHÁCH HÀNG</th>
											<th>MÃ GIẢM GIÁ</th>
											<th>VẬN CHUYỂN</th>
											<th>NGÀY ĐẶT</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${arrays}">
											<tr>
												<td>${a.maDh}</td>
												<td>${a.maKhachHang}</td>
												<td>${a.maGiamGia}</td>
												<td>${a.phuongThuc}</td>
												<td>${a.ngay}</td>
												<td><a href="quanly/qlDatHang/${a.maDh}.htm?xemChiTiet">Xem</a>
												</td>

											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
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