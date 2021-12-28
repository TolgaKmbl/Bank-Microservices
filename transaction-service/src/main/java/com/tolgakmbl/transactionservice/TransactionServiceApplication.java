package com.tolgakmbl.transactionservice;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tolgakmbl.transactionservice.model.Transaction;
import com.tolgakmbl.transactionservice.model.TransactionType;
import com.tolgakmbl.transactionservice.repository.TransactionRepository;

@SpringBootApplication
public class TransactionServiceApplication implements CommandLineRunner{

	private final TransactionRepository transactionRepository;
	
	
	public TransactionServiceApplication(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		transactionRepository.save(new Transaction(1,BigDecimal.valueOf(376.5), TransactionType.DEPOSIT));
		transactionRepository.save(new Transaction(1,BigDecimal.valueOf(65), TransactionType.TRANSFER));
		transactionRepository.save(new Transaction(2,BigDecimal.valueOf(416.8), TransactionType.WITHDRAW));
		transactionRepository.save(new Transaction(2,BigDecimal.valueOf(233.45), TransactionType.DEPOSIT));
		transactionRepository.save(new Transaction(3,BigDecimal.valueOf(299.0), TransactionType.DEPOSIT));
		transactionRepository.save(new Transaction(3,BigDecimal.valueOf(75.89), TransactionType.WITHDRAW));
		transactionRepository.save(new Transaction(4,BigDecimal.valueOf(156.98), TransactionType.WITHDRAW));
		transactionRepository.save(new Transaction(4,BigDecimal.valueOf(103.42), TransactionType.DEPOSIT));
		transactionRepository.save(new Transaction(5,BigDecimal.valueOf(100.7), TransactionType.DEPOSIT));
		transactionRepository.save(new Transaction(5,BigDecimal.valueOf(66.5), TransactionType.WITHDRAW));
		transactionRepository.save(new Transaction(6,BigDecimal.valueOf(99.9), TransactionType.TRANSFER));
		transactionRepository.save(new Transaction(6,BigDecimal.valueOf(123.67), TransactionType.DEPOSIT));
		
	}

}
