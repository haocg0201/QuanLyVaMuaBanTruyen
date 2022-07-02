package assignment.src.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.src.common.CommonConst;
import assignment.src.model.entity.Account;
import assignment.src.model.entity.Comic;
import assignment.src.model.entity.Order;
import assignment.src.model.entity.OrderDetail;
import assignment.src.model.entity.type.ComicType;
import assignment.src.service.impl.ComicService;
import assignment.src.service.impl.OrderDetailService;
import assignment.src.service.impl.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ComicService comicService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/home/shop")
	public String shop(Model model,
			@RequestParam(name="type",required=false)ComicType type) {
		ComicType[] arrType = ComicType.values();
		model.addAttribute("arrType",arrType);
		List<Comic> lstComic = null;
		if(type!= null) {
			lstComic = comicService.findByType(type);
			model.addAttribute("lstComic",lstComic);
			return "templates/site/shop";
		}else {
			lstComic = comicService.findAll();
			model.addAttribute("lstComic",lstComic);
			return "templates/site/shop";
		}
	}
	
	@GetMapping("/home/shop-single/{id}")
	public String shopSingle(
			@PathVariable("id") Long id,
			Model model
			) {
		Optional<Comic> optionalComic = comicService.getAComicByComicId(id);
		model.addAttribute("comic",optionalComic.get());
		return "templates/site/shop-single";		
	}
	
	@GetMapping("/admin/order")
	public String getAllOrder(
			ModelMap model,
			@RequestParam(name="pageNumber",defaultValue = "0",required=false)int pageNmber,
		    @RequestParam(name="status",required=false)String status
			) {
		Page<Order> orderPage = null;
		if(status != null) {
			Pageable pageable = PageRequest.of(pageNmber,CommonConst.PAGE_SIZE);
			orderPage =  orderService.findByOrderStatusContaining(Integer.parseInt(status),pageable);
			model.addAttribute("page",orderPage);
		}else {
			orderPage =  orderService.getByPage(pageNmber, CommonConst.PAGE_SIZE);
			model.addAttribute("page",orderPage);
		}
		return "/templates/admin/order";
	}
	
	@GetMapping("/admin/order/edit/{id}/{status}")
	public String updateStatus(
			@PathVariable("id")Long id,
			@PathVariable("status")String status
			) {
		Account account = (Account) session.getAttribute("account");
		if(status.equalsIgnoreCase("2")) {
			orderService.updateByOrderId(id, status,account);
			System.out.println(orderService.updateByOrderId(id, status,account).toString());
			
			//trả lại số lượng cho comic
			List<OrderDetail> lstOrderDrtail = orderDetailService.getAllOrderDetailByOrderId(id);
			System.out.println(lstOrderDrtail.toString());
			Optional<Comic> comic = null;
			Comic newComic = null;
			for(OrderDetail orderDetail : lstOrderDrtail) {
				comic = comicService.getAComicTypeOptional(orderDetail.getComic().getComicId());
				newComic = comic.get();
				newComic.setCurrentQuantity(newComic.getCurrentQuantity() + orderDetail.getPurchasedQuantity());
				comicService.updateComic(newComic);
				System.out.println(newComic.toString());
			}	
			return "redirect:/admin/order";
		}else {
			orderService.updateByOrderId(id, status,account);
			System.out.println(orderService.updateByOrderId(id, status,account).toString());
			return "redirect:/admin/order";
		}
	}
	
	@GetMapping("/home/account-order")
	public String accountOrder(ModelMap model) {
		Account account = (Account)session.getAttribute("account");
		if(account != null) {
			model.addAttribute("lstOrder",orderService.findByAccountId(account.getAccountId()));
			return "/templates/site/account-order";
		}
		return "/templates/site/account-order";
	}
	
	@GetMapping("/home/account-order/edit/{orderId}/{status}")
	public String cancelOrder(
			@PathVariable("orderId")Long orderId,
			@PathVariable("status")String status
			) {
		Account account = (Account) session.getAttribute("account");
		orderService.updateByOrderId(orderId, status,account);
		System.out.println(orderService.updateByOrderId(orderId, status,account).toString());
		
		//trả lại số lượng cho comic
		List<OrderDetail> lstOrderDrtail = orderDetailService.getAllOrderDetailByOrderId(orderId);
		System.out.println(lstOrderDrtail.toString());
		Optional<Comic> comic = null;
		Comic newComic = null;
		for(OrderDetail orderDetail : lstOrderDrtail) {
			comic = comicService.getAComicTypeOptional(orderDetail.getComic().getComicId());
			newComic = comic.get();
			newComic.setCurrentQuantity(newComic.getCurrentQuantity() + orderDetail.getPurchasedQuantity());
			comicService.updateComic(newComic);
			System.out.println(newComic.toString());
		}	
		return "redirect:/home/account-order";
	}
}
