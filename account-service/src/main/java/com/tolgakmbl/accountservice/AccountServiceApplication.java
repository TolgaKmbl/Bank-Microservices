package com.tolgakmbl.accountservice;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.tolgakmbl.accountservice.model.Account;
import com.tolgakmbl.accountservice.repository.AccountRepository;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication implements CommandLineRunner{
	
	private final AccountRepository accountRepository;

	public AccountServiceApplication(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account(1, 1, BigDecimal.valueOf(1000)));
		accountRepository.save(new Account(2, 1, BigDecimal.valueOf(3000)));
		accountRepository.save(new Account(3, 2, BigDecimal.valueOf(4000)));
		accountRepository.save(new Account(4, 2, BigDecimal.valueOf(1500)));
		accountRepository.save(new Account(5, 3, BigDecimal.valueOf(1700)));
		accountRepository.save(new Account(6, 3, BigDecimal.valueOf(750)));
		
		
	}

}
