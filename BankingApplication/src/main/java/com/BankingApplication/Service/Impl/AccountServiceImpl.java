package com.BankingApplication.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingApplication.Entity.Account;
import com.BankingApplication.Repository.AccountRepository;
import com.BankingApplication.Service.AccountService;
import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		
		Account savedAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		return AccountMapper.mapToAccountDto(account);
		
	}

	@Override
	public AccountDto deposite(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		double totalAmount = account.getBalance()+amount;
		account.setBalance(totalAmount);
		Account savedAccount = accountRepository.save(account);
		
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		double totalAmount = account.getBalance()-amount;
		account.setBalance(totalAmount);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	

	@Override
	public List<AccountDto> getAllAccounts() {
		return accountRepository.findAll().stream().map((account)->AccountMapper.mapToAccountDto
				(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		
		Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		accountRepository.delete(account);
		
	}

	
	
	
}
