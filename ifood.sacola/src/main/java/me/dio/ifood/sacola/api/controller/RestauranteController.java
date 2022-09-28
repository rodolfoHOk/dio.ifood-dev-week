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
import me.dio.ifood.sacola.api.assembler.ProdutoBasicResponseAssembler;
import me.dio.ifood.sacola.api.assembler.RestauranteInputRequestDisassembler;
import me.dio.ifood.sacola.api.assembler.RestauranteResponseAssembler;
import me.dio.ifood.sacola.api.dto.request.RestauranteInputRequest;
import me.dio.ifood.sacola.api.dto.response.ProdutoBasicResponse;
import me.dio.ifood.sacola.api.dto.response.RestauranteResponse;
import me.dio.ifood.sacola.domain.irepository.RestauranteRepository;
import me.dio.ifood.sacola.domain.model.Produto;
import me.dio.ifood.sacola.domain.model.Restaurante;
import me.dio.ifood.sacola.domain.service.RestauranteRegistrationService;

@RestController
@RequestMapping("/api/v1/restaurantes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestauranteController {

	private final RestauranteRepository repository;
	private final RestauranteRegistrationService service;
	
	@GetMapping
	public List<RestauranteResponse> getAll() {
		List<Restaurante> entities = repository.findAll();
		return RestauranteResponseAssembler.toCollectionModel(entities);
	}
	
	@GetMapping("/{id}")
	public RestauranteResponse getById(@PathVariable Long id) {
		Restaurante entity = service.getById(id);
		return RestauranteResponseAssembler.toModel(entity);
	}
	
	@GetMapping("/{id}/produtos")
	public List<ProdutoBasicResponse> getCardadio(@PathVariable Long id) {
		List<Produto> produtos = service.getCardapio(id);
		return ProdutoBasicResponseAssembler.toCollectionModel(produtos);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RestauranteResponse create(@RequestBody RestauranteInputRequest requestBody) {
		Restaurante newEntity = RestauranteInputRequestDisassembler.toEntity(requestBody);
		Restaurante savedEntity = service.save(newEntity);
		return RestauranteResponseAssembler.toModel(savedEntity);
	}
	
	@PutMapping("/{id}")
	public RestauranteResponse update(@PathVariable Long id, @RequestBody RestauranteInputRequest requestBody) {
		Restaurante existingEntity = service.getById(id);
		RestauranteInputRequestDisassembler.copyToEntity(requestBody, existingEntity);
		Restaurante updatedEntity = service.save(existingEntity);
		return RestauranteResponseAssembler.toModel(updatedEntity);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.remove(id);
	}
	
}
