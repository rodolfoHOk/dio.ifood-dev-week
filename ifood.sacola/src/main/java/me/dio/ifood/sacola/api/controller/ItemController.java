package me.dio.ifood.sacola.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.sacola.api.assembler.ItemResponseAssembler;
import me.dio.ifood.sacola.api.dto.response.ItemResponse;
import me.dio.ifood.sacola.api.openapi.ItemControllerOpenApi;
import me.dio.ifood.sacola.domain.model.Item;
import me.dio.ifood.sacola.domain.service.ItemRegistrationService;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemController implements ItemControllerOpenApi {
	
	private final ItemRegistrationService service;
	
	@Override
	@GetMapping("/{id}")
	public ItemResponse getbyId(@PathVariable Long id) {
		Item entity = service.getById(id);
		return ItemResponseAssembler.toModel(entity);
	}
	
}
