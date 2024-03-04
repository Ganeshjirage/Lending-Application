package com.banking.app.service;

import com.banking.app.dto.LoanApplicationDto;
import com.banking.app.payload.ApiResponse;
import com.banking.app.payload.LoginDetailsDto;

public interface LoanApplicationService {

	public LoanApplicationDto createLoanApplication(LoanApplicationDto loanApplicationDto);

	public ApiResponse checkEligibility(LoginDetailsDto loginDetailsDto);
}
