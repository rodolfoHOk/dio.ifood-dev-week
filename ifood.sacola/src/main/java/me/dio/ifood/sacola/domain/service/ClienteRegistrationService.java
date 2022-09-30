package me.dio.ifood.sacola.domain.service;

import me.dio.ifood.sacola.domain.model.Cliente;

public interface ClienteRegistrationService {

	Cliente getById(Long id);

	Cliente save(Cliente cliente);

	void remove(Long clienteId);

}