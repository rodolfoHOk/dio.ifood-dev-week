	package me.dio.ifood.sacola.api.openapi;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.request.RestauranteInputRequest;
import me.dio.ifood.sacola.api.dto.response.ProdutoBasicResponse;
import me.dio.ifood.sacola.api.dto.response.RestauranteResponse;

@Tag(name = "Restaurantes")
public interface RestauranteControllerOpenApi {

	@Operation(summary = "Lista os restaurantes")
	List<RestauranteResponse> getAll();

	@Operation(summary = "Busca restaurante por ID")
	RestauranteResponse getById(Long id);

	@Operation(summary = "Lista produtos do restaurante")
	List<ProdutoBasicResponse> getCardadio(Long id);

	@Operation(summary = "Cadastra novo restaurante")
	RestauranteResponse create(RestauranteInputRequest requestBody);

	@Operation(summary = "Atualiza restaurante por ID")
	RestauranteResponse update(Long id, RestauranteInputRequest requestBody);

	@Operation(summary = "Remove restaurante por ID")
	void delete(Long id);

}