package Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.CartDao;
import Entity.Cart;


@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartDao cartDao = new CartDao();
	
	public HashMap<String, Cart> AddCart(long id,String size, HashMap<String, Cart> cart) {
		return cartDao.AddCart(id,size, cart);
	}

	public HashMap<String, Cart> EditCart(String id, int quanty, HashMap<String, Cart> cart) {
		return cartDao.EditCart(id, quanty, cart);
	}

	public HashMap<String, Cart> DeleteCart(String id, HashMap<String, Cart> cart) {
		return cartDao.DeleteCart(id, cart);
	}

	public int TotalQuanty(HashMap<String, Cart> cart) {
		return cartDao.TotalQuanty(cart);
	}

	public double TotalPrice(HashMap<String, Cart> cart) {
		return cartDao.TotalPrice(cart);
	}

	
}
