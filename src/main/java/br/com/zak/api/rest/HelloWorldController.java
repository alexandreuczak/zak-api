package br.com.zak.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zak.api.domain.Greeting;
import br.com.zak.api.repository.GrettingRepository;

@RestController
public class HelloWorldController {

	@Autowired
	private GrettingRepository repository;
	
	@GetMapping("/hello/{message}")
	public ResponseEntity<Greeting> hello(@PathVariable("message") String message){
		Greeting greeting = Greeting.builder().message(message).build();
		
		repository.save(greeting);
		
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);		
	}

	@GetMapping("/grettings")
	public ResponseEntity<List<Greeting>> listar(){
		List<Greeting> greetings = repository.findAll();
		return new ResponseEntity<List<Greeting>>(greetings, HttpStatus.OK);
	}
	
}
