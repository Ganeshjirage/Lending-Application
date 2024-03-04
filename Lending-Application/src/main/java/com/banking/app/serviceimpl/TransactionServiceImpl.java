package com.banking.app.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.dto.TransactionDto;
import com.banking.app.entity_model.Transaction;
import com.banking.app.payload.ApiResponse;
import com.banking.app.repository.AccountRepository;
import com.banking.app.repository.TransactionRepository;
import com.banking.app.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TransactionDto addTransaction(TransactionDto transactionDto) {
		Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
		transactionRepository.save(transaction);
		return modelMapper.map(transaction, TransactionDto.class);
	}

	@Override
	public TransactionDto getTransactionById(Long transactionId) {
		Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
		if (transactionOptional.isPresent()) {
			Transaction transaction = transactionOptional.get();
			return modelMapper.map(transaction, TransactionDto.class);
		}
		return null;
	}

	@Override
	public List<TransactionDto> getAllTransactions() {
		List<Transaction> transactions = transactionRepository.findAll();
		return transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public TransactionDto updateTransaction(TransactionDto transactionDto) {
		Optional<Transaction> transactionOptional = transactionRepository.findById(transactionDto.getId());
		if (transactionOptional.isPresent()) {
			Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
			transactionRepository.save(transaction);
			return modelMapper.map(transaction, TransactionDto.class);
		}
		return null;
	}

	@Override
	public ApiResponse deleteTransaction(Long transactionId) {
		Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
		if (transactionOptional.isPresent()) {
			Transaction transaction = transactionOptional.get();
			transactionRepository.delete(transaction);
			return new ApiResponse("Transaction deleted successfully", true);
		}
		return new ApiResponse("Transaction not found", false);
	}

}
