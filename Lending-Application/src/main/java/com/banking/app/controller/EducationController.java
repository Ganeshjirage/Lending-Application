package com.banking.app.controller;

import com.banking.app.dto.EducationDto;
import com.banking.app.payload.ApiResponse;
import com.banking.app.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {

	@Autowired
	private EducationService educationService;

	@PostMapping("/save")
	public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto educationDto) {
		return new ResponseEntity<>(educationService.createEducation(educationDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EducationDto> getEducationById(@PathVariable Long id) {
		return new ResponseEntity<>(educationService.getEducationById(id), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<EducationDto>> getAllEducations() {
		return new ResponseEntity<>(educationService.getAllEducations(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteEducation(@PathVariable Long id) {
		return new ResponseEntity<>(educationService.deleteEducation(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<EducationDto> updateEducation(@RequestBody EducationDto educationDto) {
		return new ResponseEntity<>(educationService.updateEducation(educationDto), HttpStatus.OK);
	}
}
