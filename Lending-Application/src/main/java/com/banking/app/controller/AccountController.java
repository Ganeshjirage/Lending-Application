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

import com.banking.app.dto.AccountDto;
import com.banking.app.entity_model.Account;
import com.banking.app.payload.ApiResponse;
import com.banking.app.service.AccountService;
import com.banking.app.service.UserService;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/save")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.addAccount(accountDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{accountId}")
    public ResponseEntity<ApiResponse> deleteAccountById(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.deleteAccount(accountId), HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.updateAccount(accountDto), HttpStatus.OK);
    }
}
