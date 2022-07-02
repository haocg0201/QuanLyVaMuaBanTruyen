package assignment.src.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import assignment.src.model.entity.Account;
import assignment.src.model.entity.Order;

public interface IOrderService {
	List<Order> getAllOrder();
	
	Order saveOrder(Order order);
	
	Page<Order> getByPage(int pageNumber, int maxRecord);
	
	Page<Order> findByOrderStatusContaining(Integer status,Pageable pageable);
	
	Order updateByOrderId(Long id,String status,Account account);
	
	List<Order> findByAccountId(Long accountId);
}
