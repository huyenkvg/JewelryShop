<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<body>

	<div id="breadcrumbs">
		<div class="container">
			<ul>
				<li><a href="trang-chu.htm">Home</a></li>
				<li>Cart</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	<div id="body">
		<div class="container">
			<div id="content" class="full">
				<div class="cart-table">
					<table>
						<tr>
							<th class="items">SẢN PHẨM</th>
							<th class="price">GÍA</th>
							<th class="total">Size</th>
							<th class="qnt">SỐ LƯỢNG</th>
							<th class="total">TỔNG TIỀN</th>
							<th class="edit">SỬA</th>
							<th class="delet">XÓA</th>
						</tr>
						<c:forEach var="item" items="${ Cart }">
							<tr>
								<td class="items">
									<div class="image">
										<a href="<c:url value ='detail${item.value.product.id }?size=${item.value.product.size }'/>">
										<img
											src="<c:url value ='/resources/images/${ item.value.product.image }'/>"
											alt="">
										</a>
									</div>
									<h3>
										<a href="<c:url value ='detail${item.value.product.id }?size=${item.value.product.size }'/>">${ item.value.product.name }</a>
									</h3>
									<p>${ item.value.product.description }</p>
								</td>
								<td class="khang"><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.product.price }"/> ₫</td>
								<td class="khang ">Size:  ${ item.value.product.size } </td>
								<td class="qnt">
									<input type="number" min="1" max="100" class="span1" style="max-width:70px" placeholder="1" id="quanty-cart-${ item.key }" size="16" type="text" value="${ item.value.quanty }">
								</td>
								
								<td class="khang " ><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.totalPrice }"/> đ</td>
								<td class="sua"><button data-id="${ item.key } "
										class="edit-cart" type="button">Sửa</button></td>
								<td class="xoa"><button data-id="${ item.key }  "
										class="delete-cart ico-del" type="button"></button></td>
				
							</tr>
						</c:forEach>
					</table>
				</div>

				<div class="total-count">
					<h3 >
						Tổng tiền : <strong class="colordo"><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart}"/> VNĐ</strong>
					</h3>
					<c:if test="${empty a  }">
					<a href="login1.html" class="btn-grey">Đăng nhập</a>
					</c:if>
					<c:if test="${not empty a && empty Cart}">
					<a href="products?index=1" class="btn-grey">Mua hàng</a>
					</c:if>
					<c:if test="${not empty a && not empty Cart }">
					<a href="checkout" class="btn-grey">Đặt hàng</a>
					</c:if>
				
				</div>

			</div>
			<!-- / content -->
<h1>${success }</h1>
		<!-- / container -->
	</div>
	<!-- / body -->

	<content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-" +id).val();
			var select = $('#select').val();
			alert("Sửa Thành công");
			window.location = "EditCart/" + id + "/" + quanty;
			
			
		});
	</script>
	
	<script>
		$(".delete-cart").on("click", function() {
			var id = $(this).data("id");
			//confirm("Bạn có chắc chắn muốn xóa.");
			 if(confirm("Bạn có chắc chắn muốn xóa. Chọn OK để XÓA") == true){
				 window.location = "DeleteCart/"+id;
			 }
			 else{
				 return;
			 }
		});
	</script>
	
	 </content>
</body>
</html>