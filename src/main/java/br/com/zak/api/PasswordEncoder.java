package br.com.zak.api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		String password = new BCryptPasswordEncoder().encode("admin");
		System.out.println(password);
	}

}
