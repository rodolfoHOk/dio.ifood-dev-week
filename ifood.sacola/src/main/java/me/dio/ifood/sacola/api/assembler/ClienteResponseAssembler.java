package me.dio.ifood.sacola.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.response.ClienteResponse;
import me.dio.ifood.sacola.api.dto.response.EnderecoResponse;
import me.dio.ifood.sacola.domain.model.Cliente;

public class ClienteResponseAssembler {

	public static ClienteResponse toModel(Cliente entity) {
		var enderecoResponse = new EnderecoResponse();
		BeanUtils.copyProperties(entity.getEndereco(), enderecoResponse);
		
		var response = new ClienteResponse();
		BeanUtils.copyProperties(entity, response, "endereco");
		response.setEndereco(enderecoResponse);
		
		return response;
	}
	
	public static List<ClienteResponse> toCollectionModel(List<Cliente> entities) {
		return entities.stream()
				.map(cliente -> toModel(cliente))
				.collect(Collectors.toList());
	}
	
}
