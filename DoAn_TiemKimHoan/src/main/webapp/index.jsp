<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<header id="header">
<meta charset="utf-8">
	<title>Shop Trang Sức</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
	<link rel="stylesheet" media="all" href="<c:url value ='/resources/css/style.css'/>">
	 <link rel="stylesheet" media="all" href="<c:url value ='/resources/css/test.css'/>"> 
		<div class="container">
			<a href="trang-chu.htm" id="logo" title="PTIT BÁN VÀNG">A PTIT</a>
			<div class="right-links">
				<ul>
					<li><a class="khang" href="user/cart.htm"><span class="ico-products"></span>${Cart.size() } Sản phẩm, <fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceCart }"/> VNĐ</a></li>
					
					<c:if test="${sessionScope.acc !=null }">
						<li><a class="khang" href="user/profile.htm"><span class="ico-account"></span>Hello ${acc.tenDangNhap }</a></li>
						<li><a class="khang" href="user/logout.htm"><span class="ico-signout"></span>Đăng xuất</a></li>
					</c:if>
					<c:if test="${sessionScope.acc ==null }">
						<li><a class="khang" href="user/login1.htm"><span class="ico-signout"></span>Đăng nhập</a></li>
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
				<li><a href="user/trang-chu.htm">TRANG CHỦ</a></li>
				<li><a href="user/products.htm?index=1">SẢN PHẨM</a></li>
				<li><a href="user/category.htm?cid=1">NHẪN</a></li>
				<li><a href="user/category.htm?cid=2">ĐỒNG HỒ</a></li>
				<li><a href="user/category.htm?cid=3">BÔNG TAI</a></li>
				<li><a href="user/category.htm?cid=4">DÂY CHUYỀN</a></li>
				<li><a href="user/category.htm?cid=6">NHẪN BẠC</a></li>
			<!-- 	 <li><a href="https://www.facebook.com/khang.khang.5496">VỀ CHÚNG TÔI</a></li> -->
			</ul>
		</div>
		<!-- / container -->
	</nav>
<body>
	<div id="slider">
		<ul>
			<li
				style="background-image: url(<c:url value ='/resources/images/0.jpeg'/>)">
				<h3>Make your life better</h3>
				<h2>Genuine diamonds</h2> <a href="user/products.htm?index=1"
				class="btn-more">Read more</a>
			</li>
			<li class="purple"
				style="background-image: url(<c:url value ='/resources/images/a.jpg'/>)">
				<h3>She will say “yes”</h3>
				<h2>engagement ring</h2> <a href="#" class="btn-more">Read more</a>
			</li>
			<li class="yellow"
				style="background-image: url(<c:url value ='/resources/images/02.jpg'/>)">
				<h3>You deserve to be beauty</h3>
				<h2>golden bracelets</h2> <a href="#" class="btn-more">Read more</a>
			</li>
		</ul>
	</div>
	<!-- / body -->

	<div id="body">
		<div class="container">
			<div class="last-products">
				<h2>SẢN PHẨM MỚI</h2>
				<section class="products">
					<c:forEach items="${listP}" var="o">
						<article>
							<a href="<c:url value ='user/detail${o.id }?size=${o.size }'/>"><img
								src="<c:url value ='/resources/images/${o.image }'/>" alt=""></a>
							<h3>
								<a href="<c:url value ='user/detail${o.id }?size=${o.size }'/>">${o.name }</a>
							</h3>
							<h4>
								<a class="colorvang"
									href="<c:url value ='user/detail${o.id }?size=${o.size }'/>"><fmt:formatNumber
										type="number" groupingUsed="true" value="${ o.price }" /> đ</a>
							</h4>
							<c:if test="${not empty a  }">
								<a href="<c:url value ='user/AddCart/${o.id }'/>" class="btn-add">ADD
									TO CART</a>
							</c:if>
							<c:if test="${empty a  }">
								<a href="user/login1" class="btn-add">ADD TO CART</a>
							</c:if>
						</article>


					</c:forEach>
				</section>

			</div>
			<section class="quick-links">
				<article
					style="background-image: url(<c:url value ='/resources/images/a.jpg'/>)">
					<a href="#" class="table">
						<div class="cell">
							<div class="text">
								<h4>Lorem ipsum</h4>
								<hr>
								<h3>Dolor sit amet</h3>
							</div>
						</div>
					</a>
				</article>
				<article class="red"
					style="background-image: url(<c:url value ='/resources/images/3.jpg'/>)">
					<a href="#" class="table">
						<div class="cell">
							<div class="text">
								<h4>consequatur</h4>
								<hr>
								<h3>voluptatem</h3>
								<hr>
								<p>Accusantium</p>
							</div>
						</div>
					</a>
				</article>
				<article
					style="background-image: url(<c:url value ='/resources/images/4.jpg'/>)">
					<a href="#" class="table">
						<div class="cell">
							<div class="text">
								<h4>culpa qui officia</h4>
								<hr>
								<h3>magnam aliquam</h3>
							</div>
						</div>
					</a>
				</article>
			</section>
		</div>
		<!-- / container -->
	</div>
</body>

<footer id="footer">
		<div class="container">
			<div class="cols">
				<div class="col">
					<h3>Frequently Asked Questions</h3>
					<ul>
						<li><a href="#">Fusce eget dolor adipiscing </a></li>
						<li><a href="#">Posuere nisl eu venenatis gravida</a></li>
						<li><a href="#">Morbi dictum ligula mattis</a></li>
						<li><a href="#">Etiam diam vel dolor luctus dapibus</a></li>
						<li><a href="#">Vestibulum ultrices magna </a></li>
					</ul>
				</div>
				<div class="col media">
					<h3>Social media</h3>
					<ul class="social">
						<li><a href="https://www.facebook.com/khang.khang.5496"><span class="ico ico-fb"></span>Facebook</a></li>
						<li><a href="#"><span class="ico ico-tw"></span>Twitter</a></li>
						<li><a href="#"><span class="ico ico-gp"></span>Google+</a></li>
						<li><a href="#"><span class="ico ico-pi"></span>Pinterest</a></li>
					</ul>
				</div>
				<div class="col contact">
					<h3>Contact us</h3>
					<p>PTIT Jewelry INC.<br>97 Man Thiện Phường Hiệp Phú<br>TP Hồ Chí Minh</p>
					<p><span class="ico ico-em"></span><a href="#">hmkhang2000@gmail.com</a></p>
					<p><span class="ico ico-ph"></span>0943 526 733</p>
				</div>
				<div class="col newsletter">
					<h3>Join our newsletter</h3>
					<p>Sed ut perspiciatis unde omnis iste natus sit voluptatem accusantium doloremque laudantium.</p>
					<form action="#">
						<input type="text" placeholder="Your email address...">
						<button type="submit"></button>
					</form>
				</div>
			</div>
			<p class="copy"></p>
		</div>
		<!-- / container -->
			<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write("<script src='js/jquery-1.11.1.min.js'>\x3C/script>")</script>
	<script src="<c:url value = '/resources/js/plugins.js'/>"></script>
	<script src="<c:url value ='/resources/js/main.js'/>"></script> 
    <script src="/script.js"></script>
	<dec:getProperty property="page.script"/>
	</footer>
</html>
