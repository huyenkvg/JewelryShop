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
								modelAttribute="khachHangDangXem" method="GET"
								onsubmit="return checkValidate()">

								<c:if test="${btnStatus == 'btnAdd'}">
									<div class="form-group">
										<label class="control-label" for="inputSuccess">Số
											điện thoại</label>
										<div class="input-row">
											<form:input path="sdt" name="maKhachHang"
												class="form-control" id="phone" required="required" />
											<small style="color: red; font: 50px;"></small>
										</div>
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
									<div class="input-row">
										<form:input path="hoTen" class="form-control" id="username"
											required="required" />
										<small style="color: red; font: 50px;"></small>
									</div>
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Địa chỉ
									</label>
									<form:input path="diaChi" class="form-control"
										id="inputSuccess" required="required" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Ngày
										Sinh</label> <input type="date" name="date" class="form-control"
										id="inputSuccess" required="required"
										value="${khachHangDangXem.ngaySinh}" />
								</div>
								<div>
									<label class="control-label" for="inputSuccess">Lưu Ý</label>
									<form:input path="luuY" class="form-control" id="inputSuccess"
										required="required" />
								</div>

								<div class="form-group" style="color: blue;">
									<br /> <label class="control-label" for="inputSuccess"
										style="color: black;">Đánh giá tiềm năng Khách Hàng</label> <br />
									</label class="control-label" for="inputSuccess"> 0 - Khách Mới
									<form:radiobutton path="danhGiaTiemNang" value="0" />
									<br /> 1 - Khách Hàng tiềm năng
									<form:radiobutton path="danhGiaTiemNang" value="1" />
									<br /> 2 - Khách Hàng thân thiết
									<form:radiobutton path="danhGiaTiemNang" value="2" />
									<br /> 3 - Khách VIP
									<form:radiobutton path="danhGiaTiemNang" value="3" />
									<br /> 4 - Khách Hàng Cảnh Cáo
									<form:radiobutton path="danhGiaTiemNang" value="4" />
								</div>


								<div>
									<label class="danger-label" style="color: red;">
										${message}</label>
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
										id="inputSuccess" required="required">
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
	<script>
		//Truy cập vào các ô input

		const usernameEle = document.getElementById('username');
		const emailEle = document.getElementById('email');
		const phoneEle = document.getElementById('phone');

		// Validate dữ liệu trong các ô input và highlight
		function checkValidate() {
			let usernameValue = usernameEle.value;
			let emailValue = emailEle.value;
			let phoneValue = phoneEle.value;

			let isCheck = true;

			// Kiểm tra trường username
			var regex = /[a-zA-Z]+$/;
			if (!regex.test(usernameValue)) {
				setError(usernameEle,
						'Tên không được chứa các kí tự bất thường');
				isCheck = false;
				return isCheck;
			} else {
				setSuccess(usernameEle);
			}

			// Kiểm tra trường email
			/* 			if (emailValue == '') {
			 setError(emailEle, 'Email không được để trống');
			 isCheck = false;
			 return isCheck;
			 } else if (!isEmail(emailValue)) {
			 setError(emailEle, 'Email không đúng định dạng');
			 isCheck = false;
			 return isCheck;
			 } else {
			 setSuccess(emailEle);
			 } */

			// Kiểm tra trường phone
			if (phoneValue == '') {
				setError(phoneEle, 'Số điện thoại không được để trống');
				isCheck = false;
				return isCheck;
			} else if (!isPhone(phoneValue)) {
				setError(phoneEle, 'Số điện thoại không đúng định dạng');
				isCheck = false;
			} else {
				setSuccess(phoneEle);
			}

			return isCheck;
		}
		function setError(ele, message) {
			let parentEle = ele.parentNode;
			parentEle.classList.add('error');
			ele.style.color = "red";
			parentEle.querySelector('small').innerText = message;
		}
		function setSuccess(ele) {
			ele.parentNode.classList.add('success');
		}
		function isEmail(email) {
			return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
					.test(email);
		}

		function isPhone(number) {
			return /(84|0[3|5|7|8|9])+([0-9]{8})\b/.test(number); 
		}
	</script>


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