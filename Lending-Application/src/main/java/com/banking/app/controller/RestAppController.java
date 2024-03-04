package com.banking.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.app.dto.UserDto;
import com.banking.app.entity_model.User;
import com.banking.app.repository.UserRepository;
import com.banking.app.security.JwtGeneratorValidator;

@RestController
public class RestAppController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtGeneratorValidator jwtGeneratorValidator;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/registration")
	public ResponseEntity<Object> registerUser(@RequestBody UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setUserName(userDto.getUserName());
		User users = userRepository.save(user);
		if (users.equals(null)) {
			return generateResponse("Not Able to Save User", HttpStatus.BAD_REQUEST, user);
		} else {
			return generateResponse("User Saved Successfully", HttpStatus.OK, users);
		}
	}

	@GetMapping("/genToken")
	public String generateToken(@RequestBody UserDto userDto) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword()));
		} catch (Exception exception) {
			throw new Exception("Invalid Username/Password");
		}
		return jwtGeneratorValidator.generateToken(userDto.getUserName());
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}

	public ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("data", responseObj);

		return new ResponseEntity<>(map, status);
	}

}
