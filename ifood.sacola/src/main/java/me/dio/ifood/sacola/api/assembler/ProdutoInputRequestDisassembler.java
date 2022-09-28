package me.dio.ifood.sacola.api.assembler;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.request.ProdutoInputRequest;
import me.dio.ifood.sacola.domain.model.Produto;
import me.dio.ifood.sacola.domain.model.Restaurante;

public class ProdutoInputRequestDisassembler {
	
	public static Produto toEntity(ProdutoInputRequest input) {		
		var entity = new Produto();
		entity.setRestaurante(new Restaurante());
		BeanUtils.copyProperties(input.getRestaurante(), entity.getRestaurante());
		BeanUtils.copyProperties(input, entity);
		
		return entity;
	}
	
	public static void copyToEntity(ProdutoInputRequest input, Produto entity) {
		BeanUtils.copyProperties(input, entity);
	}	
	
}
