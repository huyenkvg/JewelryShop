package Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import DAO.DAO;
import Entity.DanhGia;
import Entity.Product;

@Controller
@RequestMapping("/user")
public class ProductDetailController {
	@RequestMapping("detail{id}")
	String index(HttpServletRequest rq,HttpSession session,@PathVariable String id ) {
	//	String id = rq.getParameter("id");
		String size = rq.getParameter("size");
		DAO dao = new DAO();
		session.setAttribute("idProduct", id);
		//String size = rq.getParameter("s");
		if(size==null) {
			size="1";
		}
		session.setAttribute("te1", size);
		Product product = dao.getProductByID(id,Integer.parseInt(size));
		rq.setAttribute("detail", product);
		  List<Product> list = dao.getSize(String.valueOf(id)); rq.setAttribute("combobox",
		  list);
		  rq.setAttribute("combobox", list);
		  List<DanhGia> list1=dao.GetDanhGia(id);
		  rq.setAttribute("danhgia", list1);
		/*
		 * Product product1 = dao.getProductByID2(id1,quanty); rq.setAttribute("detail",
		 * product1);
		 */
//		Product list2 = dao.getProductByID2(id);	
//		rq.setAttribute("detail", list2);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("user/details");
		return "user/details";	
		
	}
	
//	@RequestMapping(value = "EditCart1/{id}/{size}")
//	String test(HttpServletRequest rq,HttpSession session ,@PathVariable int id,@PathVariable int size) {
//		DAO dao = new DAO();
//		
//		Product product = dao.getProductByID2(id,size);	
//		rq.setAttribute("detail", product);
//		List<Product> list = dao.getProductByID1(String.valueOf(id));
//		rq.setAttribute("combobox", list);
////		return "redirect:"+rq.getHeader("Referer");	
//		session.setAttribute("te1", size);
//		//Product product = dao.getProductByID2(Integer.parseInt(id),Integer.parseInt(size));
//		//rq.setAttribute("detail", product);
//		
//		 
//		
//		  //List<Product> list = dao.getProductByID1(String.valueOf(id)); rq.setAttribute("combobox",
//		  //list);
//		 // rq.setAttribute("combobox", list);
//		  List<DanhGia> list1=dao.GetDanhGia(String.valueOf(id));
//		  rq.setAttribute("danhgia", list1);
//		  return "user/details";
//	}
	
	
	
	@RequestMapping("rate")
	String rate(HttpServletRequest rq, HttpSession session) {
		int danhGiaSao = Integer.parseInt(rq.getParameter("danhgiasao"));
		String danhGia = rq.getParameter("danhgia");
//		String test = rq.getParameter("test");
		
		String SDT = (String) session.getAttribute("a");
//		session.setAttribute("b", test);
		String id =(String) session.getAttribute("idProduct");
			DAO dao = new DAO();
			
			dao.themDanhGia(SDT, id, danhGia, danhGiaSao);
			String name= rq.getParameter("Name");
			System.out.println(SDT);
			System.out.println(id);
			System.out.println(danhGia);
			System.out.println(danhGiaSao);

		
		return "redirect:"+rq.getHeader("Referer");	
}
	
	
	
	@RequestMapping("deleteRate")
	String deleteRate(HttpServletRequest rq, HttpSession session) {
		String id =(String) session.getAttribute("idProduct");
		String SDT = (String) session.getAttribute("a");
		DAO dao = new DAO();
		dao.xoaDanhGia(SDT, id);
		
		return "redirect:"+rq.getHeader("Referer");	

	}
}
	
	

