package com.banking.app.service;

import java.util.List;

import com.banking.app.dto.EducationDto;
import com.banking.app.payload.ApiResponse;

public interface EducationService {

	public EducationDto createEducation(EducationDto educationDto);

	public EducationDto getEducationById(Long id);

	public List<EducationDto> getAllEducations();

	public EducationDto updateEducation(EducationDto educationDto);

	public ApiResponse deleteEducation(Long id);
}
