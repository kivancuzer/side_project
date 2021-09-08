package com.side.ws.services;

import org.springframework.stereotype.Component;

import com.side.ws.entities.User;
import com.side.ws.requests.AuthenticationRequest;
import com.side.ws.responses.AuthenticationResponse;

@Component
public interface IAuthenticationService {

	AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
	
	User getUserDetails(String token);
}
