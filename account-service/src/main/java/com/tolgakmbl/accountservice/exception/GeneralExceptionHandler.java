package com.tolgakmbl.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> accountNotFoundExceptionHandler(AccountNotFoundException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(TransactionFailedException.class)
    public ResponseEntity<?> transactionFailedExceptionHandler(TransactionFailedException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
	
}
