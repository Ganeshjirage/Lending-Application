package com.banking.app.dto;

import java.util.Date;
import java.util.List;

import com.banking.app.entity_model.Transaction;
import com.banking.app.status.AccountType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
    private Long accountNo;
    private AccountType accountType;
    private Double balance;
	private List<Transaction> transactions;
}