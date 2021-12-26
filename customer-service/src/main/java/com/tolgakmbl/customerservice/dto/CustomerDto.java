package com.tolgakmbl.customerservice.dto;


import lombok.*;

@Data
@Builder
public class CustomerDto {

	private int id;
	private String name;
	private String surname;
	
}
