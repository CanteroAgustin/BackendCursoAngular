package com.agustincantero.restwebservice.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAutheticationController {

	@GetMapping(path = "/basicauth")
	public AutheticationBean autheticationBean() {

		return new AutheticationBean("You are autenticated");
	}

	
}
