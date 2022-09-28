package me.dio.ifood.sacola.api.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormaPagamentoInputRequest {
	
	@NotBlank
	private String formaPagamento;
	
}
