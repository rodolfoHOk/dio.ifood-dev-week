package me.dio.ifood.sacola.api.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInputRequest {
	
	@NotBlank
	@Size(max = 150)
	private String nome;
	
	@Valid
	@NotNull
	private EnderecoInputRequest endereco;
	
}
