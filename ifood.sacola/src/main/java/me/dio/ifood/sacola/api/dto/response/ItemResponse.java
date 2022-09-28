package me.dio.ifood.sacola.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse {

	private Long id;
	
	private ProdutoResponse produto;
	
	private int quantidade;
	
	private SacolaIdResponse sacola;
	
}
