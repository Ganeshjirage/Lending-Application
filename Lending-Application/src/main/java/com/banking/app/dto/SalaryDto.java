package com.banking.app.dto;

import java.util.List;

import com.banking.app.entity_model.User;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {

	private Long id;

	private double amount;

	private User user;

}
