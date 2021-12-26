package com.tolgakmbl.customerservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tolgakmbl.customerservice.dto.AccountDto;
import com.tolgakmbl.customerservice.dto.AccountTransactionDto;


@FeignClient(name="account-service", url="localhost:8080")
public interface AccountServiceProxy {
	
	@GetMapping("/account")
	public List<AccountDto> getAllAccounts();
	
	@GetMapping("/account/{id}")
	public AccountDto getAccountById(@PathVariable("id") int id);
	
	@GetMapping("/account/customer/{customerId}")
	public List<AccountDto> getAccountsByCustomerId(@PathVariable("customerId") int customerId);
	
	@GetMapping("/account/accountTx/{accountId}")
	public AccountTransactionDto getAccountWithTransactions(@PathVariable("accountId") int accountId);

}
