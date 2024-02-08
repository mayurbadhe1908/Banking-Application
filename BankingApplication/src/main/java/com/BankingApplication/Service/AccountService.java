package com.BankingApplication.Service;

import java.util.List;

import com.BankingApplication.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposite(Long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(Long id);
	
	AccountDto withdraw(Long id, double amount);
} 
