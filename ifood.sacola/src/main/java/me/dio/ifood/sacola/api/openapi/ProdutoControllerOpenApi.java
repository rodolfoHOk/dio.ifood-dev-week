package me.dio.ifood.sacola.api.openapi;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.request.ProdutoInputRequest;
import me.dio.ifood.sacola.api.dto.response.ProdutoResponse;

@Tag(name = "Produtos")
public interface ProdutoControllerOpenApi {
	
	@PageableAsQueryParam
	@Operation(summary = "Pesquisa produtos (nome & restauranteId)")
	Page<ProdutoResponse> search(String nome, Long restauranteId,@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Busca produto por ID")
	ProdutoResponse getById(Long id);

	@Operation(summary = "Cadastra novo produto")
	ProdutoResponse create(ProdutoInputRequest requestBody);

	@Operation(summary = "Atualiza produto por ID")
	ProdutoResponse update(Long id, ProdutoInputRequest requestBody);

	@Operation(summary = "Remove produto por ID")
	void delete(Long id);

}