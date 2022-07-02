package assignment.src.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import assignment.src.model.entity.OrderDetail;
import assignment.src.repository.IOrderDetailRepository;
import assignment.src.service.IOrderDetailService;

@Service
public class OrderDetailService implements IOrderDetailService{
	@Autowired
	private IOrderDetailRepository orderDetailRepository;
	
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		return orderDetailRepository.findAll();
	}

	@Override
	public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
		return orderDetail;
	}

	@Override
	public Page<OrderDetail> getBypage(int pageNumber, int maxRecord) {
		Pageable pageable = PageRequest.of(pageNumber,maxRecord);
		Page<OrderDetail> page = orderDetailRepository.findAll(pageable);
		return page;
	}

	@Override
	public List<OrderDetail> getAllOrderDetailByOrderId(Long id) {
		return orderDetailRepository.getAllOrderDetailByOrderId(id);
	}

}
