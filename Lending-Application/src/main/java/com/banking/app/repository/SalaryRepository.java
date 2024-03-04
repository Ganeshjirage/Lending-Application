package com.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.app.entity_model.Education;
import com.banking.app.entity_model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
