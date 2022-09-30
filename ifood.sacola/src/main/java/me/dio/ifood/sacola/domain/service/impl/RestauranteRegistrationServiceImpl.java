package me.dio.ifood.sacola.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.domain.exception.EntityInUseException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;
import me.dio.ifood.sacola.domain.irepository.RestauranteRepository;
import me.dio.ifood.sacola.domain.model.Produto;
import me.dio.ifood.sacola.domain.model.Restaurante;
import me.dio.ifood.sacola.domain.service.RestauranteRegistrationService;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestauranteRegistrationServiceImpl implements RestauranteRegistrationService {
	
private final RestauranteRepository repository;
	
	@Override
	public Restaurante getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado com o id: " + id));
	}
	
	@Override
	public List<Produto> getCardapio(Long restauranteId) {
		Restaurante restaurante = getById(restauranteId);
		List<Produto> produtos = restaurante.getCardapio();
		return produtos;
	}
	
	@Override
	@Transactional
	public Restaurante save(Restaurante restaurante) {
		return repository.save(restaurante);
	}
	
	@Override
	@Transactional
	public void remove(Long restauranteId) {
		try {
			repository.deleteById(restauranteId);
			repository.flush();
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Restaurante não encontrado com o id: " + restauranteId);
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException("Restaurante está em uso e não pode ser removido");
		}
	}
	
}
