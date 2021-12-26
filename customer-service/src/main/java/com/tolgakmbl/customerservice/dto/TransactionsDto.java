package com.tolgakmbl.customerservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
public class TransactionsDto {
	
	private int id;
	private int accountId;
	private BigDecimal amount;	
	private String type;
	private LocalDateTime transactionTime;
	
}
