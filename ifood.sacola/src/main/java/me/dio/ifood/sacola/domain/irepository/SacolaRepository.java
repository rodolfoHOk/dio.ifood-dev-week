package me.dio.ifood.sacola.domain.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.ifood.sacola.domain.model.Sacola;

@Repository
public interface SacolaRepository extends JpaRepository<Sacola, Long> {

}
