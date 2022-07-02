package assignment.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.src.common.CommonConst;
import assignment.src.model.entity.OrderDetail;
import assignment.src.service.impl.OrderDetailService;

@Controller
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping("/admin/order-detail")
	public String getAllOrderDetail(ModelMap model,
			@RequestParam(name="pageNumber",defaultValue = "0",required=false)int pageNmber) {
		Page<OrderDetail> orderDetailPage = orderDetailService.getBypage(pageNmber, CommonConst.PAGE_SIZE);
		model.addAttribute("page",orderDetailPage);
		return "/templates/admin/order-detail";
	}
}
