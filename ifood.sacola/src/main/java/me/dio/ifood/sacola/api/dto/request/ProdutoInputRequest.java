package me.dio.ifood.sacola.api.dto.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInputRequest {

	@NotBlank
	@Size(max = 150)
	private String nome;
	
	@NotNull
	@PositiveOrZero
	private BigDecimal valorUnitario;
	
	@NotNull
	private Boolean disponivel;
	
	@Valid
	@NotNull
	private RestauranteIdInputRequest restaurante;
	
}
