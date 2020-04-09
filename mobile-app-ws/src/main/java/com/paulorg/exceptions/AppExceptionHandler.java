//package com.paulorg.exceptions;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
//
//import com.paulorg.ui.model.response.ErrorMessage;
//
//@ControllerAdvice
//public class AppExceptionHandler extends ResponseStatusExceptionHandler{	
//	
//	@ExceptionHandler(value = {Exception.class})
//	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
//		ErrorMessage errMsg = new ErrorMessage(new Date(), ex.getLocalizedMessage());
//	
//		return new ResponseEntity<>(
//					ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
//				);
//	}
//
//}
