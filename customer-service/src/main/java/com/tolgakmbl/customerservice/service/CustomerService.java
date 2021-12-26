package com.tolgakmbl.customerservice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tolgakmbl.customerservice.dto.AccountDto;
import com.tolgakmbl.customerservice.dto.AccountTransactionDto;
import com.tolgakmbl.customerservice.dto.CustomerAccountDto;
import com.tolgakmbl.customerservice.dto.CustomerAccountTransactionsDto;
import com.tolgakmbl.customerservice.dto.CustomerDto;
import com.tolgakmbl.customerservice.dto.CustomerDtoConverter;
import com.tolgakmbl.customerservice.exception.CustomerNotFoundException;
import com.tolgakmbl.customerservice.model.Customer;
import com.tolgakmbl.customerservice.proxy.AccountServiceProxy;
import com.tolgakmbl.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerDtoConverter customerDtoConverter;
	private final CustomerRepository customerRepository;
	private final AccountServiceProxy accountServiceProxy;

	public CustomerService(CustomerDtoConverter customerDtoConverter, 
			CustomerRepository customerRepository,
			AccountServiceProxy accountServiceProxy) {
		super();
		this.customerDtoConverter = customerDtoConverter;
		this.customerRepository = customerRepository;
		this.accountServiceProxy = accountServiceProxy;
	}
	
	public List<CustomerDto> getAllCustomers() {
		return customerRepository.findAll()
				.stream()
				.map(customerDtoConverter::convert)
				.collect(Collectors.toList());
	}
	
	public CustomerDto findCustomerById(int id) {
		return customerRepository.findById(id)
				.map(customerDtoConverter::convert)
				.orElseThrow(
						() -> new CustomerNotFoundException("Customer not found"))
				;
	}

	public CustomerDto register(CustomerDto customerDto) {
		//TODO: Check for existence
		return customerDtoConverter.convert(
			customerRepository.save(Customer.builder()
			.id(customerDto.getId())
			.name(customerDto.getName())
			.surname(customerDto.getSurname())
			.build()));
	}
	
	public CustomerAccountDto getCustomerWithAccount(int id) {
		CustomerDto customer = findCustomerById(id);
		List<AccountDto> accounts = accountServiceProxy.getAccountsByCustomerId(id);
		return CustomerAccountDto.builder()
				.id(customer.getId())
				.name(customer.getName())
				.surname(customer.getSurname())
				.accounts(accounts)
				.build();
	}
	
	public CustomerAccountTransactionsDto getCustomerWithAccountTransactions(int customerId, int accountId) {
		CustomerDto customer = findCustomerById(customerId);
		
		if(accountServiceProxy.getAccountById(accountId).getCustomerId() == customerId) {
			AccountTransactionDto accountTransactions = accountServiceProxy.getAccountWithTransactions(customerId);
			
			return CustomerAccountTransactionsDto.builder()
					.id(customerId)
					.name(customer.getName())
					.surname(customer.getSurname())
					.accountId(accountId)	
					.balance(accountTransactions.getBalance())
					.transactions(accountTransactions.getTransactions())						
					.build();
			
		} else {
			throw new CustomerNotFoundException("The account not found");
		}		
		
		
	} 

}
