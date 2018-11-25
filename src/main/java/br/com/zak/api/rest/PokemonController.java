package br.com.zak.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zak.api.response.PokemonResponse;
import br.com.zak.api.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController implements PokemonApi {

	@Autowired
	private PokemonService pokemonService;
	
	@Override
	@GetMapping
	public ResponseEntity<PokemonResponse> listar(){
		PokemonResponse response = pokemonService.getAll();
		return new ResponseEntity<PokemonResponse>(response, HttpStatus.OK);
	}
	
}
