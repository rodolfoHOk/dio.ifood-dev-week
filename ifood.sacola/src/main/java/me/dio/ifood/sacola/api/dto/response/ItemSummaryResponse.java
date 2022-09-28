package me.dio.ifood.sacola.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSummaryResponse {

	private Long id;
	
	private ProdutoSummaryResponse produto;
	
	private int quantidade;
	
}
