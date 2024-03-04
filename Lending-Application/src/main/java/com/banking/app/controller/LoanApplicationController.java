package com.banking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.app.dto.LoanApplicationDto;
import com.banking.app.payload.ApiResponse;
import com.banking.app.payload.LoginDetailsDto;
import com.banking.app.service.LoanApplicationService;

@RestController
@RequestMapping("/loan_application")
public class LoanApplicationController {
	@Autowired
	private LoanApplicationService loanApplicationService;

	@PostMapping("/create")
	public ResponseEntity<LoanApplicationDto> createLoanApplication(
			@RequestBody LoanApplicationDto loanApplicationDto) {
		return new ResponseEntity<>(loanApplicationService.createLoanApplication(loanApplicationDto),
				HttpStatus.CREATED);
	}

	@GetMapping("/check")
	public ResponseEntity<ApiResponse> checkLoanApplication(@RequestBody LoginDetailsDto loginDetailsDto) {
		return new ResponseEntity<>(loanApplicationService.checkEligibility(loginDetailsDto), HttpStatus.OK);
	}
}
