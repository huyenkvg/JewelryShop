package ptithcm.Controller.User;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.DAO;
import Entity.Category;
import Entity.Product;

@Controller
public class ProductsController {
	@RequestMapping("products")
	String productsController(HttpServletRequest request, HttpServletResponse response) {
		DAO dao  = new DAO();
		String indexPage = request.getParameter("index");
		if(indexPage ==null) {
			indexPage ="1";
		}
		int index = Integer.parseInt(indexPage);
		List<Product> list = dao.getPageProducts(index);
    	request.setAttribute("listP", list);
		List<Category> listCaterogy = dao.getAllCategory();
		request.setAttribute("listC",listCaterogy);
		int endPage = dao.getNumberPage();
		request.setAttribute("active", index);
		request.setAttribute("endP", endPage);
		return "user/products";
	}
	@RequestMapping("category")
	String category(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();
		String cateID = request.getParameter("cid");
		List<Product> list = dao.getProductByCategory(cateID);
//	  String indexPage = request.getParameter("indexx");
//	  if(indexPage ==null) {
//	  indexPage ="1"; }
//	  int index = Integer.parseInt(indexPage);
//	  List<Product> list = dao.getPageCateProducts(index,cateID);

		
		request.setAttribute("listP", list);
		List<Category> listCaterogy = dao.getAllCategory();
		request.setAttribute("listC",listCaterogy);
		int endPage = dao.getNumberPage();
		request.setAttribute("endP", endPage);
		
		
		return "user/products";
	}
	
}
