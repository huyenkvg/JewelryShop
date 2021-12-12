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
					<div>
						<h2>QUẢN LÝ KHÁCH HÀNG</h2>
					</div>
					<div class="col-md-12" id="formKhachHang"
						style="display: ${display};">

						<div class="col-md-5">


							<h3>THÔNG TIN Khách Hàng</h3>
							<form:form action="quanly/khachhang.htm"
								modelAttribute="khachHangDangXem" method="POST">
								<div class="col-md-2">
									<button name="newPage"
										style="margin-left: 10px; margin-bottom: 0px; font-size: 18px">new</button>
								</div>
								<c:if test="${btnStatus == 'btnAdd'}">
									<div class="form-group">
										<label class="control-label" for="inputSuccess">Số
											điện thoại</label>
										<form:input path="sdt" name="maKhachHang" class="form-control"
											id="inputSuccess" />
									</div>
								</c:if>

								<c:if test="${btnStatus == 'btnUpdate'}">
									<div class="form-group">
										<label>Số điện thoại</label>
										<form:input path="sdt" class="form-control" id="disabledInput"
											type="text" readonly="true" />
									</div>
								</c:if>
								<div>
									<label class="control-label" for="inputSuccess">Họ và
										Tên</label>
									<form:input path="hoTen" class="form-control" id="inputSuccess" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Địa chỉ
									</label>
									<form:input path="diaChi" class="form-control"
										id="inputSuccess" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Ngày
										Sinh</label> <input type="date" name="date" class="form-control"
										id="inputSuccess" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Lưu Ý</label>
									<form:input path="luuY" class="form-control" id="inputSuccess" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">đánh
										giá tiềm năng</label>
									<form:input path="danhGiaTiemNang" class="form-control"
										id="inputSuccess" />
								</div>



								<div>
									<label class="danger-label"> ${message}</label>
								</div>
								<div>
									<button type="submit" name="${btnStatus}"
										class="btn btn-success">Lưu Thông Tin</button>
									<button type="reset" class="btn btn-primary">Reset</button>
									<button type="submit" name="khoaTaiKhoan"
										class="btn btn-danger">Khóa Tài Khoản</button>

								</div>
							</form:form>
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

										<c:forEach var="a" items="${dsHoaDon}">
											<tr>
												<td>${a.ngay}</td>
												<td>${a.maHd}</td>
												<td>${a.maNv}</td>
												<td>0000 VNđ</td>
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
								<span>Danh Sách Khách Hàng</span>
							</h3>
						</div>
						<div>


							<form role="form" action="quanly/khachhang.htm" method="GET">
								<div class="form-group col-md-5">
									<label class="control-label" for="inputSuccess">Tìm
										Kiếm (Số điện thoại):</label>
									<c:if test="${messageTimKiem!= null}">
										<label class="control-label"
											style="color: red; float: right; font-size: 13px;"">
											${messageTimKiem}</label>
									</c:if>
									<input name="sdt" type="text" class="form-control"
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

											<th>MÃ KHÁCH HÀNG - SĐT</th>
											<th>TÊN KHÁCH HÀNG</th>
											<th>NGÀY SINH</th>
											<th>ĐỊA CHỈ</th>
											<th>GHI CHÚ</th>
											<th>TIỀM NĂNG</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${arrays}">
											<tr>
												<td>${a.sdt}</td>
												<td>${a.hoTen}</td>
												<td>${a.ngaySinh}</td>
												<td>${a.diaChi}</td>
												<td>${a.luuY}</td>
												<td>${a.danhGiaTiemNang}</td>
												<td><a href="quanly/khachhang/${a.sdt}.htm?xemThongTin"
													onclick="document.geElementById('formKhachHang').style.display='none'">Xem</a></td>
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