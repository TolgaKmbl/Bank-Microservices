package com.tolgakmbl.customerservice.dto;

import org.springframework.stereotype.Component;

import com.tolgakmbl.customerservice.model.Customer;

@Component
public class CustomerDtoConverter {

	public CustomerDto convert(Customer from) {
		return CustomerDto.builder()
				.id(from.getId())
				.name(from.getName())
				.surname(from.getSurname())
				.build();
	}
}
