package assignment.src.repository; 


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import assignment.src.model.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Long>{
	@Query(value = "SELECT *FROM Account a WHERE a.username LIKE :name", nativeQuery = true)
	Account getAccountByUsername(@Param("name")String username);
	@Query(value = "SELECT *FROM account WHERE username LIKE :username", nativeQuery = true)
	Account findByUsername(@Param("username")String username);
}
