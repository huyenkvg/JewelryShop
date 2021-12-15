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
						<h2>QUẢN LÝ DỊCH VỤ</h2>



						<form:form action="quanly/khuyenmai.htm"
							modelAttribute="khuyenMaiDangXem" class="col-md-5" method="POST">

							<h3>THÔNG TIN KHUYẾN MÃI</h3>
							<div class="form-group">
								<label>Mã Khuyến Mãi </label>
								<form:input path="maGiam" type="text" class="form-control"
									id="inputSuccess" required = "required"/>
							</div>
							<div>
								<label class="control-label" for="inputSuccess">Ngày Bắt
									Đầu</label> <input type="date" name="dateBD" class="form-control"
									id="inputSuccess" />
							</div>
							<div>
								<label class="control-label" for="inputSuccess">Ngày Kết
									Thúc</label> <input type="date" name="dateKT" class="form-control"
									id="inputSuccess" />
							</div>


							<div class="form-group"
								style="margin-left: 20px; margin-top: 20px;">
								<button name="${btnStatus}" type="submit" class="btn btn-info">Lưu
									Thông Tin</button>
							</div>

						</form:form>
						<br>


						<div class="panel-body col-md-5">

							<form:form action="quanly/khuyenmai.htm" style="font-size: 12px;"
								method="POST">
								 <input name ="maKhuyenMai" type="hidden"
										class="form-control" value="${khuyenMaiDangXem.maGiam}"/>
									 
								<div class="form-group col-md-3">
									<label>Mã SP</label> <input name="maSpham" type="number"
										class="form-control" required="required" /> <label
										class="control-label"
										style="color: red; float: right; font-size: 13px;"">
										${messageCTKM}</label>
								</div>
								<div class="form-group col-md-4">
									<label>Phần trăm</label> <input name="phanTram" type="money"
										class="form-control" />


								</div class="form-group col-md-4">
								<div>
									<button type="submit" class="btn btn-success  "
										style="margin-top: 10px; float: right;" name="luuKM">thêm</button>
								</div>

							</form:form>
							<div class="col-md-12">
								<!--    Context Classes  -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3>DS Chi Tiết Khuyến Mãi</h3>
									</div>

									<div class="panel-body">
										<div class="table-responsive">
											<table class="table">
												<thead>
													<tr>
														<th>MÃ SẢN PHẨM</th>
														<th>PHẦN TRĂM GIẢM</th>
													</tr>
												</thead>
												<tbody>
												<tbody>

													<c:forEach var="a" items="${listCTKM}" varStatus="theCount">
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
														<td>${a.maHang}</td>
														<td>${a.phanTramGiam}</td>

														</tr>
													</c:forEach>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<!--  end  Context Classes  -->
							</div>
							<%-- <div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>

											<th>MÃ SẢN PHẨM</th>
											<th>PHẦN TRĂM GIẢM</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${listCTKM}">
											<tr>

												<td>${a.maHang}</td>
												<td>${a.phanTramGiam}</td>

											</tr>
										</c:forEach>


									</tbody>
								</table>


							</div> --%>
						</div>


					</div>

					<!-- =================================================================================================== -->
					<div class="col-md-12">
						<div class="panel-heading col-md-6 text-info">
							<h3>
								<span>Danh Sách Giảm Giá</span>
							</h3>
						</div>
						<div>

							<form role="form" action="quanly/khuyenmai.htm">
								<div class="form-group col-md-5">
									<label class="control-label" for="inputSuccess">Tìm
										Kiếm (Mã Khuyến Mãi):</label>
									<c:if test="${messageTimKiem!= null}">
										<label class="control-label"
											style="color: red; float: right; font-size: 13px;"">
											${messageTimKiem}</label>
									</c:if>
									<input name="maGiam" type="text" class="form-control"
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
											<th>MÃ KHUYẾN MÃI</th>
											<th>NGÀY BẮT ĐẦU</th>
											<th>NGÀY KẾT THÚC</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="a" items="${arrays}">
											<tr>
												<td>${a.maGiam}</td>
												<td>${a.ngayBatDau}</td>
												<td>${a.ngayKetThuc}</td>
												<td><a
													href="quanly/khuyenmai/${a.maGiam}.htm?xemChiTiet">Xem</a>
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