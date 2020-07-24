package com.agustincantero.restwebservice.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

//	{
//		"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU5NTcxNDU4MSwiaWF0IjoxNTk1MTA5NzgxfQ.p_J72m2Wr6t3VgSXZAUzWeAby3farEhfR9aXmjkOWltRG3pyZB-UsNRyOTHoeTrGIuErQ2ItAyTWv6iAFvzttg"
//	}

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}