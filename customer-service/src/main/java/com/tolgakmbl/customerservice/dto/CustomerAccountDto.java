package com.tolgakmbl.customerservice.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerAccountDto {

	private int id;
	private String name;
	private String surname;
	private List<AccountDto> accounts;
	
}
