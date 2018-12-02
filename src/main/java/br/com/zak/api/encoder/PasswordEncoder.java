package br.com.zak.api.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static String encode(String value) {
		return new BCryptPasswordEncoder().encode(value);		
	}
	
}
