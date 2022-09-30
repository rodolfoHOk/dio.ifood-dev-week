package me.dio.ifood.sacola.domain.service;

import me.dio.ifood.sacola.domain.model.Item;
import me.dio.ifood.sacola.domain.model.Sacola;

public interface SacolaRegistrationService {

	Sacola getById(Long id);

	Sacola save(Sacola sacola);

	void remove(Long sacolaId);

	Item addItem(Long sacolaId, Item item);

	void removeItem(Long sacolaId, Long itemId);

	void setFormaPagamento(Long sacolaId, String formaPagamentoString);

	Sacola closeSacola(Long sacolaId);

}