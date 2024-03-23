package com.clo.vendors.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.clo.vendors.dto.AccountDto;
import com.clo.vendors.entity.Account;
import com.clo.vendors.mapper.AccountMapper;
import com.clo.vendors.repository.AccountRepository;
import com.clo.vendors.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto)
	{
		Account account= AccountMapper.mapToAccount(accountDto);
		Account savedaccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedaccount);
	}
	
	@Override
	public AccountDto getAccountByid(Long id)
	{
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exists"));
	    return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Amount does not exists"));
		double total = account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public void deleteAccount(Long id) {
		
    Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exists"));		
	accountRepository.deleteById(id);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts=accountRepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Amount does not exists"));
		double total = account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
		
	}

}
