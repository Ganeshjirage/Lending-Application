package com.banking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.banking.app.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(
			ResourceNotFoundException resourceNotFoundExceptionHandler) {
		String message = resourceNotFoundExceptionHandler.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}
}
