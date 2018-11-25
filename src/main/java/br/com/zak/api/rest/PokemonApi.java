package br.com.zak.api.rest;

import org.springframework.http.ResponseEntity;

import br.com.zak.api.response.PokemonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Pokemon API Rest")
public interface PokemonApi {

	@ApiOperation("List all pokemons available in pokeapi")
	ResponseEntity<PokemonResponse> listar();

}