package me.dio.ifood.sacola.api.dto.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponse {

	private Long id;
	
	private String nome;
	
	private BigDecimal valorUnitario;
	
	private Boolean disponivel = true;
	
	private RestauranteSummaryResponse restaurante;
	
}
