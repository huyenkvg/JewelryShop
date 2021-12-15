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
	
	<%@include file="/WEB-INF/views/include/menu.jsp"%>
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