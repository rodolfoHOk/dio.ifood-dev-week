package me.dio.ifood.sacola.domain.service;

import me.dio.ifood.sacola.domain.model.Produto;

public interface ProdutoRegistrationService {

	Produto getById(Long id);

	Produto save(Produto produto);

	void remove(Long produtoId);

}