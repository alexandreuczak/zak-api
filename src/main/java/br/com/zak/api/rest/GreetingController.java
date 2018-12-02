package br.com.zak.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zak.api.domain.Greeting;
import br.com.zak.api.repository.GrettingRepository;
import br.com.zak.api.rest.validator.GreetingValidator;

@RestController
@RequestMapping("/greeting")
public class GreetingController implements GreetingApi {

	@Autowired
	private GrettingRepository repository;
	
	@Autowired
	private GreetingValidator validator;
	
	@Override
	@PostMapping(produces = "application/json", path = "/{message}")
	public ResponseEntity<Greeting> inserir(@PathVariable("message") String message){
		Greeting greeting = Greeting.builder().message(message).build();
		
		repository.save(greeting);
		
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);		
	}

	@Override
	@GetMapping(produces = "application/json", path = "/{id}")
	public ResponseEntity<Greeting> buscar(@PathVariable("id") Long id) {
		Greeting greeting = repository.findById(id).orElse(null);
		
		validator.valid(greeting);
		
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable("id") Long id){
		repository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Greeting>> listar(){
		List<Greeting> greetings = repository.findAll();
		return new ResponseEntity<List<Greeting>>(greetings, HttpStatus.OK);
	}
	

}
