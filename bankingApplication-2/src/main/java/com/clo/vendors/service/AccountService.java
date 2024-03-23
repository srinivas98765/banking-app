package com.clo.vendors.service;

import java.util.List;

import com.clo.vendors.dto.AccountDto;
import com.clo.vendors.entity.Account;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
    
	AccountDto getAccountByid(Long id);
	
	AccountDto deposit(Long id,double amount);
	
	AccountDto withdraw(Long id,double amount);
	
	void deleteAccount(Long id);
	
	List<AccountDto> getAllAccounts();
}
