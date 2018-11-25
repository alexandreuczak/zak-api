package br.com.zak.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zak.api.response.PokemonResponse;

@Service
public class PokemonService {

	private static final String POKEMON_URI = "https://pokeapi.co/api/v2/pokemon/";
	
	public PokemonResponse getAll() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(POKEMON_URI, PokemonResponse.class);
	}
	
}
