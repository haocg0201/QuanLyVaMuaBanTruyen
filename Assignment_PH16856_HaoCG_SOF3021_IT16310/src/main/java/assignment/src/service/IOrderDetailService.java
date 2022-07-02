package assignment.src.service;

import java.util.List;

import org.springframework.data.domain.Page;

import assignment.src.model.entity.OrderDetail;

public interface IOrderDetailService {
	Page<OrderDetail> getBypage(int pageNumber,int maxRecord);
	
	List<OrderDetail> getAllOrderDetail();
	
	OrderDetail saveOrderDetail(OrderDetail orderDetail);
	
	List<OrderDetail> getAllOrderDetailByOrderId(Long id);
	
}
