package assignment.src.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import assignment.src.model.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Long>{
	Page<Order> findByStatusContaining(Integer status,Pageable pageable);
	@Query(value="SELECT *FROM [order] WHERE account_id = :accountId",nativeQuery = true)
	List<Order> findByAccountId(@Param("accountId")Long accountId);
}
