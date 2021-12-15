<%@ page pageEncoding="utf-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<body>

<div id="breadcrumbs">
	
		<div class="container">
			<ul>
				<li><a href="trang-chu">Home</a></li>
				<li>Products</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	<div id="body">
		<div class="container">
				<div class="pagination">
<%-- 				<ul>
				<li><a href="#"><span class="ico-prev"></span></a></li>
				<c:forEach begin= "1" end = "${endP }" var ="i">
				<li><a href="category?indexx=${i}">${i }</a></li>
				</c:forEach>

					<li><a href="#"><span class="ico-next"></span></a></li>
				</ul> --%>
			</div> 
			<div class="products-wrap">
		
				 <aside id="sidebar">
					<div class="widget">
					
						<h3>LOẠI SẢN PHẨM</h3>
						<ul>
						<c:forEach items= "${listC }" var = "o">
							<li><a href="category?cid=${o.cid }"><span
								> ${ o.cname }</span></a></li>
								
						</c:forEach>	
						</ul>
					</div>
					
				</aside>  
				<div id="content">
					<section class="products">
					<c:forEach items="${listP}" var ="o">
					<article>
					<!-- C:\\Users\\Khang\\Downloads\\DoAn_TiemKimHoan\\DoAn_TiemKimHoan\\src\\main\\webapp\\assets\\Images\\SanPham" -->
								 <%--  <a href="<c:url value ='detail${o.id }?size=${o.size }'/>"><img src="C:\Users\Khang\eclipse-workspace\WebBanTrangSuc\src\main\webapp\assets\Images\SanPham\ ${o.image }" alt=""></a>  --%> 
						 	 <a href="<c:url value ='detail${o.id }?size=${o.size }'/>"><img src="<c:url value ='/resources/images/${o.image }'/>" alt=""></a>  
					<%-- 	     <a href="editcart/${o.id }/${o.size}"><img src="<c:url value ='/resources/images/${o.image }'/>" alt=""></a>  --%>
							<h3><a href="<c:url value ='detail${o.id }?size=${o.size }'/>">${o.name }</a></h3>
							<h4><a class ="colorvang"href="<c:url value ='detail${o.id }?size=${o.size }'/>"><fmt:formatNumber type="number" groupingUsed="true" value="${ o.price }"/> đ</a></h4>
							
							<%-- <p>Size:${o.size }<p> --%>
							<c:if test="${not empty a  }">
							<a href ="<c:url value ='AddCart/${o.id }'/>" class="btn-add">ADD TO CART</a>
							</c:if>
							<c:if test="${empty a  }">
							<a href ="login1" class="btn-add">ADD TO CART</a>
							</c:if>
							
							
						</article>
					</c:forEach>
				
					</section>
				</div>
				<!-- / content -->
			</div>
			<div class="pagination">
				<ul>
				<!-- <li><a href="#"><span class="ico-prev"></span></a></li> -->
				<c:forEach begin= "1" end = "${endP }" var ="i" >
				<li class ="${active==i?"active":""}"><a href="products?index=${i}">${i }</a></li>
				</c:forEach>
				 <li><a href="products?index=1"><span class="ico-prev" class="ico-prev" ></span></a></li>
				</ul>
			</div>
		</div>
	</div>	
		
		<!-- / container -->
	<!-- / body -->
</body>
</html>