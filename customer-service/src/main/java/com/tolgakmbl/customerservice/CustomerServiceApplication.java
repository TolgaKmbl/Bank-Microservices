package com.tolgakmbl.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.tolgakmbl.customerservice.model.Customer;
import com.tolgakmbl.customerservice.repository.CustomerRepository;

@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApplication implements CommandLineRunner{
	
	private final CustomerRepository customerRepository;

	public CustomerServiceApplication(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer(1, "Tolga", "Kumbul"));
		customerRepository.save(new Customer(2, "Ceren", "Coskun"));
		customerRepository.save(new Customer(3, "Oyku", "Kumbul"));
	}

}
