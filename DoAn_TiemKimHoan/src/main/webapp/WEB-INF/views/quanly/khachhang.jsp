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

		<%@include file="/WEB-INF/views/include/menu.jsp"%>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div>
						<h2 style="margin-left: 30px;">QUẢN LÝ KHÁCH HÀNG</h2>
						<form:form action="quanly/khachhang.htm" method="POST">
							<div>
								<button name="newPage"
									style="margin-left: 30px; margin-bottom: 0px; font-size: 18px">new</button>
							</div>
						</form:form>
					</div>

					<div class="col-md-12" id="formKhachHang"
						style="display: ${display};">

						<div class="col-md-5">


							<h3>THÔNG TIN Khách Hàng</h3>
							<form:form action="quanly/khachhang.htm"
								modelAttribute="khachHangDangXem" method="GET">
								
								<c:if test="${btnStatus == 'btnAdd'}">
									<div class="form-group">
										<label class="control-label" for="inputSuccess">Số
											điện thoại</label>
										<form:input path="sdt" name="maKhachHang" class="form-control"
											id="inputSuccess"  required="required" />
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
									<form:input path="hoTen" class="form-control" id="inputSuccess" required="required"/>
								</div>
								<div>
									<label class="control-label" for="inputSuccess" >Địa chỉ
									</label>
									<form:input path="diaChi" class="form-control"
										id="inputSuccess"  required="required"/>
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Ngày
										Sinh</label> <input type="date" name="date" class="form-control"
										id="inputSuccess"  required="required"/>
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Lưu Ý</label>
									<form:input path="luuY" class="form-control" id="inputSuccess"  required="required"/>
								</div>
								<div>
									<label class="control-label" for="inputSuccess" >đánh
										giá tiềm năng</label>
									<form:input path="danhGiaTiemNang" class="form-control"
										id="inputSuccess"  required="required"/>
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


							<form role="form" action="quanly/khachhang.htm" method="POST">
								<div class="form-group col-md-5">
									<label class="control-label" for="inputSuccess">Tìm
										Kiếm (Số điện thoại):</label>
									<c:if test="${messageTimKiem!= null}">
										<label class="control-label"
											style="color: red; float: right; font-size: 13px;"">
											${messageTimKiem}</label>
									</c:if>
									<input name="sdt" type="text" class="form-control"
										id="inputSuccess"  required="required">
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