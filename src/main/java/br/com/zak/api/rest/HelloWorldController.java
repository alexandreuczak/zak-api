package br.com.zak.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zak.api.domain.Greeting;

@RestController
public class HelloWorldController {

	@GetMapping("/hello/{message}")
	public ResponseEntity<Greeting> hello(@PathVariable("message") String message){
		Greeting greeting = Greeting.builder().message(message).build();
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);		
	}
	
}
