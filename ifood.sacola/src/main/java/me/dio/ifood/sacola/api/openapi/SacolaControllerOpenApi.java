package me.dio.ifood.sacola.api.openapi;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.ifood.sacola.api.dto.request.FormaPagamentoInputRequest;
import me.dio.ifood.sacola.api.dto.request.ItemInputRequest;
import me.dio.ifood.sacola.api.dto.request.SacolaInputRequest;
import me.dio.ifood.sacola.api.dto.response.ItemResponse;
import me.dio.ifood.sacola.api.dto.response.SacolaResponse;

@Tag(name = "Sacolas")
public interface SacolaControllerOpenApi {

	@PageableAsQueryParam
	@Operation(summary = "Lista as sacolas")
	Page<SacolaResponse> getAll(@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Busca sacola por ID")
	SacolaResponse getbyId(Long id);
	
	@PageableAsQueryParam
	@Operation(summary = "Busca sacolas pelo cliente ID")
	Page<SacolaResponse> getbyClienteId(Long clienteId, @Parameter(hidden = true) Pageable pageable);

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