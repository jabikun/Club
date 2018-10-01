package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Corredores;

@Repository
public interface CorredoresDAO extends JpaRepository<Corredores, Integer> {

}