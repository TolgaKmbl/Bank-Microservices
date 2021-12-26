package com.tolgakmbl.transactionservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.transactionservice.dto.TransactionDto;
import com.tolgakmbl.transactionservice.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
	
	@GetMapping()
	public ResponseEntity<List<TransactionDto>> getAllTransactions() {
		return ResponseEntity.ok(transactionService.getAllTransactions());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TransactionDto> getTransactionById(@PathVariable("id") int id) {
		return ResponseEntity.ok(transactionService.getTransactionById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
		return new ResponseEntity<TransactionDto>(transactionService.createTransaction(transactionDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/account/{accountId}")
	public ResponseEntity<List<TransactionDto>> getTransactionsByAccountId(@PathVariable("accountId") int accountId) {
		return ResponseEntity.ok(transactionService.getTransactionsByAccountId(accountId));
	}

}
