package com.banking.app.entity_model;

import java.util.Date;
import java.util.List;

import com.banking.app.status.AccountType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "account")
public class Account {
	@Id
	private Long accountNo;
	private AccountType accountType;
	private Double balance;
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transactions;
}
