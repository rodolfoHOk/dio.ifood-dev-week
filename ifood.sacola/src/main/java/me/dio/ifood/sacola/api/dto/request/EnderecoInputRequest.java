package me.dio.ifood.sacola.api.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInputRequest {
	
	@NotBlank
	@Min(value = 9) //obs: incluindo -
	private String cep;
	
	@NotBlank
	@Size(max = 6)
	private String numero;
	
	@Size(max = 100)
	private String complemento;
	
}
