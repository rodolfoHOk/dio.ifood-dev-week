package me.dio.ifood.sacola.api.openapi;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.request.ProdutoInputRequest;
import me.dio.ifood.sacola.api.dto.response.ProdutoResponse;

@Tag(name = "Produtos")
public interface ProdutoControllerOpenApi {
	
	@Operation(summary = "Pesquisa produtos (nome & restauranteId)")
	List<ProdutoResponse> search(String nome, Long restauranteId);

	@Operation(summary = "Busca produto por ID")
	ProdutoResponse getById(Long id);

	@Operation(summary = "Cadastra novo produto")
	ProdutoResponse create(ProdutoInputRequest requestBody);

	@Operation(summary = "Atualiza produto por ID")
	ProdutoResponse update(Long id, ProdutoInputRequest requestBody);

	@Operation(summary = "Remove produto por ID")
	void delete(Long id);

}