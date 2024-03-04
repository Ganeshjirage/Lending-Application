package com.banking.app.entity_model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String panNo;
	private String aadhaarNo;
	private String accountNo;
	private String mobileNo;
	private String address;
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	private Education education;

	private String userId;
	private String userName;
	private String password;
	private Boolean isAlreadyAppliedLoan;

	@OneToMany(mappedBy = "my_user", cascade = CascadeType.ALL)
	private List<Salary> salaries;

	@OneToOne(mappedBy = "my_user")
	private LoanApplication loanApplication;

}