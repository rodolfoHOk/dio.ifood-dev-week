package me.dio.ifood.sacola.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.api.assembler.ProdutoInputRequestDisassembler;
import me.dio.ifood.sacola.api.assembler.ProdutoResponseAssembler;
import me.dio.ifood.sacola.api.dto.request.ProdutoInputRequest;
import me.dio.ifood.sacola.api.dto.response.ProdutoResponse;
import me.dio.ifood.sacola.api.openapi.ProdutoControllerOpenApi;
import me.dio.ifood.sacola.domain.exception.BadRequestException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;
import me.dio.ifood.sacola.domain.irepository.ProdutoRepository;
import me.dio.ifood.sacola.domain.model.Produto;
import me.dio.ifood.sacola.domain.service.ProdutoRegistrationService;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController implements ProdutoControllerOpenApi {

	private final ProdutoRepository repository;
	private final ProdutoRegistrationService service;
	
	@Override
	@GetMapping
	public List<ProdutoResponse> getAll() {
		List<Produto> entities = repository.findAll();
		return ProdutoResponseAssembler.toCollectionModel(entities);
	}
	
	@Override
	@GetMapping("/{id}")
	public ProdutoResponse getById(@PathVariable Long id) {
		Produto entity = service.getById(id);
		return ProdutoResponseAssembler.toModel(entity);
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoResponse create(@RequestBody ProdutoInputRequest requestBody) {
		try {
			Produto newEntity = ProdutoInputRequestDisassembler.toEntity(requestBody);
			Produto savedEntity = service.save(newEntity);
			return ProdutoResponseAssembler.toModel(savedEntity);
		} catch (ResourceNotFoundException ex) {
			throw new BadRequestException(ex.getMessage());
		}
	}
	
	@Override
	@PutMapping("/{id}")
	public ProdutoResponse update(@PathVariable Long id, @RequestBody ProdutoInputRequest requestBody) {
		try {
			Produto existingEntity = service.getById(id);
			ProdutoInputRequestDisassembler.copyToEntity(requestBody, existingEntity);
			Produto updatedEntity = service.save(existingEntity);
			return ProdutoResponseAssembler.toModel(updatedEntity);
		} catch (ResourceNotFoundException ex) {
			throw new BadRequestException(ex.getMessage());
		}
	}
	
	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.remove(id);
	}
	
}
