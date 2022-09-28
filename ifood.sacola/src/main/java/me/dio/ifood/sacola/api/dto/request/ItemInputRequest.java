package me.dio.ifood.sacola.api.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInputRequest {

	@Valid
	@NotNull
	private ProdutoIdInputRequest produto;
	
	@NotNull
	@Positive
	private int quantidade;
	
}
