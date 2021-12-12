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


					<li><a href="#"><i class="fas fa-user-clock fa-3x"></i>
							Quản Lý Đơn Hàng<span class="fa arrow"></span></a>
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
							class="fa fa-user-clock fa-3x"></i> Quản lý Khách Hàng</a> <!-- <ul class="nav nav-second-level">
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
							class="fa fa-users fa-3x"></i> Quản lý Nhân viên</a></li>
					<li><a href="quanly/dichvu.htm"><i
							class="fab fa-product-hunt fa-3x"></i> Quản lý Dịch Vụ<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="quanly/dichvu.htm">BẢO HÀNH SAU MUA</a></li>

						</ul></li>

					<li><a href="quanly/khuyenmai.htm"><i
							class="fa fa-percentage fa-3x"></i> Quản lý Khuyến Mãi<span
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
					<div class="col-md-12" style="display: ${display};">
						<h2>QUẢN LÝ DỊCH VỤ</h2>
						<form:form action="quanly/dichvu.htm"
							modelAttribute="dichVuDangXem" class="col-md-5" method="POST">

							<h3>THÔNG TIN DỊCH VỤ BẢO HÀNH</h3>
							<div class="form-group">
								<label>Mã Dịch Vụ </label>
								<form:input path="maDichVu" type="number" class="form-control"
									id="inputSuccess" required="required"/>
							</div>
							<div class="form-group">
								<label>Tên Dịch Vụ</label>
								<form:input path="tenDichVu" class="form-control"
									id="inputSuccess" required="required"/>
							</div>


							<div class="form-group"
								style="margin-left: 50; padding: 0px 0px 0px 270px;">
								<button name="btnAdd" type="submit"
									class="btn btn-success">Lưu</button>
							</div>

						</form:form>
						<br>


						<div class="panel-body col-md-7">

							<h3>Chi Tiết Dịch Vụ Dã Sử Dung</h3>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>

											<th>NGÀY SD</th>
											<th>MÃ HÓA ĐƠN</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${listCTDV}">
											<tr>

												<td>${a.ngaySD}</td>
												<td>${a.maHD}</td>

											</tr>
										</c:forEach>


									</tbody>
								</table>


							</div>
						</div>

					</div>
					<c:if test="${display == 'none'}">

						<h2 style="margin-left: 50px; color: #00134d;">Bảo Hành</h2>
						<form action="quanly/dichvu.htm" class="col-md-5" method="POST">

							<div class="form-group">
								<label>Mã Dịch Vụ </label> <input name="maDvSD" type="number" type="number"
									class="form-control" id="inputSuccess"
									value="${dichVuDangXem.maDichVu}" required="required"/>
							</div>
							<label class="control-label"
								style="color: red; float: right; font-size: 13px;"">
								${messageBaoHanh}</label>
							<div class="form-group">
								<label>Mã Hóa Đơn</label> <input name="maHoaDon" type="number"
									class="form-control" id="inputSuccess" required="required" />
							</div>


							<div class="form-group"
								style="margin-left: 50; padding: 0px 0px 0px 270px;">
								<button name="btnBaoHanh" type="submit" class="btn btn-success">Xác
									Nhận</button>
							</div>

						</form>
						<br>

					</c:if>
				</div>

				<!-- =================================================================================================== -->
				<div class="col-md-12">
					<div class="panel-heading col-md-6 text-info">
						<h3>
							<span>Danh Sách Đơn Đặt Hàng</span>
							<form action="quanly/dichvu.htm">
								<button name="themDV" type="submit" class="btn btn-primary">New</button>
							</form>
						</h3>
					</div>
					<div>

						<form role="form" action="quanly/dichvu.htm">
							<div class="form-group col-md-6">
								<label class="control-label" for="inputSuccess">Tìm Kiếm
									(Mã Dịch Vụ):</label>
								<c:if test="${messageTimKiem!= null}">
									<label class="control-label"
										style="color: red; float: right; font-size: 13px;"">
										${messageTimKiem}</label>
								</c:if>
								<div class="form-group col-md-8 ">
									<input name="maDichVu" type="text" class="form-control"
										id="inputSuccess" required="required">
								</div>
								<div class="form-group col-md-2 ">
									<button type="submit" class="btn btn-primary">Tìm</button>
								</div>
							</div>


						</form>


					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>MÃ DỊCH VỤ</th>
										<th>TÊN DỊCH VỤ</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="a" items="${arrays}">
										<tr>
											<td>${a.maDichVu}</td>
											<td>${a.tenDichVu}</td>
											<td><a href="quanly/dichvu/${a.maDichVu}.htm?xemChiTiet">Chọn</a></td>

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