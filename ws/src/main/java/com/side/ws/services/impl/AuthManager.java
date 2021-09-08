package com.side.ws.services.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.side.ws.entities.User;
import com.side.ws.requests.AuthenticationRequest;
import com.side.ws.responses.AuthenticationResponse;
import com.side.ws.services.IAuthenticationService;


@Configuration
@Service
public class AuthManager implements IAuthenticationService{

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserDetails(String token) {
		// TODO Auto-generated method stub
		return null;
	}
											  

}
