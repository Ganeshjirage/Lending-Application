package com.banking.app.entity_model;

import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "loginDetails")
public class LoginDetails {
	private Integer userId;
	private String username;
	@NonNull
	private String password;
//	private List<Role> roles;

}
