package com.banking.app.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.dto.SalaryDto;
import com.banking.app.entity_model.Salary;
import com.banking.app.payload.ApiResponse;
import com.banking.app.repository.SalaryRepository;
import com.banking.app.repository.TransactionRepository;
import com.banking.app.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryRepository salaryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SalaryDto createSalary(SalaryDto salaryDto) {
		Salary salary = modelMapper.map(salaryDto, Salary.class);
		salaryRepository.save(salary);
		return modelMapper.map(salary, SalaryDto.class);
	}

	@Override
	public List<SalaryDto> getAllSalaries() {
		List<Salary> salaries = salaryRepository.findAll();
		return salaries.stream().map(salary -> modelMapper.map(salary, SalaryDto.class)).collect(Collectors.toList());
	}

	@Override
	public SalaryDto getSalaryById(Long id) {
		Optional<Salary> salaryOptional = salaryRepository.findById(id);
		if (salaryOptional.isPresent()) {
			Salary salary = salaryOptional.get();
			return modelMapper.map(salary, SalaryDto.class);
		}
		return null;
	}

	@Override
	public SalaryDto updateSalary(SalaryDto salaryDto) {
		Long id = salaryDto.getId(); // Extract the ID from the DTO
		Optional<Salary> salaryOptional = salaryRepository.findById(id);
		if (salaryOptional.isPresent()) {
			Salary salary = modelMapper.map(salaryDto, Salary.class);
			salary.setId(id);
			salaryRepository.save(salary);
			return modelMapper.map(salary, SalaryDto.class);
		}
		return null;
	}

	@Override
	public ApiResponse deleteSalary(Long id) {
		Optional<Salary> salaryOptional = salaryRepository.findById(id);
		if (salaryOptional.isPresent()) {
			Salary salary = salaryOptional.get();
			salaryRepository.delete(salary);
			return new ApiResponse("Salary deleted successfully", true);
		}
		return new ApiResponse("Salary not found", false);
	}
}