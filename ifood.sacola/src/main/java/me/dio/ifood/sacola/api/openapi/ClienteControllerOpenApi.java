package me.dio.ifood.sacola.api.openapi;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.request.ClienteInputRequest;
import me.dio.ifood.sacola.api.dto.response.ClienteResponse;

@Tag(name = "Clientes")
public interface ClienteControllerOpenApi {
	
	@Operation(summary = "Pesquisa clientes (nome)")
	List<ClienteResponse> search(String nome);

	@Operation(summary = "Busca cliente por ID")
	ClienteResponse getById(Long id);

	@Operation(summary = "Cadastra novo cliente")
	ClienteResponse create(ClienteInputRequest requestBody);

	@Operation(summary = "Atualiza cliente por ID")
	ClienteResponse update(Long id, ClienteInputRequest requestBody);

	@Operation(summary = "Remove cliente por ID")
	void delete(Long id);

}