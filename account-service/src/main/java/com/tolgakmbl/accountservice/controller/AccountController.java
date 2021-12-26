package com.tolgakmbl.accountservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.accountservice.dto.AccountDto;
import com.tolgakmbl.accountservice.dto.AccountTransactionDto;
import com.tolgakmbl.accountservice.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping()
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") int id){
		return ResponseEntity.ok(accountService.getAccountById(id));
	}
	
	//TODO: Query Param instead of Path variable
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<AccountDto>> getAccountsByCustomerId(@PathVariable("customerId") int customerId){
		return ResponseEntity.ok(accountService.getAccountsByCustomerId(customerId));
	}

	@PostMapping("/create")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/accountTx/{accountId}")
	public ResponseEntity<AccountTransactionDto> getAccountWithTransactions(@PathVariable("accountId") int accountId){
		return ResponseEntity.ok(accountService.getAccountWithTransactions(accountId));
	}
}
