package com.exudo.DisneyWorldApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exudo.DisneyWorldApi.registration.RegistrationsRequest;
import com.exudo.DisneyWorldApi.services.RegistrationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class RegistrationController {
	

	private RegistrationService registrationService;
	@PostMapping()
	public String register(@RequestBody RegistrationsRequest request) {
		return registrationService.register(request);
	}
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
