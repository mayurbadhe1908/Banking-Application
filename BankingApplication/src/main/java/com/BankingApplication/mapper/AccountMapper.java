package com.BankingApplication.mapper;

import com.BankingApplication.Entity.Account;
import com.BankingApplication.dto.AccountDto;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {
		
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance()		
				);
		
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		
		AccountDto acccountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		return acccountDto;
	}
	
}
