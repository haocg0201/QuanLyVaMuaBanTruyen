package assignment.src.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import assignment.src.model.entity.Account;
import assignment.src.model.entity.Order;
import assignment.src.repository.IOrderRepository;
import assignment.src.service.IOrderService;

@Service
public class OrderService implements IOrderService{
	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	public Order saveOrder(Order order) {
		order.setOrderId(null);
		orderRepository.save(order);
		return order;
	}

	@Override
	public Page<Order> getByPage(int pageNumber, int maxRecord) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<Order> page = orderRepository.findAll(pageable);
		return page;
	}

	@Override
	public Page<Order> findByOrderStatusContaining(Integer status, Pageable pageable) {
		Page<Order> page = orderRepository.findByStatusContaining(status, null);
		return page;
	}

	@Override
	public Order updateByOrderId(Long id, String status,Account account) {
		Order newValueOrder = new Order();
		int statusNow = Integer.parseInt(status);
		if(id != null) {
			Optional<Order> optionalOrder = orderRepository.findById(id);
			if(optionalOrder.isPresent()) {
				Order oldValueOrder = optionalOrder.get();
				newValueOrder.setOrderId(id);
				newValueOrder.setAmount(oldValueOrder.getAmount());
				newValueOrder.setBuyerPhone(oldValueOrder.getBuyerPhone());
				newValueOrder.setCreatedDate(oldValueOrder.getCreatedDate());
				newValueOrder.setStatus(statusNow);
				newValueOrder.setAccount(account);
				orderRepository.save(newValueOrder);
				return newValueOrder;
			}
		}
		return null;
	}

	@Override
	public List<Order> findByAccountId(Long accountId) {
		return orderRepository.findByAccountId(accountId);
	}
	
}
