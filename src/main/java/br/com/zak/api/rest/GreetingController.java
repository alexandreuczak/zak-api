package br.com.zak.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zak.api.domain.Greeting;
import br.com.zak.api.repository.GrettingRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Zak API Rest")
@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	private GrettingRepository repository;
	
	@ApiOperation("Create a new greeting")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Greeting> hello(@RequestParam("message") String message){
		Greeting greeting = Greeting.builder().message(message).build();
		
		repository.save(greeting);
		
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);		
	}

	@ApiOperation("List all greetings")
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Greeting>> listar(){
		List<Greeting> greetings = repository.findAll();
		return new ResponseEntity<List<Greeting>>(greetings, HttpStatus.OK);
	}
	
	@ApiOperation("Remove a greeting")
	@DeleteMapping
	public ResponseEntity<Void> remover(@RequestParam("id") Long id){
		repository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
