package com.nagarro.Mini_Assignment_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {

		LocalDateTime currentDateTime = LocalDateTime.now();

		String formattedDateTime = currentDateTime.format(formatter);

		return ResponseEntity.status(ex.getStatusCode())
				.body(Map.of("message", ex.getMessage(), "code", ex.getStatusCode(), "timestamp", formattedDateTime));
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, Object>> handleInternalServerException(Exception ex) {
		LocalDateTime currentDateTime = LocalDateTime.now();

		String formattedDateTime = currentDateTime.format(formatter);
		return ResponseEntity.status(500)
				.body(Map.of("message", "Internal Server Error", "code", 500, "timestamp", formattedDateTime));
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, Object>> handleBadReqException(BadRequestException ex) {
		LocalDateTime currentDateTime = LocalDateTime.now();

		String formattedDateTime = currentDateTime.format(formatter);
		return ResponseEntity.status(ex.getStatusCode())
				.body(Map.of("message", ex.getMessage(), "code", ex.getStatusCode(), "timestamp", formattedDateTime));
	}

}
