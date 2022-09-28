package me.dio.ifood.sacola.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.domain.exception.EntityInUseException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;
import me.dio.ifood.sacola.domain.irepository.ClienteRepository;
import me.dio.ifood.sacola.domain.model.Cliente;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteRegistrationService {

	private final ClienteRepository repository;
	
	public Cliente getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o id: " + id));
	}
	
	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}
	
	@Transactional
	public void remove(Long clienteId) {
		try {
			repository.deleteById(clienteId);
			repository.flush();
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Cliente não encontrado com o id: " + clienteId);
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException("Cliente está em uso e não pode ser removido");
		}
	}	
	
}
