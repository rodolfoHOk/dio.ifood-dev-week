package me.dio.ifood.sacola.domain.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.ifood.sacola.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByNomeContainingIgnoreCase(String nome);
	
	List<Produto> findByNomeContainingIgnoreCaseAndRestauranteId(String nome, Long restauranteId);
	
}
