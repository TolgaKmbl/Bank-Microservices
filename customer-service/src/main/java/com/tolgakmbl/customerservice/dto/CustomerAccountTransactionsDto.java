package com.tolgakmbl.customerservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;

@Data
@Builder
public class CustomerAccountTransactionsDto {

	private int id;
	private String name;
	private String surname;
	private int accountId;
	private BigDecimal balance;
	private List<TransactionsDto> transactions;
}
