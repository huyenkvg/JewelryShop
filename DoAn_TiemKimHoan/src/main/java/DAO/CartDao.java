package DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Entity.Cart;
import Entity.Product;
@Repository
public class CartDao {
	@Autowired
	DAO dao = new DAO();
	public HashMap<String, Cart> AddCart(long id,String size, HashMap<String, Cart> cart) {
		Cart itemCart = new Cart();
		if(size==null){
			size="1";
		}
		
		Product product = dao.getProductByID(String.valueOf(id),Integer.parseInt(size));
		String id1= id+"k"+size;
		//nếu trong giỏ hàng đã có sản phẩm này
		if (product != null && cart.containsKey(id1)  ) { 
			itemCart = cart.get(id1);
			itemCart.setQuanty(itemCart.getQuanty() + 1);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
			
		} else {
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());		
		}
		cart.put(id1, itemCart);
		return cart;
	}
	
	public HashMap<String, Cart> EditCart(String id, int quanty, HashMap<String, Cart> cart) {
		if (cart == null) {
			return cart;
		}
		
		Cart itemCart = new Cart();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			double totalPrice = quanty * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(String.valueOf(id), itemCart);
		return cart;
	}

	public HashMap<String, Cart> DeleteCart(String id, HashMap<String, Cart> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuanty(HashMap<String, Cart> cart) {
		int totalQuanty = 0;
		for (Map.Entry<String, Cart> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<String, Cart> cart) {
		double totalPrice = 0;
		for (Map.Entry<String, Cart> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}

