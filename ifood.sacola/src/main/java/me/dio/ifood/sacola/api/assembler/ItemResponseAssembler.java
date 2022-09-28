package me.dio.ifood.sacola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.response.ItemResponse;
import me.dio.ifood.sacola.api.dto.response.ProdutoResponse;
import me.dio.ifood.sacola.api.dto.response.RestauranteSummaryResponse;
import me.dio.ifood.sacola.api.dto.response.SacolaIdResponse;
import me.dio.ifood.sacola.domain.model.Item;

public class ItemResponseAssembler {

	public static ItemResponse toModel(Item entity) {
		var restaurante = new RestauranteSummaryResponse();
		BeanUtils.copyProperties(entity.getProduto().getRestaurante(), restaurante);
		
		var produto = new ProdutoResponse();
		BeanUtils.copyProperties(entity.getProduto(), produto, "restaurante");
		produto.setRestaurante(restaurante);
		
		var sacola = new SacolaIdResponse();
		sacola.setId(entity.getSacola().getId());
		
		var response = new ItemResponse();
		BeanUtils.copyProperties(entity, response, "sacola", "produto");
		response.setSacola(sacola);
		response.setProduto(produto);
		
		return response;
	}
	
	public static List<ItemResponse> toCollectionModel(List<Item> entities) {
		return entities.stream()
				.map(entity -> toModel(entity))
				.collect(Collectors.toList());
	}
	
}
