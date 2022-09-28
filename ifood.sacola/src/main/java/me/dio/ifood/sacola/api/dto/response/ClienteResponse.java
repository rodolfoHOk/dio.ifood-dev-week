package me.dio.ifood.sacola.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {
	
	private Long id;
	
	private String nome;
	
	private EnderecoResponse endereco;

}
