package com.tolgakmbl.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.customerservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
