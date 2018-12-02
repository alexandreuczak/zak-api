package br.com.zak.api.error;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResourceNotFoundDetail {

	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String error;
		
}
