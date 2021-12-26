package com.tolgakmbl.accountservice.dto;

import org.springframework.stereotype.Component;

import com.tolgakmbl.accountservice.model.Account;


@Component
public class AccountDtoConverter {

	public AccountDto convert(Account from) {
		return AccountDto.builder()
				.id(from.getId())
				.customerId(from.getCustomerId())
				.balance(from.getBalance())
				.build();
	}
}
