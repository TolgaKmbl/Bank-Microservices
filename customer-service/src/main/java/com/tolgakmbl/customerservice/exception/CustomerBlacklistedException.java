package com.tolgakmbl.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerBlacklistedException extends RuntimeException{

	public CustomerBlacklistedException(String message) {
        super(message);
    }
}
