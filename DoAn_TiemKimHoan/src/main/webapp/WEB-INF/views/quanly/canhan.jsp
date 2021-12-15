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
<body>
	<div id="wrapper">
	
	<%@include file="/WEB-INF/views/include/menu.jsp"%>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Thông tin cá nhân</h2>
						<h5>Welcome Huyen , Love to see you back.</h5>
					</div>
				</div>

				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">THÔNG TIN CÁ NHÂN</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">

										<h4>THÔNG TIN NHÂN VIÊN</h4>
										<form:form action="quanly/canhan.htm"
											modelAttribute="nhanVienDangXem" method="POST" enctype="multipart/form-data">

											<div class="form-group">
												<label>CMND</label>
												<form:input path="cmnd" class="form-control"
													id="disabledInput" type="text" readonly="true" />
											</div>
											<div>
												<label class="control-label" for="inputSuccess">Họ
													và Tên</label>
												<form:input path="hoTen" class="form-control"
													id="inputSuccess" />
											</div>
											<div>
												<label class="control-label" for="inputSuccess">Số
													Điện Thoại</label>
												<form:input path="sdt" class="form-control"
													id="inputSuccess" />
											</div>
											<div>
												<label class="control-label" for="inputSuccess">Ngày
													Sinh</label> <input type="date" name="date" class="form-control"
													id="inputSuccess" value="${nhanVienDangXem.ngaySinh }" />
											</div>
											<div>
												<label class="control-label" for="inputSuccess">Email</label>
												<form:input path="email" class="form-control"
													id="inputSuccess" />
											</div>
											<div class="form-group">

												<label class="control-label" for="inputSuccess">Male</label>
												<form:radiobutton path="gioiTinh" value="true" />
												<br /> <label>Female</label>
												<form:radiobutton path="gioiTinh" value="false" />
											</div>
											<div class="form-group">
												<label>Thêm Hình Ảnh</label> <input type="file"
													name="photo" />
											</div>

											<div>
												<label class="control-label"
													style="color: red; float: right; font-size: 13px;">
													${message}</label>
											</div>
											<div style="float: right;">
												<button type="submit" class="btn btn-success"
													name="btnUpdate">Lưu</button>
												<button type="reset" class="btn btn-primary">Hoàn
													tác</button>
											</div>
										</form:form>


										<br />

									</div>
									<div class="col-md-6">
										<h4>Ảnh Đại Diện Cá Nhân</h4>
										<div class="form-group">
											<div class="col-md-3">
												<img src="assets/Images/SanPham/${photo}" width="350"
													height="350" />
											</div>

										</div>
									</div>
									<!-- 
									<div class="col-md-6">
										<h3>Disabled Form State Examples</h3>
										<form role="form">
											<fieldset disabled="disabled">
												<div class="form-group">
													<label for="disabledSelect">Disabled input</label> <input
														class="form-control" id="disabledInput" type="text"
														placeholder="Disabled input" disabled />
												</div>
												<div class="form-group">
													<label for="disabledSelect">Disabled select </label> <select
														id="disabledSelect" class="form-control">
														<option>Disabled select</option>
													</select>
												</div>
												<div class="checkbox">
													<label> <input type="checkbox" />Disabled Checkbox
													</label>
												</div>
												<button type="submit" class="btn btn-primary">Disabled
													Button</button>
											</fieldset>
										</form>
										<h3>Validation State Examples</h3>
										<form role="form">
											<div class="form-group has-success">
												<label class="control-label" for="inputSuccess">Input
													with success</label> <input type="text" class="form-control"
													id="inputSuccess">
											</div>
											<div class="form-group has-warning">
												<label class="control-label" for="inputWarning">Input
													with warning</label> <input type="text" class="form-control"
													id="inputWarning">
											</div>
											<div class="form-group has-error">
												<label class="control-label" for="inputError">Input
													with error</label> <input type="text" class="form-control"
													id="inputError">
											</div>
										</form>
										<h3>Input Group Examples</h3>
										<form role="form">
											<div class="form-group input-group">
												<span class="input-group-addon">@</span> <input type="text"
													class="form-control" placeholder="Username">
											</div>
											<div class="form-group input-group">
												<input type="text" class="form-control"> <span
													class="input-group-addon">.00</span>
											</div>
											<div class="form-group input-group">
												<span class="input-group-addon"><i class="fa fa-eur"></i>
												</span> <input type="text" class="form-control"
													placeholder="Font Awesome Icon">
											</div>
											<div class="form-group input-group">
												<span class="input-group-addon">$</span> <input type="text"
													class="form-control"> <span
													class="input-group-addon">.00</span>
											</div>
											<div class="form-group input-group">
												<input type="text" class="form-control"> <span
													class="input-group-btn">
													<button class="btn btn-default" type="button">
														<i class="fa fa-search"></i>
													</button>
												</span>
											</div>
										</form>
										<h3>Different Size Input Groups</h3>
										<form role="form">
											<div class=" form-group input-group input-group-lg">
												<span class="input-group-addon">@</span> <input type="text"
													class="form-control" placeholder="Username" />
											</div>

											<div class="form-group input-group">
												<span class="input-group-addon">@</span> <input type="text"
													class="form-control" placeholder="Username" />
											</div>

											<div class="form-group input-group input-group-sm">
												<span class="input-group-addon">@</span> <input type="text"
													class="form-control" placeholder="Username" />
											</div>

										</form>
										<h3>Different Size Input Groups</h3>
										<form role="form">
											<div class="input-group">
												<span class="form-group input-group-btn">
													<button class="btn btn-default" type="button">Go!</button>
												</span> <input type="text" class="form-control" />
											</div>
											<br />
											<div class="input-group">

												<input type="text" class="form-control" /> <span
													class="form-group input-group-btn">
													<button class="btn btn-default" type="button">Go!</button>
												</span>
											</div>
										</form>
									</div> -->
								</div>
							</div>
						</div>
						<!-- End Form Elements -->
					</div>
				</div>
				<!-- /. ROW  -->

			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->



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