package com.thoughtfocus.RegistrationDetails.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.RegistrationDetails.DTO.UserDTO;
import com.thoughtfocus.RegistrationDetails.exception.NullObjectException;
import com.thoughtfocus.RegistrationDetails.service.RegistrationService;

@RestController
public class RegisterController {

	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegistrationService service;

	@PostMapping("/save")
	public String registerData(@RequestBody UserDTO dto) {
		logger.info("***save method***");
		boolean status = false;
		try {
			if (dto.getUsername() != null && dto.getConfirmpassword() != null) {
				logger.info("Transfering to service");
				status = service.validateAndSaveUser(dto);
			} else {
				throw new NullObjectException("Fields are Empty");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (status) {
			return "Data Added Successfully";
		} else {
			return "Data Not added";
		}

	}

}
