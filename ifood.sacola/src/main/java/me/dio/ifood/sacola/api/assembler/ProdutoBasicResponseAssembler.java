package me.dio.ifood.sacola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.response.ProdutoBasicResponse;
import me.dio.ifood.sacola.domain.model.Produto;

public class ProdutoBasicResponseAssembler {

	public static ProdutoBasicResponse toModel(Produto entity) {
		var response = new ProdutoBasicResponse();
		BeanUtils.copyProperties(entity, response);
		
		return response;
	}
	
	public static List<ProdutoBasicResponse> toCollectionModel(List<Produto> entities) {
		return entities.stream()
				.map(entity -> toModel(entity))
				.collect(Collectors.toList());
	}
}
