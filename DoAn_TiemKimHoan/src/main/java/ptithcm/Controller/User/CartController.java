package ptithcm.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import DAO.DAO;
import DAO.donHangDAO;
import Entity.Account;
import Entity.Cart;
import Entity.ChiTietDatHang;
import Entity.DonDatHang;
import Service.CartServiceImpl;

@Controller
public class CartController {

	private CartServiceImpl cartService = new CartServiceImpl();

	@RequestMapping(value = "cart")
	public String Index() {

		return "user/cart";
	}

	@RequestMapping(value = "AddCart/{id}")
	String AddCart(HttpServletRequest rq, HttpSession session, @PathVariable long id) {
		HashMap<String, Cart> cart = (HashMap<String, Cart>) session.getAttribute("Cart");
		String size = rq.getParameter("size");
		if (cart == null) {
			cart = new HashMap<String, Cart>();
		}
		cart = cartService.AddCart(id, size, cart);

		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + rq.getHeader("Referer");

	}

	@RequestMapping(value = "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest rq, HttpSession session, @PathVariable String id,
			@PathVariable int quanty) {
		HashMap<String, Cart> cart = (HashMap<String, Cart>) session.getAttribute("Cart");
		// String size = rq.getParameter("size");
		if (cart == null) {
			cart = new HashMap<String, Cart>();
		}

		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + rq.getHeader("Referer");
	}

	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, Cart> cart = (HashMap<String, Cart>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, Cart>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}


	  @RequestMapping(value = "checkout", method= RequestMethod.GET)
	  public String checkOut(HttpServletRequest rq, HttpSession session) {
		  DonDatHang dh = new DonDatHang();	  
		  rq.setAttribute("DonDatHang", dh);
	  return "user/checkout"; 
	  }

	  @RequestMapping(value="checkout", method = RequestMethod.POST)
	  public String themDonHang(HttpServletRequest rq, HttpSession session,@ModelAttribute("DonDatHang") DonDatHang dh,BindingResult errors) {
		  long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		if (dh.getDiaChiNhanHang().trim().length() == 0) {
			errors.rejectValue("diaChiNhanHang", "DonDatHang", "Vui lòng nhập đia chỉ nhận hàng  !");
			return "user/checkout";
		}
//		String maKhachHang = rq.getParameter("maKhachHang");
//		String maGiamGia = rq.getParameter("maGiamGia");
//		String diaChi = rq.getParameter("diaChiNhanHang");
//		String ghiChu = rq.getParameter("ghiChu");
		else {
		 dh.setNgay(String.valueOf(date));
		 dh.setPhuongThucThanhToan(true);
		 donHangDAO dao = new donHangDAO();
		 if(dao.themDonHang(dh) >0 ) {
			 HashMap<String, Cart> cart = (HashMap<String, Cart>) session.getAttribute("Cart");
			 dao.themChiTietDonHang(cart);
			 
		 }
		  
		  
		  	session.removeAttribute("Cart");
			session.removeAttribute("TotalQuantyCart");
			session.removeAttribute("TotalPriceCart");
		}
		  return "user/index";
	  }

}
