package com.banking.app.service;

import java.util.List;

import com.banking.app.dto.SalaryDto;
import com.banking.app.payload.ApiResponse;

public interface SalaryService {

	public SalaryDto createSalary(SalaryDto salaryDto);

	public SalaryDto getSalaryById(Long id);

	public List<SalaryDto> getAllSalaries();

	public SalaryDto updateSalary(SalaryDto salaryDto);

	public ApiResponse deleteSalary(Long id);
}
