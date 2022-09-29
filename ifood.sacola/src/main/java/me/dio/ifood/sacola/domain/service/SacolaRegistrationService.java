package me.dio.ifood.sacola.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.domain.enumeration.FormaPagamento;
import me.dio.ifood.sacola.domain.exception.BusinessException;
import me.dio.ifood.sacola.domain.exception.EntityInUseException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;
import me.dio.ifood.sacola.domain.irepository.SacolaRepository;
import me.dio.ifood.sacola.domain.model.Cliente;
import me.dio.ifood.sacola.domain.model.Item;
import me.dio.ifood.sacola.domain.model.Produto;
import me.dio.ifood.sacola.domain.model.Restaurante;
import me.dio.ifood.sacola.domain.model.Sacola;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SacolaRegistrationService {

	private final SacolaRepository repository;
	private final ClienteRegistrationService clienteRegistrationService;
	private final ProdutoRegistrationService produtoRegistrationService;
	private final ItemRegistrationService itemRegistrationService;
	
	public Sacola getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sacola não encontrado com o id: " + id));
	}
	
	@Transactional
	public Sacola save(Sacola sacola) {
		Cliente cliente = clienteRegistrationService.getById(sacola.getCliente().getId());
		sacola.setCliente(cliente);
		return repository.save(sacola);
	}
	
	@Transactional
	public void remove(Long sacolaId) {
		try {
			repository.deleteById(sacolaId);
			repository.flush();
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Sacola não encontrado com o id: " + sacolaId);
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException("Sacola está em uso e não pode ser removido");
		}
	}
	
	@Transactional
	public Item addItem(Long sacolaId, Item item) {
		Produto produto = produtoRegistrationService.getById(item.getProduto().getId());
		item.setProduto(produto);
		Sacola sacola = getById(sacolaId);
		item.setSacola(sacola);
		if (sacola.getItensSacola().isEmpty()) {
			sacola.addItem(item);
			return item;
		} else {
			Restaurante restauranteItemExistente = sacola.getItensSacola().get(0).getProduto().getRestaurante();
			Restaurante restauranteNovoItem = item.getProduto().getRestaurante();
			if (restauranteItemExistente.equals(restauranteNovoItem)) {
				sacola.addItem(item);
				return item;
			} else {
				throw new BusinessException("Não é possível adicionar a sacola produtos de restaurantes diferentes. Feche a sacola ou esvazie.");
			}
		}
	}
	
	@Transactional
	public void removeItem(Long sacolaId, Long itemId) {
		Item item = itemRegistrationService.getById(itemId);
		Sacola sacola = getById(sacolaId);
		itemRegistrationService.remove(itemId);
		sacola.removeItem(item);
	}
	
	@Transactional
	public void setFormaPagamento(Long sacolaId, String formaPagamentoString) {
		try {
			Sacola sacola = getById(sacolaId);
			FormaPagamento formaPagamento = FormaPagamento.valueOf(formaPagamentoString);
			sacola.setFormaPagamento(formaPagamento);
		} catch (IllegalArgumentException ex) {
			throw new BusinessException(formaPagamentoString + " não é uma forma de pagamento válida.");
		}
	}
	
	@Transactional
	public Sacola closeSacola(Long sacolaId) {
		Sacola sacola = getById(sacolaId);
		sacola.closeSacola();
		return sacola;
	}
	
}
