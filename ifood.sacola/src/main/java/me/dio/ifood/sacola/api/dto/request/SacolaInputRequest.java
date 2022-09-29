package me.dio.ifood.sacola.api.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SacolaInputRequest {

	@Valid
	@NotNull
	private ClienteIdInputRequest cliente;
	
}
