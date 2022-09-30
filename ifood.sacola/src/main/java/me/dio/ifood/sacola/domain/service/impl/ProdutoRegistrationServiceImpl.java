package me.dio.ifood.sacola.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.domain.exception.EntityInUseException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;
import me.dio.ifood.sacola.domain.irepository.ProdutoRepository;
import me.dio.ifood.sacola.domain.model.Produto;
import me.dio.ifood.sacola.domain.model.Restaurante;
import me.dio.ifood.sacola.domain.service.ProdutoRegistrationService;
import me.dio.ifood.sacola.domain.service.RestauranteRegistrationService;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoRegistrationServiceImpl implements ProdutoRegistrationService {

	private final ProdutoRepository repository;
	private final RestauranteRegistrationService restauranteRegistrationService;
	
	@Override
	public Produto getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o id: " + id));
	}
	
	@Override
	@Transactional
	public Produto save(Produto produto) {
		Restaurante restaurante = restauranteRegistrationService.getById(produto.getRestaurante().getId());
		produto.setRestaurante(restaurante);
		return repository.save(produto);
	}
	
	@Override
	@Transactional
	public void remove(Long produtoId) {
		try {
			repository.deleteById(produtoId);
			repository.flush();
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Produto não encontrado com o id: " + produtoId);
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException("Produto está em uso e não pode ser removido");
		}
	}
	
}
