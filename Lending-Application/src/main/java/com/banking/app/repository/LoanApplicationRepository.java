package com.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.app.entity_model.LoanApplication;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

}
