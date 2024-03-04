package com.banking.app.serviceimpl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banking.app.dto.UserDto;
import com.banking.app.entity_model.User;
import com.banking.app.repository.UserRepository;
import com.banking.app.service.DefaultUserService;

@Service
public class DefaultUserServiceImpl implements DefaultUserService {
	@Autowired
//    EmployeeRepository employeeRepository;
	UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		UserDto dto = modelMapper.map(user, UserDto.class);

		return new org.springframework.security.core.userdetails.User(dto.getUserName(), dto.getPassword(),
				new ArrayList<>());
	}
}