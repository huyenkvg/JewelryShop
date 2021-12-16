<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<header id="header">
		<div class="container">
			<a href="trang-chu.htm" id="logo" title="PTIT BÁN VÀNG">A PTIT</a>
			<div class="right-links">
				<ul>
					<li><a class="khang" href="cart.htm"><span class="ico-products"></span>${Cart.size() } Sản phẩm, <fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceCart }"/> VNĐ</a></li>
					
					<c:if test="${sessionScope.acc !=null }">
						<li><a class="khang" href="profile.htm"><span class="ico-account"></span>Hello ${acc.tenDangNhap }</a></li>
						<li><a class="khang" href="logout.htm"><span class="ico-signout"></span>Đăng xuất</a></li>
					</c:if>
					<c:if test="${sessionScope.acc ==null }">
						<li><a class="khang" href="login1.htm"><span class="ico-signout"></span>Đăng nhập</a></li>
					</c:if>
					
				</ul>
			</div>
		</div>
		<!-- / container -->
	</header>
	<!-- / header -->

	<nav id="menu">
		<div class="container">
			<div class="trigger"></div>
			<ul>
				<li><a href="trang-chu.htm">TRANG CHỦ</a></li>
				<li><a href="products.htm?index=1">SẢN PHẨM</a></li>
				<li><a href="category.htm?cid=1">NHẪN</a></li>
				<li><a href="category.htm?cid=2">ĐỒNG HỒ</a></li>
				<li><a href="category.htm?cid=3">BÔNG TAI</a></li>
				<li><a href="category.htm?cid=4">DÂY CHUYỀN</a></li>
				<li><a href="category.htm?cid=6">NHẪN BẠC</a></li>
			<!-- 	 <li><a href="https://www.facebook.com/khang.khang.5496">VỀ CHÚNG TÔI</a></li> -->
			</ul>
		</div>
		<!-- / container -->
	</nav>