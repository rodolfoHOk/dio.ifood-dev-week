package me.dio.ifood.sacola.api.dto.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import me.dio.ifood.sacola.domain.enumeration.FormaPagamento;

@Getter
@Setter
public class SacolaResponse {

	private Long id;
	
	private ClienteIdResponse cliente;
	
	private List<ItemSummaryResponse> itensSacola;
	
	private BigDecimal valorTotalSacola;
	
	private FormaPagamento formaPagamento;
	
	private boolean fechada;
	
	private OffsetDateTime dataFechamento;
	
}
