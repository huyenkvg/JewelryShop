package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.DAO;
import Entity.Account;
import Entity.Customer;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@RequestMapping("login1")
	String index() {
		return "user/login";
	}
	
	
	@RequestMapping("login")
	String index(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String username = rq.getParameter("user");
		String password = rq.getParameter("pass");
		
		DAO dao = new DAO();
		Account a = dao.login(username, password);
		
		if(a==null) {
			rq.setAttribute("mess", "TÃªn Ä‘Äƒng nháº­p hoáº·c máº­t kháº©u sai!");
		}
		else {
			rp.sendRedirect("trang-chu.htm");
			HttpSession session = rq.getSession();
			session.setAttribute("acc", a);
			session.setMaxInactiveInterval(3600);
			session.setAttribute("a", a.getSDT());
			
		}

		return "user/login";
	}
	
	@RequestMapping("logout")
	void logout(HttpServletRequest rq,HttpServletResponse rp) throws IOException {
		HttpSession session = rq.getSession();
		session.removeAttribute("acc");
		session.removeAttribute("a");
		session.removeAttribute("address");

		rp.sendRedirect("trang-chu.htm");
	}
	
	@RequestMapping("signup")
	void signUP(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
		String SDT = rq.getParameter("Number");
		String hoTen =rq.getParameter("Name");
		String ngaySinh =rq.getParameter("Date");
		String diaChi = rq.getParameter("Address");
		String user = rq.getParameter("userDK");
		String pass= rq.getParameter("passDK");
		String rePass = rq.getParameter("repass");
		if(!pass.equals(rePass)) {
			
			rq.setAttribute("mess", "Đăng kí thất bại do mật khẩu không trùng nhau!");
			rq.getRequestDispatcher("login1.htm").forward(rq, rp);
		}
		else {
			DAO dao = new DAO();
			Account a = dao.checkExistslogin(user);
			Customer customer = dao.checkExistsKhachHang(SDT);
			if(a==null && customer==null) {
				
				dao.themKhachHang(SDT, hoTen, ngaySinh, diaChi,1,"");
				dao.dangKiTaiKhoan(SDT, user, pass);
			
				rq.setAttribute("mess1", "Đăng ký thành công!");
				
				rq.getRequestDispatcher("login1.htm").forward(rq, rp);
							}
			else {
				
				rq.setAttribute("mess", "Đăng kí thất bại do trùng số điện thoại hoặc tên đăng nhập !");
				
				rq.getRequestDispatcher("login1.htm").forward(rq, rp);
			}
		}
	}
	
	@RequestMapping("profile")
	String profile(HttpServletRequest rq, HttpSession session) {
		DAO dao = new DAO();
		String id = (String) session.getAttribute("a");
		Customer customer = dao.getCustomer(id);
		rq.setAttribute("Customer", customer);
		session.setAttribute("address", customer.getDiaChi());
		
		return "user/profile";
	}
	
	
	@RequestMapping("editProfile")
	String editProfile(HttpServletRequest rq, HttpSession session) {
		DAO dao = new DAO();
		String id = (String) session.getAttribute("a");
		
		String hoTen = rq.getParameter("hoTen");
		String ngaySinh = rq.getParameter("ngaySinh");
		String diaChi = rq.getParameter("diaChi");
		if(dao.editCustomer(id, hoTen, ngaySinh, diaChi)>0) {
			session.setAttribute("messa", "Lưu thông tin thành công!");
		}
		dao.editCustomer(id, hoTen, ngaySinh, diaChi);
		return "redirect:" + rq.getHeader("Referer");
	}
}
