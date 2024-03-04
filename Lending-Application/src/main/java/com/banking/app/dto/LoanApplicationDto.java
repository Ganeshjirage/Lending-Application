package com.banking.app.dto;

import com.banking.app.entity_model.User;
import com.banking.app.status.Occupation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanApplicationDto {

	private Long loanId;
	private Occupation occupation;
	private Long AccountNo;
	private Integer cibilScore;
	private Long income;
//	    private LoanApplicationStatus loanApplicationStatus;
	private User user;
}
