package com.tolgakmbl.transactionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.transactionservice.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	List<Transaction> findTransactionsByAccountId(int accountId);
	
}
