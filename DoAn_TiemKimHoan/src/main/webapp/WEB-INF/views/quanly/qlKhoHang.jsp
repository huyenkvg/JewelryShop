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
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2>QUẢN LÝ KHO HÀNG</h2>

							</div>
							<div class="panel-body">

								<div class="col-md-5">

									<h3>THÔNG TIN SẢN PHẨM</h3>
									<form:form action="quanly/qlKhoHang.htm"
										modelAttribute="sanPhamDangXem" method="POST"
										enctype="multipart/form-data">
										<div class=" col-md-16">
											<label>Mã Sản Phẩm</label>
											<div class="col-md-9">
												<form:input path="maSp" name="maSanPham" type="number"
													class="form-control" readonly="true" />
											</div>
											<div class="col-md-2">
												<button name="newPage"
													style="margin-left: 10px; margin-bottom: 0px; font-size: 18px">new</button>
											</div>
										</div>
										<div>
											<label class="control-label" for="inputSuccess">Tên
												Sản Phẩm</label>
											<form:input path="tenSp" class="form-control"
												id="inputSuccess" />
										</div>
										<div>
											<label class="control-label" for="inputSuccess">Mô tả</label>
											<form:input path="moTa" class="form-control"
												id="inputSuccess" />
										</div>
										<div class="form-group">
											<label>Loại Sản Phẩm</label> <select name="item"
												class="form-control">
												<c:forEach var="a" items="${dsLoaiSP}">
													<option value="${a.maLoai}">${a.tenLoai}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label>Thêm Hình Ảnh</label> <input type="file"
												name="photoSP" />
										</div>

										<div>
											<label class="control-label"
												style="color: red; float: right; font-size: 13px;"">
												${message}</label>
										</div>
										<div style="float: right;">
											<button type="submit" class="btn btn-success"
												name="${btnStatus}">Lưu Thông Tin</button>
											<button type="reset" class="btn btn-primary">Reset
												Button</button>
											<!-- 				<button onClick="window.location.href=window.location.href">Refresh Page</button>
										<button onClick="window.location.reload();">Refresh Page</button> -->
										</div>
									</form:form>
								</div>

								<div class="panel-body col-md-7">

									<c:if test="${btnSizeStatus != null}">
										<h3>THÔNG TIN SIZE</h3>
										<form:form action="quanly/qlKhoHang.htm"
											style="font-size: 12px;" method="POST">

											<div row>
												<c:if test="${btnSizeStatus == 'suaSize'}">


													<div class="form-group col-md-4">
														<label>Size</label> <input name="sizeSp" type="number"
															class="form-control" value="${sizeSp}" readonly="true" />

													</div>
												</c:if>
												<c:if test="${btnSizeStatus == 'themSize'}">


													<div class="form-group col-md-4">
														<label>Size</label> <input name="sizeSp" type="number"
															class="form-control" />
													</div>
												</c:if>

												<input name="maSpham" type="hidden" class="form-control"
													value="${sanPhamDangXem.maSp}" />

												<div class="form-group col-md-8">
													<label>Giá Tiền</label> <input name="giaSp" type="money"
														class="form-control" value="${giaSp}" />
													<div>
														<button type="submit" class="btn btn-success  "
															style="margin-top: 10px; float: right;"
															name="${btnSizeStatus}">lưu giá tiền của size</button>
													</div>

												</div>
												<label class="control-label"
													style="color: red; float: right; font-size: 13px;"">
													${messageSize}</label>

											</div>

										</form:form>

									</c:if>

									<div class="col-md-12">
										<!--    Context Classes  -->
										<div class="panel panel-default">

											<div class="panel-heading">
												<h4>Danh sách Size</h4>
											</div>

											<div class="panel-body">
												<div class="table-responsive">
													<table class="table">
														<thead>
															<tr>
																<th>Size</th>
																<th>Giá Tiền</th>
																<th>Số Lượng</th>
																<th>Sửa Giá</th>
																<th></th>
															</tr>
														</thead>
														<tbody>
														<tbody>


															<c:forEach var="a" items="${listCTSZ}"
																varStatus="theCount">

																<c:if test="${theCount.count%4 == 0}">
																	<tr class="success">
																</c:if>
																<c:if test="${theCount.count%4 == 1}">
																	<tr class="info">
																</c:if>
																<c:if test="${theCount.count%4 == 2}">
																	<tr class="warning">
																</c:if>
																<c:if test="${theCount.count%4 == 3}">
																	<tr class="danger">
																</c:if>
																<td>${a.size}</td>
																<td>${a.gia}</td>
																<td>${a.soLuong}</td>
																<td><a
																	href="quanly/qlKhoHang/${a.maSp}/${a.size}.htm?suaGiaSize">sửa</a></td>
																<td><a
																	href="quanly/qlKhoHang/${a.maSp}/${a.size}.htm?deleteSize">xóa</a></td>

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
							<!-- =================================================================================================== -->
							<div class="col-md-12">
								<h4>Hình ảnh của sản phẩm:</h4>
								<div class="form-group">
									<c:forEach var="photo" items="${dsPhoto}">
										<div class="col-md-3">
										<img src="assets/Images/SanPham/${photo}" width="150"
											height="150" />
										<a href="quanly/qlDatHang/remove/${photo}.htm">xóa</a></div>
									</c:forEach>

								</div>
							</div>


							<!-- ============================================================================================= -->
							<div class="row">
								<div class="col-md-12">
									<!-- Advanced Tables -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<div class="form-group col-md-6">
												<h3>Danh Sách sản phẩm</h3>
											</div>

											<form role="form" action="quanly/qlKhoHang.htm" method="GET">
												<div class="form-group col-md-6">
													<div>
														<label style="margin-left: 20px; margin-bottom: 0px;"
															class="control-label" for="inputSuccess">Tìm Kiếm
															(Mã Sản Phẩm):</label> <label class="control-label"
															style="color: red; float: right; font-size: 13px;">
															${messageTimKiem}</label>
													</div>
													<div style="margin-top: 0px;">
														<div class="form-group col-md-10">
															<input name="idSanPham" type="text" class="form-control"
																id="inputSuccess">
														</div>
														<div class="form-group ">
															<button type="submit" class="btn btn-primary"
																style="color: white; float: right;">Tìm</button>
														</div>
													</div>
												</div>
											</form>
										</div>
										<div class="panel-body">
											<div class="table-responsive">
												<table
													class="table table-striped table-bordered table-hover"
													id="dataTables-example">
													<thead>
														<tr>
															<th>MÃ SP</th>
															<th>TÊN SP</th>
															<th>MÔ TẢ</th>
															<th>ẢNH</th>
															<th>Xem Chi Tiết</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="a" items="${arrays}">

															<tr>
																<td>${a.maSp}</td>
																<td>${a.tenSp}</td>
																<td>${a.moTa}</td>
																<td>${a.anh}</td>
																<td><a
																	href="quanly/qlKhoHang/${a.maSp}.htm?xemThongTin">Xem</a></td>
															</tr>

														</c:forEach>
													</tbody>
												</table>
											</div>

										</div>
									</div>
									<!--End Advanced Tables -->


								</div>
							</div>

							<!--=========================================================================================================  -->
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