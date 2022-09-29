package me.dio.ifood.sacola.api.openapi;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.request.FormaPagamentoInputRequest;
import me.dio.ifood.sacola.api.dto.request.ItemInputRequest;
import me.dio.ifood.sacola.api.dto.request.SacolaInputRequest;
import me.dio.ifood.sacola.api.dto.response.ItemResponse;
import me.dio.ifood.sacola.api.dto.response.SacolaResponse;

@Tag(name = "Sacolas")
public interface SacolaControllerOpenApi {

	@Operation(summary = "Lista as sacolas")
	List<SacolaResponse> getAll();

	@Operation(summary = "Busca sacola por ID")
	SacolaResponse getbyId(Long id);

	@Operation(summary = "Cadastra nova sacola")
	SacolaResponse create(SacolaInputRequest requestBody);

	@Operation(summary = "Remove sacola por ID")
	void delete(Long id);

	@Operation(summary = "Adiciona item a sacola")
	ItemResponse addItem(Long id, ItemInputRequest requestBody);

	@Operation(summary = "Remove item da sacola")
	void removeItem(Long id, Long itemId);

	@Operation(summary = "Define forma de pagamento a sacola")
	void setFormaPagamento(Long id, FormaPagamentoInputRequest requestBody);

	@Operation(summary = "Fecha a sacola")
	SacolaResponse closeSacola(Long id);

}