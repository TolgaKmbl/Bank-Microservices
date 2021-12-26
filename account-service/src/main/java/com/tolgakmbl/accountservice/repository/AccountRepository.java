package com.tolgakmbl.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.accountservice.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	List<Account> findAccountsByCustomerId(int customerId);	

}
