package br.com.zak.api.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zak.api.response.PokemonResponse;

@Service
public class PokemonService {

	private static final String POKEMON_URI = "https://pokeapi.co/api/v2/pokemon/";
	
	public PokemonResponse getAll() {
		RestTemplate restTemplate = new RestTemplate();
		
		 HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
//		return restTemplate.getForObject(POKEMON_URI, PokemonResponse.class);
		return restTemplate
				.exchange(POKEMON_URI, HttpMethod.GET , entity,PokemonResponse.class)
				.getBody();
	}
	
}
