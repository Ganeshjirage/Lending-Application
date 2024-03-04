package com.banking.app.entity_model;

import com.banking.app.status.LoanApplicationStatus;
import com.banking.app.status.Occupation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "loanApplication")
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;
	private Occupation occupation;
	private Long AccountNo;
	private Integer cibilScore;
	private Long income;
	private LoanApplicationStatus loanApplicationStatus;

	@OneToOne
	private User user;
}