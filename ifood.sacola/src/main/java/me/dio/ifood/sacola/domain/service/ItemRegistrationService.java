package me.dio.ifood.sacola.domain.service;

import me.dio.ifood.sacola.domain.model.Item;

public interface ItemRegistrationService {

	Item getById(Long id);

	void remove(Long itemId);

}