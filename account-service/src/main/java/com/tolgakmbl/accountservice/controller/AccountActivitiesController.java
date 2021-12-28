package com.tolgakmbl.accountservice.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.accountservice.service.AccountActivitiesService;

@RestController
@RequestMapping("/accountActivities")
public class AccountActivitiesController {
	
	private final AccountActivitiesService accountActivitiesService;

	public AccountActivitiesController(AccountActivitiesService accountActivitiesService) {
		super();
		this.accountActivitiesService = accountActivitiesService;
	}

	@GetMapping("/deposit/customerId/{customerId}/accountId/{accountId}/{amount}")
	public ResponseEntity<String> deposit(@PathVariable("customerId") int customerId, 
			@PathVariable("accountId") int accountId, 
			@PathVariable("amount") BigDecimal amount) {
		accountActivitiesService.deposit(customerId, accountId, amount);
		return ResponseEntity.ok("Your deposit application has been received and is being processed");

	}
	
	@GetMapping("/withdraw/customerId/{customerId}/accountId/{accountId}/{amount}")
	public ResponseEntity<String> withdraw(@PathVariable("customerId") int customerId, 
			@PathVariable("accountId") int accountId, 
			@PathVariable("amount") BigDecimal amount) {
		accountActivitiesService.withdraw(customerId, accountId, amount);
		return ResponseEntity.ok("Your withdraw application has been received and is being processed");
	}
	
	@GetMapping("/transfer/customerId/{customerId}/accountFrom/{accountFrom}/accountTo/{accountTo}/{amount}")
	public ResponseEntity<String> transfer(@PathVariable("customerId") int customerId, 
			@PathVariable("accountFrom") int accountFrom,
			@PathVariable("accountTo") int accountTo, 
			@PathVariable("amount") BigDecimal amount) {
		accountActivitiesService.transfer(customerId, accountFrom, accountTo, amount);
		return ResponseEntity.ok("Your transfer application has been received and is being processed");
	}
}
