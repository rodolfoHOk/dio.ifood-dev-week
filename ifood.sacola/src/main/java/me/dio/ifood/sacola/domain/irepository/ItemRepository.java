package me.dio.ifood.sacola.domain.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.ifood.sacola.domain.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
