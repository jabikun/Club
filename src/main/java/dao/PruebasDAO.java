package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Pruebas;

@Repository
public interface PruebasDAO extends JpaRepository<Pruebas, Integer> {

}