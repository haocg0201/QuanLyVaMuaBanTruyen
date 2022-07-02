package assignment.src.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import assignment.src.model.entity.Cart;
import assignment.src.service.ICartService;

@SessionScope
@Service
public class CartService implements ICartService{	
	Map<Long, Cart> mapCarts = new HashMap<>();
	
	@Override
	public void add(Cart cart) {
		Cart cartItem = mapCarts.get(cart.getComicId());
		if(cartItem == null) {
			mapCarts.put(cart.getComicId(), cart);
		}else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	}
	
	
	
	@Override
	public void remove(Long id) {
		mapCarts.remove(id);
	}
	
	@Override
	public Cart updateIncreace(Long id) {
		Cart cart = mapCarts.get(id);
		cart.setQuantity(cart.getQuantity()+1);
		return cart;
	}
	
	@Override
	public Cart updateDecreace(Long id) {
		Cart cart = mapCarts.get(id);
		cart.setQuantity(cart.getQuantity()-1);
		return cart;
	}
	
	@Override
	public BigDecimal getPrice(Long Id) {
		Cart cart = mapCarts.get(Id); 
		double temp = cart.getPrice().doubleValue() * cart.getQuantity();		
		return new BigDecimal(temp);
	}
	
	@Override
	public void clearAll() {
		mapCarts.clear();
	}
	
	@Override
	public Collection<Cart> getAllCart(){
		return mapCarts.values();
	}
	
	public Cart getACart(Long id) {
		return mapCarts.get(id);
	}
	
	@Override
	public int getCount() {
		return mapCarts.values().size();
	}
	
	@Override
	public BigDecimal getAmount() {
		 double amount = mapCarts.values().stream().mapToDouble(item -> item.getQuantity() * item.getPrice().doubleValue()).sum();
		 BigDecimal bigAmount = new BigDecimal(amount);
		 return bigAmount;
	}



	@Override
	public int getCartSize() {
		 return mapCarts.size();
	}
}
