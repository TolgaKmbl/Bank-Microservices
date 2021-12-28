package com.tolgakmbl.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TransactionFailedException extends RuntimeException{

	public TransactionFailedException(String message) {
		super(message);
	}
	
}
