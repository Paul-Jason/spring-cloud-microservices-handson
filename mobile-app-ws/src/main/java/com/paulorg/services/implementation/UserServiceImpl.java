package com.paulorg.services.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulorg.services.UserServiceInterface;
import com.paulorg.ui.model.request.UserDetailsRequestModel;
import com.paulorg.ui.model.response.UserTO;
import com.paulorg.utils.Utils;

@Service
public class UserServiceImpl implements UserServiceInterface{
	
	Map<String, UserTO> users;
	Utils utils;	
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserTO createUser(UserDetailsRequestModel userDetails) {
		UserTO userTO = new UserTO();	
		userTO.setEmail(userDetails.getEmail());
		userTO.setFirstName(userDetails.getFirstName());
		userTO.setSecondName(userDetails.getSecondName());
		String userId = utils.generateUserId();
		userTO.setUserId(userId);
		
		if(users == null) users = new HashMap<String, UserTO>();
			users.put(userId, userTO);
		return userTO;
	}

}
