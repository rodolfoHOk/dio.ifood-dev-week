package me.dio.ifood.sacola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.response.ProdutoResponse;
import me.dio.ifood.sacola.api.dto.response.RestauranteSummaryResponse;
import me.dio.ifood.sacola.domain.model.Produto;

public class ProdutoResponseAssembler {

	public static ProdutoResponse toModel(Produto entity) {
		var restauranteResponse = new RestauranteSummaryResponse();
		BeanUtils.copyProperties(entity.getRestaurante(), restauranteResponse);
		
		var response = new ProdutoResponse();
		BeanUtils.copyProperties(entity, response, "restaurante");
		response.setRestaurante(restauranteResponse);
		
		return response;
	}
	
	public static List<ProdutoResponse> toCollectionModel(List<Produto> entities) {
		return entities.stream()
				.map(entity -> toModel(entity))
				.collect(Collectors.toList());
	}
	
}
