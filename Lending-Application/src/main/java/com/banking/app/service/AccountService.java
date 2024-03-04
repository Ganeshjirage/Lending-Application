package com.banking.app.service;

import java.util.List;

import com.banking.app.dto.AccountDto;
import com.banking.app.entity_model.Account;
import com.banking.app.payload.ApiResponse;

public interface AccountService {

	public AccountDto addAccount(AccountDto accountDto);

	public AccountDto getAccountById(Long accountId);

	public List<AccountDto> getAllAccounts();

	public AccountDto updateAccount(AccountDto accountDto);

	public ApiResponse deleteAccount(Long accountId);
}
