package me.dio.ifood.sacola.api.assembler;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.request.RestauranteInputRequest;
import me.dio.ifood.sacola.domain.model.Endereco;
import me.dio.ifood.sacola.domain.model.Restaurante;

public class RestauranteInputRequestDisassembler {
	
	public static Restaurante toEntity(RestauranteInputRequest input) {
		var entity = new Restaurante();
		entity.setEndereco(new Endereco());
		BeanUtils.copyProperties(input.getEndereco(), entity.getEndereco());
		BeanUtils.copyProperties(input, entity);
		
		return entity;
	}
	
	public static void copyToEntity(RestauranteInputRequest input, Restaurante entity) {
		BeanUtils.copyProperties(input, entity);
	}
	
}
