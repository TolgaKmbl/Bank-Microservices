package com.tolgakmbl.transactionservice.dto;

import org.springframework.stereotype.Component;

import com.tolgakmbl.transactionservice.model.Transaction;

@Component
public class TransactionDtoConverter {

	public TransactionDto convert(Transaction from) {
		return TransactionDto.builder()
				.id(from.getId())
				.accountId(from.getAccountId())
				.amount(from.getAmount())
				.type(from.getType().name())
				.transactionTime(from.getTransactionTime())
				.build();
	}
	
}
