package com.banking.app.dto;

import java.util.Date;

import com.banking.app.entity_model.Account;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

	private Long id;
	private Account account;
	private double amount;
	private Date transactionDate;

}
