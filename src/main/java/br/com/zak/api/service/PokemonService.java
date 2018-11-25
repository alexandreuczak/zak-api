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
	private static final String USER_AGENT_HEADER = "user-agent";
	private static final String USER_AGENT_HEADER_BROWSER_INFO = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
	
	public PokemonResponse getAll() {
		RestTemplate restTemplate = new RestTemplate();
		
		 HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add(USER_AGENT_HEADER, USER_AGENT_HEADER_BROWSER_INFO);
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return restTemplate
				.exchange(POKEMON_URI, HttpMethod.GET, entity, PokemonResponse.class)
				.getBody();
	}
	
}
