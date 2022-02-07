package com.thoughtfocus.RegistrationDetails.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordDTO {
	private String username;
	private String password;
	private String confirmpassword;
}
