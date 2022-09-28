package me.dio.ifood.sacola.api.assembler;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.request.ClienteInputRequest;
import me.dio.ifood.sacola.domain.model.Cliente;
import me.dio.ifood.sacola.domain.model.Endereco;

public class ClienteInputRequestDisassembler {
	
	public static Cliente toEntity(ClienteInputRequest input) {
		var entity = new Cliente();
		entity.setEndereco(new Endereco());
		BeanUtils.copyProperties(input.getEndereco(), entity.getEndereco());
		BeanUtils.copyProperties(input, entity);
		
		return entity;
	}
	
	public static void copyToEntity(ClienteInputRequest input, Cliente entity) {
		BeanUtils.copyProperties(input, entity);
	}
	
}
