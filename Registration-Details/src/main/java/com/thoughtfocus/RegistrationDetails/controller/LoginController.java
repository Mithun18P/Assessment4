package com.thoughtfocus.RegistrationDetails.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.RegistrationDetails.entity.UserEntity;
import com.thoughtfocus.RegistrationDetails.exception.NullObjectException;
import com.thoughtfocus.RegistrationDetails.service.LoginService;

@RestController
public class LoginController {

	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private LoginService service;

	@GetMapping("/user")
	public String loginByUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
		logger.info("****login method****");
		UserEntity entity = null;
		try {
			if (username != null && password != null) {
				logger.info("Transfer to service method..");
				entity = service.validateAndgetByUsername(username, password);
			} else {
				throw new NullObjectException("Enter fileds");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (entity == null) {
			return "Details not found";
		} else {
			return entity.toString();
		}

	}
}
