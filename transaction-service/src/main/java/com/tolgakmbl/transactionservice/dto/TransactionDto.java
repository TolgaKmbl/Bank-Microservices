package com.tolgakmbl.transactionservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
public class TransactionDto {

	private int id;
	private int accountId;
	private BigDecimal amount;	
	private String type;
	private LocalDateTime transactionTime;
}
