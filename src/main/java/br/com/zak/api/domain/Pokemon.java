package br.com.zak.api.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pokemon implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String url;
}
