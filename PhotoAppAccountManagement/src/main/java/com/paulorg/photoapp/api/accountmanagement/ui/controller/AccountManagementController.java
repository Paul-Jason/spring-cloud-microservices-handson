package com.paulorg.photoapp.api.accountmanagement.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accountmanagment")
public class AccountManagementController {
	
	@GetMapping(path = "/status/check")
	public String getStatus() {
		return "Account Management Service is UP and Running";
	}

}
