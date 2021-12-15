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
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<c:if test="${hoaDonDangXem.loai == 'Nhap'}">
									<h2>QUẢN LÝ HÓA ĐƠN NHẬP HÀNG</h2>
								</c:if>
								<c:if test="${hoaDonDangXem.loai != 'Nhap'}">
									<h2>QUẢN LÝ HÓA ĐƠN XUẤT HÀNG</h2>
								</c:if>


							</div>
							<div class="panel-body">

								<div class="col-md-5">
									<c:if test="${Status == 'hoaDonMoi'}">
										<form:form action="quanly/hoadon.htm">

											<div class="col-md-8">
												<h3>HÓA ĐƠN</h3>
											</div>
											<div class="col-md-2" style="margin-top: 20px;">
												<button name="newPage">
													<img src="assets/img/rel.png" width="20px" height="20px">
												</button>

											</div>
											<div class="col-md-2" style="margin-top: 20px;">

												<button name="chuyenLoai">
													<img src="assets/img/convert.png" width="20px"
														height="20px">
												</button>

											</div>
										</form:form>
										<form:form action="quanly/hoadon.htm"
											modelAttribute="hoaDonDangXem" method="GET"
											enctype="multipart/form-data">
											<div class="row">
												<div class="col-md-8">
													<label>Mã Hóa Đơn</label>
													<form:input path="maHd" name="maHoaDon" type="number"
														class="form-control" readonly="true"
														style="margin-left:0px;" />
												</div>
												<div class="col-md-4">
													<label>Loại</label>
													<form:input path="loai" type="text" class="form-control"
														readonly="true" style="margin-left:0px;" />
												</div>
											</div>
											<div>
												<div>

													<c:if test="${hoaDonDangXem.loai == 'Xuat'}">
														<label class="control-label" for="inputSuccess">Mã
															Giảm Giá</label>
														<form:input path="maGiam" name="maGiamGia"
															class="form-control" id="inputSuccess" />
													</c:if>
												</div>
											</div>
											<div>

												<form:input path="maNv" name="maNhanVien"
													class="form-control" type="hidden" id="inputSuccess" />
											</div>
											<div>
												<label class="control-label" for="inputSuccess">Mã
													Khách Hàng</label>
												<form:input path="maKhachHang" name="maKhachHang"
													class="form-control " id="inputSuccess" required="required" />
											</div>
											<div>
												<label class="control-label"
													style="color: red; float: right; font-size: 13px;"">
													${message}</label>
											</div>
											<div style="margin-top: 10px; float: right;">

												<c:if test="${alowLHD == 'true' }">
													<button type="submit" class="btn btn-success"
														name="${btnStatus}">Test</button>
												</c:if>

											</div>
											<div class="row">

												<c:if test="${Status == 'hoaDonMoi'}">
													<h4>Thêm sản phẩm</h4>
													<c:if test="${btnStatus == 'btnAdd'}">
														<div class="row">
															<c:if test="${btnCTStatus == 'them'}">
																<div class="form-group col-md-4">
																	<label>Mã Sản Phẩm</label> <input name="maSanPham"
																		type="number" class="form-control" required
																		value="${masanpham}" />

																</div>
															</c:if>

															<div class="form-group col-md-4">
																<label>Size</label> <input name="sizeSp" type="number"
																	class="form-control" required value="${size}" />

															</div>
															<div class="form-group col-md-4">
																<label>Số Lượng</label> <input name="soLuong"
																	type="number" class="form-control" required
																	value="${soluongYC}" />

															</div>
															<c:if test="${hoaDonDangXem.loai == 'Nhap'}">
																<div class="form-group col-md-4">
																	<label>Giá Nhập Hàng</label> <input name="giaNhap"
																		type="number" class="form-control" required
																		value="${giaNhap}" />

																</div>
															</c:if>




															<div class="form-group col-md-12">

																<div>

																	<button type="submit" class="btn btn-success  "
																		style="margin-top: 10px; float: right;"
																		name="${btnCTStatus}">Thêm</button>
																</div>

															</div>
															<label class="control-label"
																style="color: red; float: right; font-size: 13px;"">
																${messageChiTiet}</label>

														</div>
													</c:if>

												</c:if>
											</div>
										</form:form>

									</c:if>
									<c:if test="${Status == 'hoaDonDatHang'}">
										<form:form action="quanly/hoadon.htm">

											<div class="col-md-10">
												<h3>HÓA ĐƠN</h3>
											</div>
											<div class="col-md-2" style="margin-top: 120px;">
												<button name="newPage">
													<img src="assets/img/rel.png" width="20px" height="20px">
												</button>
											</div>
										</form:form>
										<form:form action="quanly/hoadon.htm"
											modelAttribute="hoaDonDangXem" method="GET"
											enctype="multipart/form-data">
											<div class="row">
												<label>Mã Hóa Đơn</label>
												<div class="col-md-10">
													<form:input path="maHd" name="maHoaDon" type="number"
														class="form-control" readonly="true" />
												</div>

											</div>
											<div>
												<label class="control-label" for="inputSuccess">Mã
													Đặt Hàng</label> <input name="maDh" class="form-control"
													id="inputSuccess" readonly="true" value="MaDatHang" />
											</div>
											<div class="form-group">
												<label>Loại Hóa Đơn</label> <select readonly="true"
													class="form-control">
													<c:forEach var="a" items="${dsLoaiHD}">
														<option value="${a}">${a}</option>
													</c:forEach>
												</select>
											</div>
											<div>
												<label class="control-label" for="inputSuccess">Mã
													Giảm Giá</label>
												<form:input path="maGiam" class="form-control"
													id="inputSuccess" readonly="true" />
											</div>
											<div>

												<form:input path="maNv" class="form-control" type="hidden"
													id="inputSuccess" readonly="true" />
											</div>
											<div>
												<label class="control-label" for="inputSuccess">Mã
													Khách Hàng</label>
												<form:input path="maKh" class="form-control"
													id="inputSuccess" readonly="true" />
											</div>
											<div>
												<label class="control-label"
													style="color: red; float: right; font-size: 13px;"">
													${message}</label>
											</div>
											<div style="margin-top: 10px; float: right;" class="row">


												<c:if test="${alowLHD == 'true' }">
													<button type="submit" class="btn btn-success"
														name="${btnStatus}">Lập Hóa Đơn</button>
												</c:if>


											</div>
										</form:form>

									</c:if>



								</div>

								<div class="panel-body col-md-7">

									<h3>DANH SÁCH CHi TIẾT SẢN PHẨM</h3>
									<div class="table-responsive">
										<table
											class="table table-striped table-bordered table-hover text-light bg-dark">
											<thead>
												<tr>
													<th>Mã Sản Phẩm</th>
													<th>Size</th>
													<th>Số Lượng</th>
													<th>Giá</th>
													<th>Khuyễn Mãi</th>
													<th style="color: green; font-size: 16px;">Thành tiền</th>
												</tr>
											</thead>
											<tbody>
												<form:form modelAttribute="hoaDonDangXem" method="GET"
													action="quanly/hoadon.htm">
													<%-- <form:input type="hidden" path="listCTHD" value = "${dsCTHD.listCT}"/> --%>
													<c:forEach var="a" items="${dsCTHD}">
														<tr>
															<td>${a.maSp}</td>
															<td>${a.size}</td>
															<td>${a.soLuong}</td>
															<td>${a.gia}</td>
															<td>${a.khauTru}</td>
															<td style="color: green; font-size: 16px;">${a.gia*a.soLuong - a.gia*a.soLuong*a.khauTru/100}</td>
														</tr>
													</c:forEach>
													<tr>
														<td style="color: blue; font-size: 16px;">Tổng Tiền</td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td style="color: blue; font-size: 16px;">${TongTien}</td>
													</tr>

													<div class="form-group">
														<button name="btnLapHD">Lập Hóa Đơn</button>
													</div>
													<form:input path="maHd" name="maHoaDon" type="hidden" />
													<form:input path="loai" type="hidden" />
													<form:input path="maGiam" type="hidden" />
													<form:input path="maNv" type="hidden" />
													<form:input path="maKhachHang" type="hidden" />

												</form:form>

											</tbody>
										</table>
									</div>
								</div>


							</div>

						</div>
					</div>
				</div>
				<!-- =================================================================================================== -->



				<!--=========================================================================================================  -->
			</div>
		</div>

	</div>


	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script type="text/javascript">
		var frm = document.getElementById('frm');
		function onSubmit() {
			return false;
		}

		function sub1() {
			alert('');
			frm.submit();
		}

		function myFunction($value)
		{       
		    if($value=="Nhap")
		    {document.getElementById("result").innerHTML = "30L";
		    ${alowSoLuong} = "true";}
		    
		}
		function checkIt() {
			if (confirm('Bạn chắc chắn muốn xóa sản phẩm này khỏi danh sách?')) {
				your_form_variable.submit();
			}
		}
	</script>
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