package com.banking.app.dto;

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
	private String address;
}
