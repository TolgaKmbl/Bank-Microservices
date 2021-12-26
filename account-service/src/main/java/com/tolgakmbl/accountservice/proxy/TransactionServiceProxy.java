package com.tolgakmbl.accountservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tolgakmbl.accountservice.dto.TransactionDto;


@FeignClient(name="transaction-service", url="localhost:8888")
public interface TransactionServiceProxy {
	
	@GetMapping("/transaction")
	public List<TransactionDto> getAllTransactions();
	
	@GetMapping("/transaction/{id}")
	public TransactionDto getTransactionById(@PathVariable("id") int id);
	
	@PostMapping("/transaction/create")
	public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto);
	
	@GetMapping("/transaction/account/{customerId}")
	public List<TransactionDto> getTransactionByCustomerId(@PathVariable("customerId") int customerId);

}
