package me.dio.ifood.sacola.api.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoIdInputRequest {

	@NotNull
	private Long id;
	
}
