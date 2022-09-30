package me.dio.ifood.sacola.domain.irepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.ifood.sacola.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	
	Page<Produto> findByNomeContainingIgnoreCaseAndRestauranteId(String nome, Long restauranteId, Pageable pageable);
	
}
