package com.paulorg.services;

import com.paulorg.ui.model.request.UserDetailsRequestModel;
import com.paulorg.ui.model.response.UserTO;

public interface UserServiceInterface {
	
	public UserTO createUser(UserDetailsRequestModel userDetails);

}
