package br.com.zak.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.zak.api.domain.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Zak API Rest")
public interface GreetingApi {

	@ApiOperation("Create a new greeting")
	ResponseEntity<Greeting> inserir(String message);

	@ApiOperation("Get a specific greeting")
	ResponseEntity<Greeting> buscar(Long id);

	
	@ApiOperation("List all greetings")
	ResponseEntity<List<Greeting>> listar();

	@ApiOperation("Remove a greeting")
	ResponseEntity<Void> remover(Long id);

}