package assignment.src.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import assignment.src.model.entity.Cart;

public interface ICartService {

	BigDecimal getAmount();

	int getCount();

	Collection<Cart> getAllCart();

	void clearAll();

	Cart updateIncreace(Long id);
	
	Cart updateDecreace(Long id);
	
	BigDecimal getPrice(Long Id);

	void remove(Long id);

	void add(Cart cart);
	
	int getCartSize();
}
