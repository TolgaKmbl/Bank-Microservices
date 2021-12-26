package com.tolgakmbl.transactionservice.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int accountId;
	private BigDecimal amount;	
	private TransactionType type;
	private LocalDateTime transactionTime;
	
	public Transaction(int accountId, BigDecimal amount, TransactionType type) {
		this(accountId, amount, type, LocalDateTime.now());
	}

	public Transaction(int accountId, BigDecimal amount, TransactionType type, LocalDateTime transactionTime) {
		this.accountId = accountId;		
		this.amount = amount;
		this.type = type;
		this.transactionTime = transactionTime;
	}

}
