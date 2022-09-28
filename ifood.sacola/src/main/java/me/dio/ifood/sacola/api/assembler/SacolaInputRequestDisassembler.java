package me.dio.ifood.sacola.api.assembler;

import org.springframework.beans.BeanUtils;

import me.dio.ifood.sacola.api.dto.request.SacolaInputRequest;
import me.dio.ifood.sacola.domain.model.Cliente;
import me.dio.ifood.sacola.domain.model.Sacola;

public class SacolaInputRequestDisassembler {

	public static Sacola toEntity(SacolaInputRequest input) {
		var entity = new Sacola();
		entity.setCliente(new Cliente());
		entity.getCliente().setId(input.getCliente().getId());
		
		return entity;
	}
	
	public static void copyToEntity(SacolaInputRequest input, Sacola entity) {
		BeanUtils.copyProperties(input, entity);
	}
	
}
