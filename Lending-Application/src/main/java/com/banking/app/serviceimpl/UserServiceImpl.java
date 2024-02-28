package com.banking.app.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.dto.UserDto;
import com.banking.app.entity_model.User;
import com.banking.app.exception.ResourceNotFoundException;
import com.banking.app.payload.ApiResponse;
import com.banking.app.repository.UserRepository;
import com.banking.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		userRepository.save(user);
		UserDto usrDto = modelMapper.map(user, UserDto.class);
		return usrDto;
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
		UserDto dto = modelMapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserDto> dtoList = userList.stream().map(m -> modelMapper.map(m, UserDto.class))
				.collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		UserDto user = getUserById(userDto.getId());// for checking user exist or not

		User savedUser = modelMapper.map(userDto, User.class);
		userRepository.save(savedUser);
		UserDto savedDto = modelMapper.map(savedUser, UserDto.class);
		return savedDto;
	}

	@Override
	public ApiResponse deleteUserById(Integer id) {
		UserDto userDto = getUserById(id);// for checking user exist or not
		User user = modelMapper.map(userDto, User.class);
		userRepository.delete(user);
		ApiResponse apiResponse = new ApiResponse("User Deleted Successfully", true);
		return apiResponse;
	}
}
