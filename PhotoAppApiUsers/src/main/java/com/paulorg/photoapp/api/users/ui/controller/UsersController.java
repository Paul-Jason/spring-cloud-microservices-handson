package com.paulorg.photoapp.api.users.ui.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulorg.photoapp.api.users.service.UsersService;
import com.paulorg.photoapp.api.users.shared.UserDTO;
import com.paulorg.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.paulorg.photoapp.api.users.ui.model.CreateUserResponseModel;

@RestController
@RequestMapping(path= "/users")
public class UsersController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UsersService userService;
	
	@GetMapping(path="/status/check")
	public String status() {
		return "Working on port : "+ env.getProperty("local.server.port");
	}
	
	@PostMapping(consumes = {org.springframework.http.MediaType.APPLICATION_XML_VALUE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE},
				produces = {org.springframework.http.MediaType.APPLICATION_XML_VALUE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);	
		UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
		UserDTO createdUser = userService.createUser(userDTO);
		CreateUserResponseModel response = modelMapper.map(createdUser, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
