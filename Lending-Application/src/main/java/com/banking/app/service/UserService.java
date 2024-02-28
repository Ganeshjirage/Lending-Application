package com.banking.app.service;

import java.util.List;

import com.banking.app.dto.UserDto;
import com.banking.app.payload.ApiResponse;

public interface UserService {

	public UserDto createUser(UserDto userDto);

	public UserDto getUserById(Integer id);

	public List<UserDto> getAllUsers();

	public UserDto updateUser(UserDto userDto);

	public ApiResponse deleteUserById(Integer id);
}
