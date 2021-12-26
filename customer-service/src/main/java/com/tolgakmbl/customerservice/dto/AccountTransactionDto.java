package com.tolgakmbl.customerservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;

@Data
@Builder
public class AccountTransactionDto {
	
	private int accountId;
	private int customerId;
	private BigDecimal balance;
	private List<TransactionsDto> transactions;

}
