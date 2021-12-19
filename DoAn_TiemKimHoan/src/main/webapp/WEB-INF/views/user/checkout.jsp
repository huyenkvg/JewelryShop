 <%@ page pageEncoding="utf-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>

<body>

<!------ Include the above in your HEAD tag ---------->
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


	<div id="breadcrumbs">
		<div class="container">
			<ul>
				<li><a href="trang-chu.htm">Home</a></li>
				<li>CheckOut</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	 <br>
	  <br>
	   <br>
<div class="container wrapper">
         
           
            <div class="row cart-body">
                 
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
                    <!--REVIEW ORDER-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            Xem lại đơn đặt hàng <div class="pull-right"><small><a class="afix-1" href="cart.html">Sửa Giỏ Hàng</a></small></div>
                        </div>
                        <div class="panel-body form-horizontal">
                       <c:forEach items="${Cart }" var ="item">
                       
                         <div class="form-group">
                                <div class="col-sm-3 col-xs-3">
                                    <img class="img-responsive" src="<c:url value ='/resources/images/${ item.value.product.image }'/>" />
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="col-xs-12">${item.value.product.name }</div>
                                     <div class="col-xs-12">Size: ${item.value.product.size }</div>
                                    <div class="col-xs-12"><small>Số lượng:<span>${ item.value.quanty }</span></small></div>
                                   
                                </div>
                                <div class="col-sm-3 col-xs-3 text-right">
                                    <h6><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.product.price}"/> VNĐ</h6>
                                </div>
                                 
                            </div>
                           <hr>
                       </c:forEach>
                          
                            
                            
                       
                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <strong>Tổng tiền đơn hàng</strong>
                                    <div class="pull-right colordo"><span><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart}"/> VNĐ</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--REVIEW ORDER END-->
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-info">
                        <div class="panel-heading">Đơn đặt hàng</div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <h4>Thanh toán đơn hàng</h4>
                                </div>
                            </div>
                            <div class="form-group">
                               
                            </div>
                   <form:form action="checkout.htm" method="POST" modelAttribute="DonDatHang" class="form-horizontal">  
                            <div class="form-group">
                                <div class="col-md-12"><strong>Số điện thoại:</strong></div>
                                <div class="col-md-12">
                                  <form:input type="text" class="form-control" placeholder="Nhập số điện thoại" path="maKhachHang" value="${a }" readonly="true"/>  
                                </div>
                            </div>
                            
                              <div class="form-group">
                                <div class="col-md-12"><strong>Phương thức thanh toán:</strong></div>
                                <div class="col-md-12">
                                  <select name ="thanhtoan">
                                  <option value="1">Thanh toán khi nhận hàng</option>
                                  </select>
                                </div>
                            </div>
                                <div class="form-group">
                                <div class="col-md-12"><strong>Địa chỉ nhận hàng:</strong></div>
                                <div class="col-md-12">
                                    <form:input type="text" placeholder="Nhập địa chỉ nhận hàng" path ="diaChiNhanHang" class="form-control" value="${address }"/>
                                    <form:errors path="diaChiNhanHang" class="text-danger"/>
                                </div>
                            </div>
                               <div class="form-group">
                                <div class="col-md-12"><strong>Mã giảm giá:</strong></div>
                                <div class="col-md-12">
                                    <form:input type="text" path="maGiamGia" placeholder="Nhập mã giảm giá (Nếu có)" class="form-control" value="" />
                                </div>
                            </div>
                                  <div class="form-group">
                                <div class="col-md-12"><strong>Ghi Chú:</strong></div>
                                <div class="col-md-12">
                                    <form:textarea type="text" path="ghiChu"  class="form-control " cols="100" rows="4" />
                                </div>
                            </div>
                            <div class="form-group test">
                                <div class="col-xs-12">
                                
                                <c:choose>
  <c:when test="${DonDatHang.diaChiNhanHang==null}">
   <button type="submit" class="btn btn-primary btn-submit-fix" onclick="alert('Thanh toán thất bại!')">Thanh toán</button>
  </c:when>

  <c:when test="${DonDatHang.diaChiNhanHang !=null}">
    <button type="submit" class="btn btn-primary btn-submit-fix" onclick="alert('Thanh toán thành công!')">Thanh toán</button> 
  </c:when>
</c:choose>
                              <%--   <c:if test="${DonDatHang.diaChiNhanHang==null}"> <button type="submit" class="btn btn-primary btn-submit-fix" onclick="alert('Thanh toán thất bại!')">Thanh toán</button> </c:if>
                                
            					<c:if test="${DonDatHang.diaChiNhanHang !=null">
            					<button type="submit" class="btn btn-primary btn-submit-fix" onclick="alert('Thanh toán thành công!')">Thanh toán</button> 
            					</c:if> --%>
                               
                                
 								                               </div>
                            </div>
                            </form:form>
                        </div>
                    </div>
                    <!--SHIPPING METHOD END-->
                    <!--CREDIT CART PAYMENT-->
                    
                
                    <!--CREDIT CART PAYMENT END-->
                </div>
                
             	
            </div>
            <div class="row cart-footer">
        
            </div>
            
    </div>
   
</body>


</html> 