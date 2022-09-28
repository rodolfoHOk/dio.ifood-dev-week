package me.dio.ifood.sacola.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.domain.exception.EntityInUseException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;
import me.dio.ifood.sacola.domain.irepository.ItemRepository;
import me.dio.ifood.sacola.domain.model.Item;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemRegistrationService {

	private final ItemRepository repository;
	
	public Item getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item não encontrado com o id: " + id));
	}
	
//	@Transactional
//	public Item save(Item item) { // Persiste pela SacolaRegistrationService | Sacola itensSacola cascade all
//		Produto produto = produtoRegistrationService.getById(item.getProduto().getId());
//		item.setProduto(produto);
//		Sacola sacola = sacolaRegistrationService.getById(item.getSacola().getId());
//		item.setSacola(sacola);
//		return repository.save(item);
//	}

	@Transactional
	public void remove(Long itemId) { // Remove pela SacolaRegistrationService | Sacola itensSacola cascade all
		try {
			repository.deleteById(itemId);
			repository.flush();
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Item não encontrado com o id: " + itemId);
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException("Item está em uso e não pode ser removido");
		}
	}
	
}