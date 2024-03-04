package com.banking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.app.dto.TransactionDto;
import com.banking.app.payload.ApiResponse;
import com.banking.app.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/add")
	public ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transactionDto) {
		return new ResponseEntity<>(transactionService.addTransaction(transactionDto), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<TransactionDto>> getAllTransactions() {
		return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
		return new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<TransactionDto> updateTransaction(@RequestBody TransactionDto transactionDto) {
		return new ResponseEntity<>(transactionService.updateTransaction(transactionDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteTransaction(@PathVariable Long id) {
		return new ResponseEntity<>(transactionService.deleteTransaction(id), HttpStatus.OK);
	}
}