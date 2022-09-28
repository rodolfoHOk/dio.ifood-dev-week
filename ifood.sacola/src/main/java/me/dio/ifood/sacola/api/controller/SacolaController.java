package me.dio.ifood.sacola.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.api.assembler.ItemInputRequestDisassembler;
import me.dio.ifood.sacola.api.assembler.SacolaInputRequestDisassembler;
import me.dio.ifood.sacola.api.assembler.SacolaResponseAssembler;
import me.dio.ifood.sacola.api.dto.request.FormaPagamentoInputRequest;
import me.dio.ifood.sacola.api.dto.request.ItemInputRequest;
import me.dio.ifood.sacola.api.dto.request.SacolaInputRequest;
import me.dio.ifood.sacola.api.dto.response.SacolaResponse;
import me.dio.ifood.sacola.domain.exception.BadRequestException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;
import me.dio.ifood.sacola.domain.irepository.SacolaRepository;
import me.dio.ifood.sacola.domain.model.Item;
import me.dio.ifood.sacola.domain.model.Sacola;
import me.dio.ifood.sacola.domain.service.SacolaRegistrationService;

@RestController
@RequestMapping("/api/v1/sacolas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SacolaController {

	private final SacolaRepository repository;
	private final SacolaRegistrationService service;
	
	@GetMapping
	public List<SacolaResponse>	getAll() {
		List<Sacola> entities = repository.findAll();
		return SacolaResponseAssembler.toCollectionModel(entities);
	}
	
	@GetMapping("/{id}")
	public SacolaResponse getbyId(@PathVariable Long id) {
		Sacola entity = service.getById(id);
		return SacolaResponseAssembler.toModel(entity);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SacolaResponse create(@RequestBody SacolaInputRequest requestBody) {
		try {
			Sacola newEntity = SacolaInputRequestDisassembler.toEntity(requestBody);
			Sacola createdEntity = service.save(newEntity);
			return SacolaResponseAssembler.toModel(createdEntity);
		} catch (ResourceNotFoundException ex) {
			throw new BadRequestException(ex.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.remove(id);
	}
	
	@PatchMapping("/{id}/adiciona-item")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable Long id, @RequestBody ItemInputRequest requestBody) {
		Item item = ItemInputRequestDisassembler.toEntity(requestBody);
		try {
			service.addItem(id, item);
		} catch (ResourceNotFoundException ex) {
			throw new BadRequestException(ex.getMessage());
		}
	}
	
	@DeleteMapping("/{id}/remove-item/{itemId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable Long id, @PathVariable Long itemId) {
		try {
			service.removeItem(id, itemId);
		} catch (ResourceNotFoundException ex) {
			throw new BadRequestException(ex.getMessage());
		}
	}
	
	@PatchMapping("/{id}/forma-pagamento")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void setFormaPagamento(@PathVariable Long id, @RequestBody FormaPagamentoInputRequest requestBody) {
		try {
			service.setFormaPagamento(id, requestBody.getFormaPagamento());
		} catch (ResourceNotFoundException ex) {
			throw new BadRequestException(ex.getMessage());
		}
	}
	
	@PatchMapping("/{id}/fechamento")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void closeSacola(@PathVariable Long id) {
		try {
			service.closeSacola(id);
		} catch (ResourceNotFoundException ex) {
			throw new BadRequestException(ex.getMessage());
		}
	}
	
}