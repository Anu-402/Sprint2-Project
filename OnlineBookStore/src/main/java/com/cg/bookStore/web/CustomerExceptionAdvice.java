package com.cg.bookStore.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bookStore.exceptions.CustomerEmailIdnotFound;
import com.cg.bookStore.exceptions.CustomerException;
import com.cg.bookStore.exceptions.CustomerIdNotFoundException;


@RestControllerAdvice
public class CustomerExceptionAdvice {
	
	Logger logger = LoggerFactory.getLogger(CustomerExceptionAdvice.class);
	
	@ExceptionHandler(value = {CustomerException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND )
	@ResponseBody
	public Map<String, String> handlerException1(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}
	
	@ExceptionHandler(value = {CustomerIdNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND )
	@ResponseBody
	public Map<String, String> handlerException2(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}

	@ExceptionHandler(value = {CustomerEmailIdnotFound.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND )
	@ResponseBody
	public Map<String, String> handlerException3(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}
}
