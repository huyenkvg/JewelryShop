<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	<div id="slider">
		<ul>
			<li
				style="background-image: url(<c:url value ='/resources/images/0.jpeg'/>)">
				<h3>Make your life better</h3>
				<h2>Genuine diamonds</h2> <a href="products.htm?index=1"
				class="btn-more">Read more</a>
			</li>
			<li class="purple"
				style="background-image: url(<c:url value ='/resources/images/a.jpg'/>)">
				<h3>She will say “yes”</h3>
				<h2>engagement ring</h2> <a href="products.htm?index=1" class="btn-more">Read more</a>
			</li>
			<li class="yellow"
				style="background-image: url(<c:url value ='/resources/images/02.jpg'/>)">
				<h3>You deserve to be beauty</h3>
				<h2>golden bracelets</h2> <a href="products.htm?index=1" class="btn-more">Read more</a>
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
							<a href="<c:url value ='detail${o.id }.htm?size=${o.size }'/>"><img
								src="<c:url value ='/resources/images/${o.image }'/>" alt=""></a>
							<h3>
								<a href="<c:url value ='detail${o.id }.htm?size=${o.size }'/>">${o.name }</a>
							</h3>
							<h4>
								<a class="colorvang"
									href="<c:url value ='detail${o.id }.htm?size=${o.size }'/>"><fmt:formatNumber
										type="number" groupingUsed="true" value="${ o.price }" /> đ</a>
							</h4>
							<c:if test="${not empty a  }">
								<a href="<c:url value ='AddCart/${o.id }.htm'/>" class="btn-add">ADD
									TO CART</a>
							</c:if>
							<c:if test="${empty a  }">
								<a href="login1" class="btn-add">ADD TO CART</a>
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
</html>
