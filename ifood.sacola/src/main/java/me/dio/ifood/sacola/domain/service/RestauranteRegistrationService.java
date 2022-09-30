package me.dio.ifood.sacola.domain.service;

import java.util.List;

import me.dio.ifood.sacola.domain.model.Produto;
import me.dio.ifood.sacola.domain.model.Restaurante;

public interface RestauranteRegistrationService {

	Restaurante getById(Long id);

	List<Produto> getCardapio(Long restauranteId);

	Restaurante save(Restaurante restaurante);

	void remove(Long restauranteId);

}