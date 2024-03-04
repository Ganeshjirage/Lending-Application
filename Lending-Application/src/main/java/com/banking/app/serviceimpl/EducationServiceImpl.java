package com.banking.app.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.dto.EducationDto;
import com.banking.app.entity_model.Education;
import com.banking.app.payload.ApiResponse;
import com.banking.app.repository.EducationRepository;
import com.banking.app.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EducationDto createEducation(EducationDto educationDto) {
		Education education = modelMapper.map(educationDto, Education.class);
		educationRepository.save(education);
		return modelMapper.map(education, EducationDto.class);
	}

	@Override
	public List<EducationDto> getAllEducations() {
		List<Education> educations = educationRepository.findAll();
		return educations.stream().map(education -> modelMapper.map(education, EducationDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public EducationDto getEducationById(Long id) {
		Optional<Education> educationOptional = educationRepository.findById(id);
		return educationOptional.map(education -> modelMapper.map(education, EducationDto.class)).orElse(null);
	}

	@Override
	public EducationDto updateEducation(EducationDto educationDto) {
		Optional<Education> educationOptional = educationRepository.findById(educationDto.getId());
		if (educationOptional.isPresent()) {
			Education education = modelMapper.map(educationDto, Education.class);
			Long id = educationDto.getId(); // Extract the ID from the DTO
			education.setId(id);
			educationRepository.save(education);
			return modelMapper.map(education, EducationDto.class);
		}
		return null;
	}

	@Override
	public ApiResponse deleteEducation(Long id) {
		Optional<Education> educationOptional = educationRepository.findById(id);
		if (educationOptional.isPresent()) {
			educationRepository.deleteById(id);
			return new ApiResponse("Education deleted successfully", true);
		}
		return new ApiResponse("Education not found", false);
	}
}
