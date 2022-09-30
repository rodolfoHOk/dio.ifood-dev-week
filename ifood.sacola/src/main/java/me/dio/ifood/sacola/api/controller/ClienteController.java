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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.api.assembler.ClienteInputRequestDisassembler;
import me.dio.ifood.sacola.api.assembler.ClienteResponseAssembler;
import me.dio.ifood.sacola.api.dto.request.ClienteInputRequest;
import me.dio.ifood.sacola.api.dto.response.ClienteResponse;
import me.dio.ifood.sacola.api.openapi.ClienteControllerOpenApi;
import me.dio.ifood.sacola.domain.irepository.ClienteRepository;
import me.dio.ifood.sacola.domain.model.Cliente;
import me.dio.ifood.sacola.domain.service.ClienteRegistrationService;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController implements ClienteControllerOpenApi {

	private final ClienteRepository repository;
	private final ClienteRegistrationService service;
	
	@Override
	@GetMapping
	public List<ClienteResponse> search(@RequestParam(required = false) String nome) {
		List<Cliente> entities;
		if (nome == null) {
			entities = repository.findAll();
		} else {
			entities = repository.findByNomeContainingIgnoreCase(nome);
		}
		return ClienteResponseAssembler.toCollectionModel(entities);
	}
	
	@Override
	@GetMapping("/{id}")
	public ClienteResponse getById(@PathVariable Long id) {
		Cliente entity = service.getById(id);
		return ClienteResponseAssembler.toModel(entity);
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse create(@RequestBody ClienteInputRequest requestBody) {
		Cliente newEntity = ClienteInputRequestDisassembler.toEntity(requestBody);
		Cliente savedEntity = service.save(newEntity);
		return ClienteResponseAssembler.toModel(savedEntity);
	}
	
	@Override
	@PutMapping("/{id}")
	public ClienteResponse update(@PathVariable Long id, @RequestBody ClienteInputRequest requestBody) {
		Cliente existingEntity = service.getById(id);
		ClienteInputRequestDisassembler.copyToEntity(requestBody, existingEntity);
		Cliente updatedEntity = service.save(existingEntity);
		return ClienteResponseAssembler.toModel(updatedEntity);
	}
	
	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.remove(id);
	}
	
}
