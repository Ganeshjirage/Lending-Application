package com.banking.app.service;

import java.util.List;

import com.banking.app.dto.TransactionDto;
import com.banking.app.payload.ApiResponse;

public interface TransactionService {

	public TransactionDto addTransaction(TransactionDto transactionDto);

	public TransactionDto getTransactionById(Long transactionId);

	public List<TransactionDto> getAllTransactions();

	public TransactionDto updateTransaction(TransactionDto transactionDto);

	public ApiResponse deleteTransaction(Long transactionId);
}
