package com.tolgakmbl.transactionservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tolgakmbl.transactionservice.dto.TransactionDto;
import com.tolgakmbl.transactionservice.dto.TransactionDtoConverter;
import com.tolgakmbl.transactionservice.exception.TransactionNotFoundException;
import com.tolgakmbl.transactionservice.model.Transaction;
import com.tolgakmbl.transactionservice.model.TransactionType;
import com.tolgakmbl.transactionservice.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private final TransactionRepository transactionRepository;
	private final TransactionDtoConverter transactionDtoConverter;
	
	public TransactionService(TransactionRepository transactionRepository,
			TransactionDtoConverter transactionDtoConverter) {
		super();
		this.transactionRepository = transactionRepository;
		this.transactionDtoConverter = transactionDtoConverter;
	}
	
	public List<TransactionDto> getAllTransactions() {
		return transactionRepository.findAll()
				.stream()
				.map(transactionDtoConverter::convert)
				.collect(Collectors.toList());
	}
	
	public TransactionDto getTransactionById(int id) {
		return transactionRepository.findById(id)
				.map(transactionDtoConverter::convert)
				.orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
	}
	
	public TransactionDto createTransaction(TransactionDto transactionDto) {
		return transactionDtoConverter.convert(transactionRepository.save(
				Transaction.builder()
				.id(transactionDto.getId())
				.accountId(transactionDto.getAccountId())
				.amount(transactionDto.getAmount())				
				.transactionTime(LocalDateTime.now())
				.type(TransactionType.valueOf(transactionDto.getType()))
				.build()));
	}
	
	public List<TransactionDto> getTransactionsByAccountId(int accountId) {
		return transactionRepository.findTransactionsByAccountId(accountId)
				.stream()
				.map(transactionDtoConverter::convert)
				.collect(Collectors.toList());
				
	}

}
