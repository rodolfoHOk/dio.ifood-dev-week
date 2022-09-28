package me.dio.ifood.sacola.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponse {

	private String cep;
	
	private String numero;
	
	private String complemento;
}
