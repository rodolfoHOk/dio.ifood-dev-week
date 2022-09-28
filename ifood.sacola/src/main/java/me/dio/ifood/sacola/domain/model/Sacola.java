package me.dio.ifood.sacola.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.dio.ifood.sacola.domain.enumeration.FormaPagamento;
import me.dio.ifood.sacola.domain.exception.BusinessException;

@Getter
@Setter
@Entity(name = "sacolas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sacola {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "sacola", cascade = CascadeType.ALL)
	private List<Item> itensSacola = new ArrayList<>();
	
	@Column(nullable = false)
	private BigDecimal valorTotalSacola = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	@Setter(value = AccessLevel.NONE)
	private FormaPagamento formaPagamento = FormaPagamento.INDEFINIDO;
	
	@Column(nullable = false)
	private boolean fechada = false;
	
	private OffsetDateTime dataFechamento;
	
	public void addItem(Item item) {
		if (!this.fechada) {
			this.itensSacola.add(item);
			this.valorTotalSacola = valorTotalSacola
					.add(new BigDecimal(item.getQuantidade())
							.multiply(item.getProduto().getValorUnitario()));
		} else {
			throw new BusinessException("Sacola já foi fechada");
		}
	}
	
	public void removeItem(Item item) {
		if (!this.fechada) {
			this.itensSacola.remove(item);
			this.valorTotalSacola = valorTotalSacola
					.subtract(new BigDecimal(item.getQuantidade())
							.multiply(item.getProduto().getValorUnitario()));
		} else {
			throw new BusinessException("Sacola já foi fechada");
		}
	}
	
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		if (!this.fechada) {
			this.formaPagamento = formaPagamento;
		} else {
			throw new BusinessException("Sacola já foi fechada");
		}
	}
	
	public void closeSacola() {
		if (!this.fechada) {
			if (formaPagamento.equals(FormaPagamento.INDEFINIDO)) {
				throw new BusinessException("Forma de pagamento não foi definida");
			}
			this.dataFechamento = OffsetDateTime.now();
			this.fechada = true;
		} else {
			throw new BusinessException("Sacola já foi fechada");
		}
	}
	
}
