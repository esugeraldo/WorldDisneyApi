package com.exudo.DisneyWorldApi.registration;

import lombok.Data;

@Data
public class RegistrationsRequest {
	
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;
}
