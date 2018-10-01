package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Resultados;

@Repository
public interface ResultadosDAO extends JpaRepository<Resultados, Integer> {

}