package com.exudo.DisneyWorldApi.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exudo.DisneyWorldApi.modelDTO.AppUser;
import com.exudo.DisneyWorldApi.repository.AppUserRepository;
import com.exudo.DisneyWorldApi.security.PasswordEncoder;
import com.exudo.DisneyWorldApi.token.ConfirmationToken;
import com.exudo.DisneyWorldApi.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{

	private final static String USER_NOT_FOUND = "user with email %s not found";
	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return appUserRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
	}

	public String signUpUser (AppUser appUser) {
		boolean userExits = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
		
		if (userExits) {
			throw new IllegalStateException("email already taken");
		}
		String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(appUser.getPassword());
		appUser.setPassword(encodedPassword);
		
		appUserRepository.save(appUser);
		
		
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
					token,
					LocalDateTime.now(),
					LocalDateTime.now().plusMinutes(15),
					appUser
				);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		
		
		return token;
		
	}
	
	   public int enableAppUser(String email) {
	        return appUserRepository.enableAppUser(email);
	    }
	
}
