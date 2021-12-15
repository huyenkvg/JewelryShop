package Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.DAO;
import Entity.Product;

@Controller

public class HomeController {
	@RequestMapping(value = { "/", "/trang-chu" })
	public String Index(ModelMap model) {
		DAO dao = new DAO();
    	List<Product> list = dao.getLastProDuct();
    	model.addAttribute("listP", list);
		return "user/index";
	}
	
	@RequestMapping("/admin/test")
	String index() {
		return "admin/index";
	}
	
}