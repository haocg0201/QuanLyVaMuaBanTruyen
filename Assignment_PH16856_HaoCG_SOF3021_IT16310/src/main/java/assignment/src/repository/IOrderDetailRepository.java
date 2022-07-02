package assignment.src.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import assignment.src.model.entity.OrderDetail;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	@Query(value= "SELECT *FROM order_detail WHERE order_id = :id",nativeQuery = true)
	List<OrderDetail> getAllOrderDetailByOrderId(@Param("id") Long id);
}
