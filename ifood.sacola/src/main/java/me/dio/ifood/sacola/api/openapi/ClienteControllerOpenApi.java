package me.dio.ifood.sacola.api.openapi;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.request.ClienteInputRequest;
import me.dio.ifood.sacola.api.dto.response.ClienteResponse;

@Tag(name = "Clientes")
public interface ClienteControllerOpenApi {
	
	@Operation(summary = "Pesquisa clientes (nome)")
	@PageableAsQueryParam
	Page<ClienteResponse> search(String nome,@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Busca cliente por ID")
	ClienteResponse getById(Long id);

	@Operation(summary = "Cadastra novo cliente")
	ClienteResponse create(ClienteInputRequest requestBody);

	@Operation(summary = "Atualiza cliente por ID")
	ClienteResponse update(Long id, ClienteInputRequest requestBody);

	@Operation(summary = "Remove cliente por ID")
	void delete(Long id);

}