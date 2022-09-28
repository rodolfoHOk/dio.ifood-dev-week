package me.dio.ifood.sacola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.response.ClienteIdResponse;
import me.dio.ifood.sacola.api.dto.response.ItemSummaryResponse;
import me.dio.ifood.sacola.api.dto.response.ProdutoSummaryResponse;
import me.dio.ifood.sacola.api.dto.response.RestauranteSummaryResponse;
import me.dio.ifood.sacola.api.dto.response.SacolaResponse;
import me.dio.ifood.sacola.domain.model.Sacola;

public class SacolaResponseAssembler {

	public static SacolaResponse toModel(Sacola entity) {
		var cliente = new ClienteIdResponse();
		cliente.setId(entity.getCliente().getId());
		
		List<ItemSummaryResponse> itensSacola = entity.getItensSacola().stream()
				.map(item -> {
					var restaurante = new RestauranteSummaryResponse();
					BeanUtils.copyProperties(item.getProduto().getRestaurante(), restaurante);
					
					var produto = new ProdutoSummaryResponse();
					BeanUtils.copyProperties(item.getProduto(), produto, "restaurante");
					produto.setRestaurante(restaurante);
					
					var itemResponse = new ItemSummaryResponse();
					BeanUtils.copyProperties(item, itemResponse, "produto");
					itemResponse.setProduto(produto);
					
					return itemResponse;
				}).collect(Collectors.toList());
			
		var response = new SacolaResponse();
		BeanUtils.copyProperties(entity, response, "cliente", "itensSacola");
		response.setCliente(cliente);
		response.setItensSacola(itensSacola);
		
		return response;
	}
	
	public static List<SacolaResponse> toCollectionModel(List<Sacola> entities) {
		return entities.stream()
				.map(entity -> toModel(entity))
				.collect(Collectors.toList());
	}
	
}
