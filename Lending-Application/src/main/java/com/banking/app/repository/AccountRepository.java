package com.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.app.entity_model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}