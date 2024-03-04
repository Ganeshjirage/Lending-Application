package com.banking.app.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.dto.LoanApplicationDto;
import com.banking.app.entity_model.LoanApplication;
import com.banking.app.entity_model.User;
import com.banking.app.payload.ApiResponse;
import com.banking.app.payload.LoginDetailsDto;
import com.banking.app.repository.LoanApplicationRepository;
import com.banking.app.repository.UserRepository;
import com.banking.app.service.LoanApplicationService;
import com.banking.app.status.LoanApplicationStatus;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
	@Autowired
	private LoanApplicationRepository loanApplicationRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LoanApplicationDto createLoanApplication(LoanApplicationDto loanApplicationDto) {
		LoanApplication loanApplication = modelMapper.map(loanApplicationDto, LoanApplication.class);
		loanApplication.setLoanApplicationStatus(LoanApplicationStatus.PENDING);
		loanApplicationRepository.save(loanApplication);
		return modelMapper.map(loanApplication, LoanApplicationDto.class);
	}

	@Override
	public ApiResponse checkEligibility(LoginDetailsDto loginDetailsDto) {
		User user = userRepository.findByUserIdAndPassword(loginDetailsDto.getUserId(), loginDetailsDto.getPassword());
		LoanApplication loanApplication1 = user.getLoanApplication();
		LoanApplicationDto loanApplicationDto = modelMapper.map(loanApplication1, LoanApplicationDto.class);
		LoanApplication loanApplication = modelMapper.map(loanApplicationDto, LoanApplication.class);
		if (loanApplicationDto.getCibilScore() < 700 && (loanApplicationDto.getIncome() < 600000)) {
			loanApplication.setLoanApplicationStatus(LoanApplicationStatus.REJECTED);
			return new ApiResponse("Sorry! Your Loan Application is Rejected", false);
		}
		loanApplication.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);
		return new ApiResponse("Congratulation! Your Loan Application is Approved", true);
	}
}
