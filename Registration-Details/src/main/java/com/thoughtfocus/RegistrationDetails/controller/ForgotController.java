package com.thoughtfocus.RegistrationDetails.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.RegistrationDetails.DTO.UpdatePasswordDTO;
import com.thoughtfocus.RegistrationDetails.entity.UserEntity;
import com.thoughtfocus.RegistrationDetails.service.ForgotService;


@RestController
public class ForgotController {
	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private ForgotService service;

	@PostMapping("/forgot")
	String forgotController(@RequestBody UpdatePasswordDTO dto) {
		try {
			logger.info("Transfering to service class");
			UserEntity status = service.validateAndUpdatePass(dto);
			if (status.getPassword() != null) {
				logger.info("****Data saved****");
				logger.info(status.toString());
				return "updated" + status.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not updated";
	}

}
