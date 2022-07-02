package assignment.src.model.entity.key;

import java.io.Serializable;

import assignment.src.model.entity.Account;

public class AccountId implements Serializable{
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
