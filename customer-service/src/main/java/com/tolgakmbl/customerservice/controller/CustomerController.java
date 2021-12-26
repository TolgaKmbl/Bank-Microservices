package com.tolgakmbl.customerservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.customerservice.dto.CustomerAccountDto;
import com.tolgakmbl.customerservice.dto.CustomerAccountTransactionsDto;
import com.tolgakmbl.customerservice.dto.CustomerDto;
import com.tolgakmbl.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") int id) {
		return ResponseEntity.ok(customerService.findCustomerById(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<CustomerDto>> getCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto customer){
		return ResponseEntity.ok(customerService.register(customer));
	}
	
	 @GetMapping("/customerWithAccount/{id}")
	 public ResponseEntity<CustomerAccountDto> getCustomerWithAccount(@PathVariable("id") int id){
		 return ResponseEntity.ok(customerService.getCustomerWithAccount(id));
	 }
	 
	 @GetMapping("/customerWithAccountTransactions/{customerId}/{accountId}")
	 public ResponseEntity<CustomerAccountTransactionsDto> getCustomerWithAccountAndTransactions(
			 @PathVariable("customerId") int customerId, 
			 @PathVariable("accountId") int accountId
			 ){
		 
		 return ResponseEntity.ok(customerService.getCustomerWithAccountTransactions(customerId, accountId));
	 }

}
