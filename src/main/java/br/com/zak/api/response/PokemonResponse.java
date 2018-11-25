package br.com.zak.api.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.zak.api.domain.Pokemon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long count;
	private List<Pokemon> results;
}
