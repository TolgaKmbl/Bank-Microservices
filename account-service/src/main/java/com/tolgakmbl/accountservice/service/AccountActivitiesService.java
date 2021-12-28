package com.tolgakmbl.accountservice.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.tolgakmbl.accountservice.dto.TransactionDto;
import com.tolgakmbl.accountservice.exception.TransactionFailedException;
import com.tolgakmbl.accountservice.proxy.TransactionServiceProxy;
import com.tolgakmbl.accountservice.repository.AccountRepository;
import lombok.Synchronized;

@Service
@Transactional(rollbackOn = { RuntimeException.class })
public class AccountActivitiesService {

	private final TransactionServiceProxy transactionServiceProxy;
	private final AccountRepository accountRepository;

	public AccountActivitiesService(TransactionServiceProxy transactionServiceProxy,
			AccountRepository accountRepository) {
		super();
		this.transactionServiceProxy = transactionServiceProxy;
		this.accountRepository = accountRepository;
	}

	@Synchronized
	public void deposit(int customerId, int accountId, BigDecimal amount) {
		if (isOwner(customerId, accountId)) {
			accountRepository.findById(accountId).get().deposit(amount);
			createTransaction(accountId, amount, "DEPOSIT");
		} else {
			throw new TransactionFailedException("Deposit failed");
		}
	}

	@Synchronized
	public void withdraw(int customerId, int accountId, BigDecimal amount) {
		if (isOwner(customerId, accountId)) {
			accountRepository.findById(accountId).get().withdraw(amount);
			createTransaction(accountId, amount, "WITHDRAW");

		} else {
			throw new TransactionFailedException("Withdraw failed");
		}
	}

	@Synchronized
	public void transfer(int customerId, int accountFrom, int accountTo, BigDecimal amount) {	
		if (isOwner(customerId, accountFrom) && isAccountExists(accountTo)) {
			accountRepository.findById(accountTo).get().deposit(amount);
			accountRepository.findById(accountFrom).get().withdraw(amount);
			createTransaction(accountTo, amount, "TRANSFER");
			createTransaction(accountFrom, amount.negate(), "TRANSFER");
		} else {
			throw new TransactionFailedException("Transfer failed");
		}
	}

	private boolean isOwner(int customerId, int accountId) {
		System.out.println("Is owner");
		return accountRepository.findById(accountId).get().getCustomerId() == customerId;
	}
	
	private boolean isAccountExists(int accountId) {
		return accountRepository.findById(accountId).get() != null;
	}
	
	private void createTransaction(int accountId, BigDecimal amount, String type) {
		transactionServiceProxy.createTransaction(TransactionDto.builder()
				.accountId(accountId)
				.amount(amount)
				.type(type)
				.build());
	}

}
