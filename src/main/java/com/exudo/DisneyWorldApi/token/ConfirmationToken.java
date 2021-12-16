package com.exudo.DisneyWorldApi.token;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.exudo.DisneyWorldApi.modelDTO.AppUser;

import lombok.Data;

@Data
@Entity
public class ConfirmationToken {
	
	@Id
	@SequenceGenerator(name = "confirmation_token_sequence", sequenceName = "confirmation_token_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confirmation_token_sequence")
	private Long id;
	@Column(nullable = false)
	private String token;
	@Column(nullable = false)
	private LocalDateTime createdAt;
	@Column(nullable = false)
	private LocalDateTime expiresAt;

	private LocalDateTime confirmedAt;
	@ManyToOne
	@JoinColumn(nullable = false, name = "app_user_id")
		private AppUser appUser;
	

	
	public ConfirmationToken() {
		
	}



	public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime epiresAt,	AppUser appUser) {
		
		this.token = token;
		this.createdAt = createdAt;
		this.expiresAt = epiresAt;
		this.appUser = appUser;
	}

}
