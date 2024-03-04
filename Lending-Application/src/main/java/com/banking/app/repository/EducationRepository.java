package com.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.app.entity_model.Education;
import com.banking.app.entity_model.Transaction;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{

}
