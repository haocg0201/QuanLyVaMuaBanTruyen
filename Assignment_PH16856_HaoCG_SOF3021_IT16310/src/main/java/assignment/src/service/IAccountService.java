package assignment.src.service;

import java.util.List;
import java.util.Optional;

import assignment.src.model.entity.Account;

public interface IAccountService {
	
	boolean checkEncryptPasswprd(Long id, String password);
	
	Account updateRoleById(boolean role,Long id);
	
	Account deleteAAccountById(Long id);
	
	Account insertAAccount(Account account);
	
	Optional<Account> findByAccountId(Long id);
	
	List<Account> getAllAccount();
	
	Account getLogin(String username);
	
	Account findByUsername(String username);
	
	Account updateAccount(Account account);
}
