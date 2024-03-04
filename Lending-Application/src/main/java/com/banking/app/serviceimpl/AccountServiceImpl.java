package com.banking.app.serviceimpl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.dto.AccountDto;
import com.banking.app.entity_model.Account;
import com.banking.app.exception.ResourceNotFoundException;
import com.banking.app.payload.ApiResponse;
import com.banking.app.repository.AccountRepository;
import com.banking.app.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AccountDto addAccount(AccountDto accountDto) {
		List<Account> allAccounts = accountRepository.findAll();
		Long accountNumber = null;
		while (accountNumber == null) {
			Long randomNumber = getRandomNumber();
			if (!allAccounts.contains(randomNumber)) {
				accountNumber = randomNumber;
				break;
			}
		}
		accountDto.setAccountNo(accountNumber);
		Account account = modelMapper.map(accountDto, Account.class);
		accountRepository.save(account);
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	public AccountDto getAccountById(Long accountId) {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", accountId));

		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accountList = accountRepository.findAll();
		return accountList.stream().map(acc -> modelMapper.map(acc, AccountDto.class)).collect(Collectors.toList());
	}

	@Override
	public AccountDto updateAccount(AccountDto accountDto) {
		getAccountById(accountDto.getAccountNo());
		Account account = modelMapper.map(accountDto, Account.class);
		accountRepository.save(account);
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	public ApiResponse deleteAccount(Long accountId) {
		AccountDto accountDto = getAccountById(accountId);
		Account account = modelMapper.map(accountDto, Account.class);
		accountRepository.delete(account);
		return new ApiResponse("Account Deleted Successfully", true);
	}

	private Long getRandomNumber() {
		return 1000000000L + new Random().nextLong(9000000000L);
	}

}
