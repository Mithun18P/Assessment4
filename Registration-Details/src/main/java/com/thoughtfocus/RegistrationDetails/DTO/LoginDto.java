package com.thoughtfocus.RegistrationDetails.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginDto {
	private String username;
	private String password;
}
