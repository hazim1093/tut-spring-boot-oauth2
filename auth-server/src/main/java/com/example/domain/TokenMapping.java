package com.example.domain;

import com.example.domain.types.AccessProvider;

import javax.persistence.*;

/**
 * Created by hazim on 2/16/16.
 */
@Entity
@Table
public class TokenMapping{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "access_token")
	private String accessToken;
	@Enumerated(EnumType.STRING)
	private AccessProvider accessProvider;

	private TokenMapping(){}

	private TokenMapping(String accessToken, AccessProvider accessProvider ){
		this.accessToken = accessToken;
		this.accessProvider = accessProvider;
	}

	public static TokenMapping newFacebookTokenMapping(String accessToken){
		return new TokenMapping(accessToken, AccessProvider.FACEBOOK);
	}

	public AccessProvider getAccessProvider() {
		return accessProvider;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public Long getId() {
		return id;
	}
}
