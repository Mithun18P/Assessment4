package com.thoughtfocus.RegistrationDetails.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.RegistrationDetails.DTO.UpdatePasswordDTO;
import com.thoughtfocus.RegistrationDetails.controller.RegisterController;
import com.thoughtfocus.RegistrationDetails.dao.RegistrationDAO;
import com.thoughtfocus.RegistrationDetails.entity.UserEntity;
import com.thoughtfocus.RegistrationDetails.exception.PasswordException;

@Service
public class ForgotService {
	
	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UserEntity entity;

	@Autowired
	RegistrationDAO dao;
	public UserEntity validateAndUpdatePass(UpdatePasswordDTO dto) {
		try {
			if (dto.getUsername() != null && dto.getPassword().equals(dto.getConfirmpassword())) {
				logger.info(dto.toString());
				UserEntity detail = dao.getByUsername(dto.getUsername());
				if (detail.getUsername().equals(dto.getUsername())) {
					detail.setPassword(dto.getPassword());
					UserEntity entity2 = dao.save(detail);
					return entity2;
				} else {
					throw new PasswordException("username invalid");
				}

			} else {
				throw new PasswordException("enter all fileds");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
