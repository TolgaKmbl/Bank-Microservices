package com.tolgakmbl.accountservice.dto;

import java.math.BigDecimal;

import lombok.*;

@Data
@Builder
public class AccountDto {

	private int id;
	private int customerId;
	private BigDecimal balance;
	
}
