package com.thoughtfocus.RegistrationDetails.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.RegistrationDetails.DTO.UserDTO;
import com.thoughtfocus.RegistrationDetails.controller.RegisterController;
import com.thoughtfocus.RegistrationDetails.dao.RegistrationDAO;
import com.thoughtfocus.RegistrationDetails.entity.UserEntity;
import com.thoughtfocus.RegistrationDetails.exception.PasswordException;
import com.thoughtfocus.RegistrationDetails.exception.RegisterdException;

@Service
public class RegistrationService {

	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UserEntity entity;

	@Autowired
	RegistrationDAO dao;
	

	public boolean validateAndSaveUser(UserDTO dto) {
		try {
			if (dto.getPassword().equals(dto.getConfirmpassword()) && dto.getPassword().length() >= 5
					&& dto.getPassword().length() <= 10) {
				UserEntity registerdUser=dao.getByUsername(dto.getUsername());
				if(registerdUser==null) {
					BeanUtils.copyProperties(dto, entity);
					dao.save(entity);
					return true;
				}
				else {
					throw new RegisterdException("Already you are registerd...");
				}
			} else {
				throw new PasswordException("Password Invalid");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;

	}

}
