package com.insura.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.base.Throwables;



@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

//// for custom validation
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Map<String, Object>> handleSubmitValidationException(ValidationException e) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", HttpStatus.BAD_REQUEST.value());
		result.put("message", e.getMessage());
		ResponseEntity<Map<String, Object>> response = new ResponseEntity<Map<String, Object>>(result,
				HttpStatus.BAD_REQUEST);
		logger.error(e.toString(), Throwables.getStackTraceAsString(e));
		return response;
	}
}
