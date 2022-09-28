package me.dio.ifood.sacola.api.assembler;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.request.ItemInputRequest;
import me.dio.ifood.sacola.domain.model.Item;
import me.dio.ifood.sacola.domain.model.Produto;

public class ItemInputRequestDisassembler {

	public static Item toEntity(ItemInputRequest input) {
		var entity = new Item();
		entity.setProduto(new Produto());
		BeanUtils.copyProperties(input.getProduto(), entity.getProduto());
		BeanUtils.copyProperties(input, entity);
		
		return entity;
	}
	
	public static void copyToEntity(ItemInputRequest input, Item entity) {
		BeanUtils.copyProperties(input, entity);
	}
	
}
