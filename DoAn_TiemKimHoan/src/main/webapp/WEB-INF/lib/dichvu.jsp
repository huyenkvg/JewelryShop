<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link	href="<c:url value='/assets/fontawesome-free-5.15.4-web/css/all.css' />"	rel="stylesheet">
    <!-- BOOTSTRAP STYLES-->
    <link	href="<c:url value='/assets/css/bootstrap.css' />"	rel="stylesheet">
    <link	href="<c:url value='/assets/js/morris/morris-0.4.3.min.css' />"	rel="stylesheet">
    <link	href="<c:url value='/assets/css/custom.css' />"	rel="stylesheet">
    <title>CỬA HÀNG TRANG SỨC </title>
</head>

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
				<a class="navbar-brand" href="index.htm">QUẢN LÝ</a>
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
					<li class="text-center">     <img src="<c:url value='/assets/img/find_user.png' />"
                   
						class="user-image img-responsive" /></li>


					<li><a class="active-menu" href="index.htm"><i
							class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
					<li><a href="canhan.htm"><i class="fa fa-user fa-3x"></i>
							Thông tin cá nhân</a></li>


					<li><a href="#"><i class="fa fa-clock-o fa-3x"></i> Quản
							Lý Đơn Hàng<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="qlDatHang.htm">ĐƠN NHẬP/XUẤT HÀNG</a></li>
							<li><a href="qlDatHang.htm">ĐƠN ĐẶT HÀNG</a></li>

						</ul></li>

					<li><a href="#"><i class="fa fa-sitemap fa-3x"></i> Quản
							lý Sản Phẩm<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="qlKhoHang.htm">LOẠI SẢN PHẨM</a></li>
							<li><a href="qlKhoHang.htm">KHO HÀNG</a></li>

						</ul></li>



					<li><a href="khachhang.htm"><i class="fa fa-sitemap fa-3x"></i> Quản
							lý Khách Hàng</a> <!-- <ul class="nav nav-second-level">
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

					<li><a href="#"><i class="fa fa-sitemap fa-3x"></i> Quản
							lý Nhân viên</a></li>
					<li><a href="dichvu.htm"><i class="fa fa-sitemap fa-3x"></i>
							Quản lý Dịch Vụ<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="dichvu.htm">BẢO HÀNH SAU MUA</a></li>

						</ul></li>

					<li><a href="khuyenmai.htm"><i
							class="fa fa-sitemap fa-3x"></i> Quản lý Khuyến Mãi<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="khuyenmai.htm">KHUYẾN MÃI</a></li>
							<li><a href="khuyenmai.htm">ƯU ĐÃI KHÁCH HÀNG</a></li>

						</ul></li>

					<li><a href="xuhuong.htm"><i
							class="fa fa-bar-chart-o fa-3x"></i> Xu Hướng</a></li>
					<li><a href="thongke.htm"><i class="fa fa-table fa-3x"></i>
							Thống Kê <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="thongke.htm">Thống kê Hóa Đơn</a></li>
							<li><a href="thongke.htm">Thống kê Doanh Số</a></li>

						</ul></li>
					<li><a href="blank.htm"><i class="fa fa-square-o fa-3x"></i>
							Blank Page</a></li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->

		ĐÂY LÀ DỊCH VỤ

		
		    <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
	<script type="text/javascript" src="<c:url value='/assets/js/jquery-1.10.2.js' />"></script>
    <!-- BOOTSTRAP SCRIPTS -->
	<script type="text/javascript" src="<c:url value='/assets/js/bootstrap.min.js' />"></script>
    <!-- METISMENU SCRIPTS -->
	<script type="text/javascript" src="<c:url value='/assets/js/jquery.metisMenu.js' />"></script>
    <!-- MORRIS CHART SCRIPTS -->
	<script type="text/javascript" src="<c:url value='/assets/js/morris/raphael-2.1.0.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/js/morris/morris.js' />"></script>
    <!-- CUSTOM SCRIPTS -->
    <script type="text/javascript" src="<c:url value='/assets/js/custom.js' />"></script>
</body>
</html>