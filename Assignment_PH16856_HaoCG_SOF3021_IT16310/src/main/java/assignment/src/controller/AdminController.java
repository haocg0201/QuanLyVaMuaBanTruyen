package assignment.src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
	@GetMapping("/admin/index")
	public String index() {
		return "/templates/admin/index";
	}
	
	@GetMapping("admin/integrated-statistics")
	public String integratedStatistics() {
		return "/templates/admin/integrated-statistics";
	}
	
	@GetMapping("admin/order-orderdetail")
	public String orderOrderDetail() {
		return "/templates/admin/order-orderdetail";
	}
	
	@GetMapping("admin/widget")
	public String widget() {
		return "/templates/admin/widget";
	}
}
