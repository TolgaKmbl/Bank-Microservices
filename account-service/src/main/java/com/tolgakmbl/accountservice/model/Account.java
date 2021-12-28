package com.tolgakmbl.accountservice.model;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int customerId;
	private BigDecimal balance;

	public void deposit(BigDecimal amount) {
		BigDecimal oldBalance = this.balance;
		this.setBalance(oldBalance.add(amount));
	}

	public void withdraw(BigDecimal amount) {
		BigDecimal oldBalance = this.balance;
		if(oldBalance.compareTo(amount) > 0) {
			this.setBalance(oldBalance.subtract(amount));
		}
	}
}
