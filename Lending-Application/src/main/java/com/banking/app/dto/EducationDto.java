package com.banking.app.dto;

import java.util.Date;
import java.util.List;

import com.banking.app.entity_model.Account;
import com.banking.app.entity_model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
	private Long id;
	private String institution;
	private List<User> user;

}
