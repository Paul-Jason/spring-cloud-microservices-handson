package com.paulorg.photoapp.api.accountmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PhotoAppAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppAccountManagementApplication.class, args);
	}

}
