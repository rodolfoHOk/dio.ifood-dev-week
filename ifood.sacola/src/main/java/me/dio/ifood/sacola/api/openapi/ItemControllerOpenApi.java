package me.dio.ifood.sacola.api.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.response.ItemResponse;

@Tag(name = "Items")
public interface ItemControllerOpenApi {

	@Operation(summary = "Busca item por ID")
	ItemResponse getbyId(Long id);

}