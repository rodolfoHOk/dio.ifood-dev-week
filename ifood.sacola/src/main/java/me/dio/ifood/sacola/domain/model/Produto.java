package me.dio.ifood.sacola.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "produtos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal valorUnitario;
	
	@Column(nullable = false)
	private Boolean disponivel = true;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurante restaurante;
	
}
