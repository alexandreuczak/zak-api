package br.com.zak.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name  = "gretting")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Greeting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gretting_seq")
	@SequenceGenerator(name = "gretting_seq", sequenceName = "gretting_seq")
	private Long id;
	
	@Column(name = "message")
	private String message;
	
}
