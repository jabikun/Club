package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Clubes;

@Repository
public interface ClubesDAO extends JpaRepository<Clubes, Integer> {

}