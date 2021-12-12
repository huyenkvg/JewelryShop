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


					<li><a class="active-menu" href="index.htm"><i
							class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
					<li><a href="canhan.htm"><i class="fa fa-user fa-3x"></i>
							Thông tin cá nhân</a></li>


					<li><a href="#"><i class="fa fa-clock-o fa-3x"></i> Quản
							Lý Đơn Hàng<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="qlDatHang.htm">ĐƠN NHẬP/XUẤT HÀNG</a></li>
							<li><a href="qlDatHang.htm">ĐƠN ĐẶT HÀNG</a></li>

						</ul></li>

					<li><a href="#"><i class="fa fa-sitemap fa-3x"></i> Quản
							lý Sản Phẩm<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="qlKhoHang.htm">LOẠI SẢN PHẨM</a></li>
							<li><a href="qlKhoHang.htm">KHO HÀNG</a></li>

						</ul></li>



					<li><a href="khachhang.htm"><i class="fa fa-sitemap fa-3x"></i> Quản
							lý Khách Hàng</a> <!-- <ul class="nav nav-second-level">
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

					<li><a href="nhanvien.htm"><i class="fa fa-sitemap fa-3x"></i> Quản
							lý Nhân viên</a></li>
					<li><a href="dichvu.htm"><i class="fa fa-sitemap fa-3x"></i>
							Quản lý Dịch Vụ<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="dichvu.htm">BẢO HÀNH SAU MUA</a></li>

						</ul></li>

					<li><a href="khuyenmai.htm"><i class="fa fa-sitemap fa-3x"></i>
							Quản lý Khuyến Mãi<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="khuyenmai.htm">KHUYẾN MÃI</a></li>
							<li><a href="khuyenmai.htm">ƯU ĐÃI KHÁCH HÀNG</a></li>

						</ul></li>

					<li><a href="xuhuong.htm"><i
							class="fa fa-bar-chart-o fa-3x"></i> Xu Hướng</a></li>
					<li><a href="thongke.htm"><i class="fa fa-table fa-3x"></i>
							Thống Kê <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="thongke.htm">Thống kê Hóa Đơn</a></li>
							<li><a href="thongke.htm">Thống kê Doanh Số</a></li>

						</ul></li>
					<li><a href="blank.htm"><i class="fa fa-square-o fa-3x"></i>
							Blank Page</a></li>
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

						<div class="col-md-5">


							<h3>THÔNG TIN KHÁCH HÀNG</h3>
							<form role="form">
								<div class="form-group">
									<label for="disabledSelect">Mã khách hàng - SĐT</label> <input
										class="form-control" id="disabledInput" type="text"
										placeholder="Disabled input" disabled />
								</div>
								<div class="form-group">
									<label class="control-label" for="inputSuccess">Họ và Tên</label> <input type="text" class="form-control"
										id="inputSuccess">
								</div>
								<div class="form-group">
									<label class="control-label" for="inputSuccess">Ngày sinh</label> <input type="text" class="form-control" id="inputSuccess">
								</div>
								<div class="form-group">
									<label class="control-label" for="inputSuccess">Địa Chỉ</label> <input type="text" class="form-control" id="inputSuccess">
								</div>
								<div class="form-group">
									<label class="control-label" for="inputSuccess"> <input
										type="checkbox" /> Nữ
									</label>
									<label class="control-label" for="inputSuccess"> <input
										type="checkbox" /> Nam
									</label>
								</div>
								<button type="submit" class="btn btn-primary">Lưu Thông Tin</button>

								<button type="submit" class="btn btn-danger">Khóa Tài Khoản</button>

							</form>
							<br>
							<!--  <h3>Validation State Examples</h3>
                                        <form role="form">
                                            <div class="form-group has-success">
                                                <label class="control-label" for="inputSuccess">Input with
                                                    success</label>
                                                <input type="text" class="form-control" id="inputSuccess">
                                            </div>
                                            <div class="form-group has-warning">
                                                <label class="control-label" for="inputWarning">Input with
                                                    warning</label>
                                                <input type="text" class="form-control" id="inputWarning">
                                            </div>
                                            <div class="form-group has-error">
                                                <label class="control-label" for="inputError">Input with error</label>
                                                <input type="text" class="form-control" id="inputError">
                                            </div>
                                        </form> -->
						</div>
						
						<div class="panel-body col-md-7">
							
							<h3>Lịch sử mua hàng của khách</h3>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>NGÀY</th>
											<th>MÃ HÓA ĐƠN</th>
											<th>NHÂN VIÊN LẬP</th>
											<th>TỔNG TIỀN</th>
										</tr>
									</thead>
									<tbody>

									<%-- 	<c:forEach var="a" items="${arrays[0].hoaDonCollection}">
											<tr>
												<td> ${a.ngay}</td>
												<td>${a.maHd}</td>
												<td>${a.maNv}</td>
												<td>${a.phuongThuc}</td>
												<td>0000 VNđ</td>
											</tr>
										</c:forEach> --%>

									</tbody>
								</table>
							</div>
						</div>

					</div>
					
					<!-- =================================================================================================== -->
					<div class="col-md-12">
						<div class="panel-heading col-md-6 text-info">
							<h3>
								<span>Danh Sách Khách Hàng</span>
							</h3>
						</div>
						<div>
							<form role="form">
								<div class="form-group col-md-5">
									<label class="control-label" for="inputSuccess">Tìm
										Kiếm (nhập SĐT khách hàng):</label> <input name="txtSdtKhachHang" type="text"
										class="form-control" id="inputSuccess">
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
											
											<th>MÃ KHÁCH HÀNG</th>
											<th>TÊN KHÁCH HÀNG</th>
											<th>NGÀY SINH</th>
											<th>ĐỊA CHỈ</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${arrays}">
											<tr>
												<td>${a.sdt}</td>
												<td>${a.hoTen}</td>
												<td>${a.ngaySinh}</td>
												<td>${a.diaChi}</td>
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