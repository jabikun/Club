package com.club.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.club.model.Runner;

@Repository
public interface RunnerDAO extends JpaRepository<Runner, Integer>{
	
	List<Runner> findAllByOrderByIdAsc();

}
