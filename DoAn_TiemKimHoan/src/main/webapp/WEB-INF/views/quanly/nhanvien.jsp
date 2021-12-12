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
			style="margin-bottom: 0; background-color:#00134d;">
			<div class="navbar-header" style="background-color:#00134d;">
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
							<li><a href="quanly/qlDatHang.htm">ĐƠN NHẬP/XUẤT HÀNG</a></li>
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
		<div id="page-wrapper" style="background-color: powderblue;">
			<div id="page-inner">
				<div class="row" style="padding: 20px; border-radius: 5px;">
					<div style="margin-left: 30px; color: #000080;"> <h2 style="color: #000080;">QUẢN LÝ NHÂN VIÊN</h2></div> 
					<div class="col-md-12" style="display: ${display};" >
						<div class="col-md-5" style="background-color: powderblue; border-radius: 30px; padding: 35px;">


							<h4>THÔNG TIN NHÂN VIÊN</h4>
							
							<form:form action="quanly/nhanvien.htm"
								modelAttribute="nhanVienDangXem" method="POST">
								<div class="col-md-2">
												<button name="newPage"
													style="margin-left: 10px; margin-bottom: 0px; font-size: 18px">new</button>
											</div>
								<c:if test="${btnStatus == 'btnAdd'}">
									<div class="form-group">
										<label class="control-label" for="inputSuccess">CMND</label>
										<form:input path="cmnd" name="maNhanVien" class="form-control"
											id="inputSuccess" />
									</div>
								</c:if>

								<c:if test="${btnStatus == 'btnUpdate'}">
									<div class="form-group">
										<label>CMND</label>
										<form:input path="cmnd" class="form-control"
											id="disabledInput" type="text" readonly="true" />
									</div>
								</c:if>
								<div>
									<label class="control-label" for="inputSuccess">Họ và
										Tên</label>
									<form:input path="hoTen" class="form-control" id="inputSuccess" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Số Điện
										Thoại</label>
									<form:input path="sdt" class="form-control" id="inputSuccess" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Ngày
										Sinh</label> <input type="date" name="date" class="form-control"
										id="inputSuccess" value="${nhanVienDangXem.ngaySinh }" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Email</label>
									<form:input path="email" class="form-control" id="inputSuccess" />
								</div>
								<div class="form-group">

									</label class="control-label" for="inputSuccess"> Male:
									<form:radiobutton path="gioiTinh" value="true" />
									<br /> Female:
									<form:radiobutton path="gioiTinh" value="false" />
								</div>


								<div>
									<label class="control-label"
										style="color: red; float: right; font-size: 13px;"">
										${message}</label>
								</div>
								<div style="float: right;">
									<button type="submit" class="btn btn-success"
										name="${btnStatus}">Lưu</button>
									<button type="reset" class="btn btn-primary">Hoàn tác</button>
								</div>
							</form:form>
						</div>



						<div class="col-md-7">
							<!--    Context Classes  -->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>Danh sách hóa đơn đã lập</h4>
								</div>

								<div class="panel-body">
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>NGÀY</th>
													<th>MÃ HÓA ĐƠN</th>
													<th>TỔNG TIỀN (VNđ)</th>
												</tr>
											</thead>
											<tbody>
											<tbody>

												<c:forEach var="a" items="${dsHoaDon}" varStatus="theCount">
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
													<td>${a.ngay}</td>
													<td>${a.maHd}</td>
													<td>${a.tongTien}</td>
													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!--  end  Context Classes  -->
						</div>



					</div>

					<!-- =================================================================================================== -->
					<div class="col-md-12">
						<div class="panel-heading col-md-6 text-info">
							<h3>
								<span>Danh Sách Nhân Viên</span>
							</h3>
						</div>
						<div>


							<form role="form" action="quanly/nhanvien.htm" method="GET">
								<div class="form-group col-md-5">
									<label class="control-label" for="inputSuccess">Tìm
										Kiếm (CMND):</label>
									<c:if test="${messageTimKiem!= null}">
										<label class="control-label"
											style="color: red; float: right; font-size: 13px;"">
											${messageTimKiem}</label>
									</c:if>
									<input name="cmnd" type="text" class="form-control"
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

											<th>MÃ NHÂN VIÊN</th>
											<th>TÊN NHÂN VIÊN</th>
											<th>NGÀY SINH</th>
											<th>SĐT</th>
											<th>EMAIL</th>
											<th>GIỚI TÍNH</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${arrays}">
											<tr>
												<td>${a.cmnd}</td>
												<td>${a.hoTen}</td>
												<td>${a.ngaySinh}</td>
												<td>${a.sdt}</td>
												<td>${a.email}</td>
												<c:if test="${a.gioiTinh == true}">
													<td>Nam</td>
												</c:if>

												<c:if test="${a.gioiTinh == false}">
													<td>Nữ</td>
												</c:if>

												<td><a href="quanly/nhanvien/${a.cmnd}.htm?xemThongTin">Xem</a></td>
												<td onclick="checkIt();"><a href="quanly/nhanvien/${a.cmnd}.htm?xoaNV" >Xóa</a></td>
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
<script type="text/javascript">
		var frm = document.getElementById('frm');
		function onSubmit() {
			return false;
		}

		function checkIt() {
			if (confirm('Bạn chắc chắn muốn xóa Nhân Viên này khỏi danh sách?')) {
				your_form_variable.submit();
			}
		}

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