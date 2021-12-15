package Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;


import Entity.Cart;


@Service
public interface ICartService {

	public HashMap<String, Cart> AddCart(long id,String size, HashMap<String, Cart> cart);
	public HashMap<String, Cart> EditCart(String id, int quanty, HashMap<String, Cart> cart);
	public HashMap<String, Cart> DeleteCart(String id, HashMap<String, Cart> cart);
	public int TotalQuanty(HashMap<String, Cart> cart);
	public double TotalPrice(HashMap<String, Cart> cart);
}
