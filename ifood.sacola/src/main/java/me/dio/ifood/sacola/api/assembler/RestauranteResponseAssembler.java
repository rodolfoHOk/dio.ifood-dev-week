package me.dio.ifood.sacola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.response.EnderecoResponse;
import me.dio.ifood.sacola.api.dto.response.RestauranteResponse;
import me.dio.ifood.sacola.domain.model.Restaurante;

public class RestauranteResponseAssembler {

	public static RestauranteResponse toModel(Restaurante entity) {
		var enderecoResponse = new EnderecoResponse();
		BeanUtils.copyProperties(entity.getEndereco(), enderecoResponse);
		
		var response = new RestauranteResponse();
		BeanUtils.copyProperties(entity, response, "endereco");
		response.setEndereco(enderecoResponse);
		
		return response;
	}
	
	public static List<RestauranteResponse> toCollectionModel(List<Restaurante> entities) {
		return entities.stream()
				.map(entity -> toModel(entity))
				.collect(Collectors.toList());
	}
	
}
