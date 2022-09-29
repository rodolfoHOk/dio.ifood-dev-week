package me.dio.ifood.sacola.domain.model;

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
@Entity(name = "items")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
	
	@Column(nullable = false)
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Sacola sacola;

}
