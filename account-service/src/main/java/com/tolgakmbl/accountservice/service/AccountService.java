package com.tolgakmbl.accountservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tolgakmbl.accountservice.dto.AccountDto;
import com.tolgakmbl.accountservice.dto.AccountDtoConverter;
import com.tolgakmbl.accountservice.dto.AccountTransactionDto;
import com.tolgakmbl.accountservice.dto.TransactionDto;
import com.tolgakmbl.accountservice.exception.AccountNotFoundException;
import com.tolgakmbl.accountservice.model.Account;
import com.tolgakmbl.accountservice.proxy.TransactionServiceProxy;
import com.tolgakmbl.accountservice.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final AccountDtoConverter accountDtoConverter;
	private final TransactionServiceProxy transactionServiceProxy;

	public AccountService(AccountRepository accountRepository, AccountDtoConverter accountDtoConverter,
			TransactionServiceProxy transactionServiceProxy) {
		super();
		this.accountRepository = accountRepository;
		this.accountDtoConverter = accountDtoConverter;
		this.transactionServiceProxy = transactionServiceProxy;
	}

	public List<AccountDto> getAllAccounts() {
		return accountRepository.findAll()
				.stream()
				.map(accountDtoConverter::convert)
				.collect(Collectors.toList());
	}

	public AccountDto getAccountById(int id) {
		return accountRepository.findById(id)
				.map(accountDtoConverter::convert)
				.orElseThrow(() -> new AccountNotFoundException("Account not found"));
	}

	public List<AccountDto> getAccountsByCustomerId(int customerId) {
		return accountRepository.findAccountsByCustomerId(customerId)
				.stream()
				.map(accountDtoConverter::convert)
				.collect(Collectors.toList());
	}
	
	public AccountDto createAccount(AccountDto accountDto) {
		return accountDtoConverter.convert(
				accountRepository.save(Account.builder()
				.id(accountDto.getId())
				.customerId(accountDto.getCustomerId())
				.balance(accountDto.getBalance())
				.build()));
	}
 
	public AccountTransactionDto getAccountWithTransactions(int accountId) {
		List<TransactionDto> transactions = transactionServiceProxy.getTransactionsByAccountId(accountId);
		AccountDto account = this.getAccountById(accountId);
		return AccountTransactionDto.builder()
				.accountId(account.getId())
				.customerId(account.getCustomerId())
				.balance(account.getBalance())
				.transactions(transactions)
				.build();
	}
}
