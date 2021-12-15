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
		<div id="page-wrapper" style="background-color: powderblue;">
			<div id="page-inner">
				<div class="row" style="padding: 20px; border-radius: 5px;">
					<div style="margin-left: 30px; color: #000080;">
						<h2 style="color: #000080;">QUẢN LÝ NHÂN VIÊN</h2>
					</div>
					<div class="col-md-12" style="display: ${display};">
						<div class="col-md-5"
							style="background-color: powderblue; border-radius: 30px; padding: 35px;">


							<h4>THÔNG TIN NHÂN VIÊN</h4>

							<form:form action="quanly/nhanvien.htm"
								modelAttribute="nhanVienDangXem" method="POST">
								<div>
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
												<td onclick="checkIt();"><a
													href="quanly/nhanvien/${a.cmnd}.htm?xoaNV">Xóa</a></td>
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