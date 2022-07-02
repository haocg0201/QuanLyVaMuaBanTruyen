package assignment.src.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment.src.model.entity.Account;
import assignment.src.repository.IAccountRepository;
import assignment.src.service.IAccountService;
import assignment.src.utility.EncryptUtil;
import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class AccountService implements IAccountService{
	@Autowired 
	private IAccountRepository accountRepository;
	
	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	
	@Override
	public Optional<Account> findByAccountId(Long id) {		
		return accountRepository.findById(id);
	}

	@Override
	public Account insertAAccount(Account account) {			
		String encrypted = EncryptUtil.encrypt(account.getPassword());
		account.setAccountId(null);	
		account.setPassword(encrypted);
		return accountRepository.save(account);
	}	
	
	@Override
	public Account deleteAAccountById(Long id) {
		if(id != null) {
			Optional<Account> optionalAccount = accountRepository.findById(id);
			if(optionalAccount.isPresent()) {
				accountRepository.deleteById(id);
				return optionalAccount.get();
			}
		}
		return null;
	}
	
	@Override
	public Account updateRoleById(boolean role,Long id) {
		Account newValueAccount = new Account();
		if(id != null) {
			Optional<Account> optionalAccount = accountRepository.findById(id);
			if(optionalAccount.isPresent()) {
//				BeanUtils.copyProperties(optionalAccount, newValueAccount);
				
//				Không copy bean được nên phải set chay ((
				Account oldAccount = optionalAccount.get();
				newValueAccount.setAccountId(id);
				newValueAccount.setUsername(oldAccount.getUsername());
				newValueAccount.setPassword(oldAccount.getPassword());
				newValueAccount.setCreatedDate(oldAccount.getCreatedDate());
				if(role) {
					newValueAccount.setRole(false);
				}else {
					newValueAccount.setRole(true);
				}	
				
				System.out.println(newValueAccount.toString());
				accountRepository.save(newValueAccount);
				System.out.println(newValueAccount.toString());
				return newValueAccount;
			}
		}
		return null;
	}
	
	@Override
	public boolean checkEncryptPasswprd(Long id,String password) {
		return false;
	}

	@Override
	public Account getLogin(String username) {
		return accountRepository.getAccountByUsername(username);
	}
	
	@Override
	public Account findByUsername(String username){
		return accountRepository.findByUsername(username);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}
}
