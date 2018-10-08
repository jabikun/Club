package com.club.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.club.model.Result;

@Repository
public interface ResultDAO extends JpaRepository<Result, Integer>{
	
	//Query de mejores de una prueba
	List<Result> findAllByOrderBySecondsAsc();
	
}
