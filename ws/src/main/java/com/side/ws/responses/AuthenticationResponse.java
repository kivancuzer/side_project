package com.side.ws.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationResponse {
	private String token;
	private String message;
	private String role;
	private String name;
	private String surname;
}
