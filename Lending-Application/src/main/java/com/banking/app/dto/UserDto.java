package com.banking.app.dto;

import java.util.List;

import com.banking.app.entity_model.Education;
import com.banking.app.entity_model.Salary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private Integer id;
	private String name;
	private String panNo;
	private String aadhaarNo;
	private String accountNo;
	private String mobileNo;
	private String email;
	private String address;
	private Education education;
	private List<Salary> salaries;
	private String userName;
	private String password;
	private Boolean isAlreadyAppliedLoan;
}
