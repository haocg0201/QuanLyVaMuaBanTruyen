package assignment.src.controller.site;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.src.model.entity.Account;
import assignment.src.model.entity.Cart;
import assignment.src.model.entity.Comic;
import assignment.src.model.entity.Order;
import assignment.src.model.entity.OrderDetail;
import assignment.src.repository.IOrderDetailRepository;
import assignment.src.service.ICartService;
import assignment.src.service.IOrderDetailService;
import assignment.src.service.impl.AccountService;
import assignment.src.service.impl.CartService;
import assignment.src.service.impl.ComicService;
import assignment.src.service.impl.OrderDetailService;
import assignment.src.service.impl.OrderService;

@Controller
@RequestMapping("/home")
public class CartController {
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ComicService comicService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping("/shopping-cart/{id}")
	public String getAllCart(
			Model model,
			@PathVariable("id")Long id) {
		Comic comic = comicService.getAComicById(id);
		Cart cart = new Cart();
		cart.setComicId(comic.getComicId());
		cart.setComicName(comic.getComicName());
		cart.setImage(comic.getImage());
		cart.setPrice(comic.getCurrentPrice());
		cartService.add(cart);
		return "redirect:/home/shopping-cart";
	}
	
	@GetMapping("/shopping-cart")
	public String getAll(Model model) {
		Collection<Cart> lstCart = cartService.getAllCart();
		model.addAttribute("lstCart",lstCart);
		model.addAttribute("total",cartService.getAmount());
		return "/templates/site/shopping-cart";
	}
	
	@GetMapping(value = "shopping-cart",params="increace")
	public String increace(
			@RequestParam(name="increace")Long id
			) {
		System.out.println(cartService.getPrice(id));
		cartService.updateIncreace(id);
		return "redirect:/home/shopping-cart";
	}
	
	@GetMapping(value = "shopping-cart",params="decreace")
	public String decreace(
			@RequestParam(name="decreace")Long id
			) {
		System.out.println(cartService.getPrice(id));
		cartService.updateDecreace(id);
		return "redirect:/home/shopping-cart";
	}
	
	@GetMapping("shopping-cart/delete-all")
	public String deleteAll() {
		cartService.clearAll();
		return "redirect:/home/shopping-cart";
	}
	
	@GetMapping("/shopping-cart/delete/{id}")
	public String deleteACart(@PathVariable("id")Long id) {
		cartService.remove(id);
		return "redirect:/home/shopping-cart";
	}
	
	@GetMapping("shopping-cart/buy/{id}")
	public String buyAComic(@PathVariable("id")Long id) {			
		Cart cart = cartService.getACart(id);
		if(session.getAttribute("account") != null) {
			if(cart != null) { 
				// lưu hóa đơn và hóa đơn chi tiết
				Account account = (Account) session.getAttribute("account");
				Order order = new Order();
				order.setOrderId(null);
				order.setAmount(new BigDecimal(cart.getPrice().doubleValue() * cart.getQuantity()));
				order.setStatus(0);
				order.setAccount(account);
				Order justSave = orderService.saveOrder(order);
				System.out.println(justSave.toString());
				
				
				OrderDetail orderDetail = new OrderDetail();
				
				orderDetail.setOrderdetailId(null);
				orderDetail.setOrder(justSave);
				Optional<Comic> comic = comicService.getAComicTypeOptional(cart.getComicId());
				orderDetail.setComic(comic.get());
				double price = cart.getPrice().doubleValue() * cart.getQuantity();
				BigDecimal nowPrice = new BigDecimal(price);
				orderDetail.setPurchasedPrice(nowPrice);
				orderDetail.setPurchasedQuantity(cart.getQuantity());
				orderDetailService.saveOrderDetail(orderDetail);
				System.out.println(orderDetailService.saveOrderDetail(orderDetail).toString());
				
				// cập nhật số lượng
				Comic newComic = comic.get();
				newComic.setCurrentQuantity((comic.get().getCurrentQuantity() - cart.getQuantity()));
				comicService.updateComic(newComic);

				//xóa khỏi giỏ hàng
				cartService.remove(id);
				
				
				return "redirect:/home/shopping-cart";
			}
		}
		return "/templates/signin";
	}
	
	@GetMapping("shopping-cart/buy-all")
	public String buyAllCart() {
		Collection<Cart> lstCart = cartService.getAllCart();
		if(session.getAttribute("account") != null) {
			if(lstCart != null) {
				Account account = (Account) session.getAttribute("account");
				Order order = new Order();
				order.setOrderId(null);
				order.setAccount(account);
				order.setAmount(cartService.getAmount());
				order.setStatus(0);
				
				Order justSave = orderService.saveOrder(order);
				System.out.println(justSave.toString());
				
				
				
				for(Cart cart : lstCart) {
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setOrderdetailId(null);
					orderDetail.setOrder(justSave);
					Optional<Comic> comic = comicService.getAComicTypeOptional(cart.getComicId());
					orderDetail.setComic(comic.get());
					
					double price = cart.getPrice().doubleValue() * cart.getQuantity();
					BigDecimal nowPrice = new BigDecimal(price);
					orderDetail.setPurchasedPrice(nowPrice);
					orderDetail.setPurchasedQuantity(cart.getQuantity());
					orderDetailService.saveOrderDetail(orderDetail);
					System.out.println(orderDetailService.saveOrderDetail(orderDetail).toString());	
					
					// cập nhật số lượng
					Comic newComic = comic.get();
					newComic.setCurrentQuantity((comic.get().getCurrentQuantity() - cart.getQuantity()));
					comicService.updateComic(newComic);
				}
				cartService.clearAll();
				return "redirect:/home/shopping-cart";
			}
		}
		return "/templates/signin";
	}
}
