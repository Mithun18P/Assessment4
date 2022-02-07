package com.thoughtfocus.RegistrationDetails.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.RegistrationDetails.controller.RegisterController;
import com.thoughtfocus.RegistrationDetails.dao.RegistrationDAO;
import com.thoughtfocus.RegistrationDetails.entity.UserEntity;
import com.thoughtfocus.RegistrationDetails.exception.PasswordException;

@Service
public class LoginService {
	
	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UserEntity entity;

	@Autowired
	RegistrationDAO dao;
	
	public UserEntity validateAndgetByUsername(String username, String password) {
		try {
			if (username.length() >= 5 && password.length() <= 10) {
				entity = dao.getByUsername(username);
				if (entity.getUsername().equals(username)) {
					return entity;
				}
			} else {
				throw new PasswordException("Password Invalid");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;

	}
}
