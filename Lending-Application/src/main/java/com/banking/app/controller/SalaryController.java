package com.banking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.app.dto.SalaryDto;
import com.banking.app.payload.ApiResponse;
import com.banking.app.service.SalaryService;

@RestController
@RequestMapping("/salaries")
public class SalaryController {

	@Autowired
	private SalaryService salaryService;

	@PostMapping("/add")
	public ResponseEntity<SalaryDto> addSalary(@RequestBody SalaryDto salaryDto) {
		return new ResponseEntity<>(salaryService.createSalary(salaryDto), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<SalaryDto>> getAllSalaries() {
		return new ResponseEntity<>(salaryService.getAllSalaries(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SalaryDto> getSalaryById(@PathVariable Long id) {
		return new ResponseEntity<>(salaryService.getSalaryById(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<SalaryDto> updateSalary(@PathVariable Long id, @RequestBody SalaryDto salaryDto) {
		return new ResponseEntity<>(salaryService.updateSalary(salaryDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteSalary(@PathVariable Long id) {
		return new ResponseEntity<>(salaryService.deleteSalary(id), HttpStatus.OK);
	}
}
