package br.com.zak.api.rest.validator;

import org.springframework.stereotype.Component;

import br.com.zak.api.domain.Greeting;
import br.com.zak.api.error.ResourceNotFoundException;

@Component
public class GreetingValidator {

	public void valid(Greeting greeting) {
		if(greeting == null) {
			throw new ResourceNotFoundException("Sem Resultado");
		}
	}
	
}
