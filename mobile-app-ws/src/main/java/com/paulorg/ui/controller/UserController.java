package com.paulorg.ui.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paulorg.services.UserServiceInterface;
import com.paulorg.services.implementation.UserServiceImpl;
import com.paulorg.ui.model.request.UserDetailsRequestModel;
import com.paulorg.ui.model.response.UserTO;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserServiceInterface userService;
	
	@GetMapping
	//Required doesn't go well with primitive data types if default value is not given[
	public String getUsers(@RequestParam(value = "page", defaultValue = "1", required= false) int page, 
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc") String sort) {
		return "Get limited number of users";
	}
	
	@GetMapping(path="/{userId}")
	public ResponseEntity<UserTO> getUser(@PathVariable String userId) {
		String firstName = null;
		int length = firstName.length();
		UserTO userTO = new UserTO();
		userTO.setEmail("paulie@paul.org");
		userTO.setFirstName("Paulie");
		userTO.setSecondName("Again Paulie");
		return new ResponseEntity<UserTO>(userTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserTO> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
		UserTO userTO = userService.createUser(userDetails);
		return new ResponseEntity<UserTO>(userTO, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user";
	}
	
}
