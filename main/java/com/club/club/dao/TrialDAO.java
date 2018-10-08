package com.club.club.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.club.model.Trial;

@Repository
public interface TrialDAO extends JpaRepository<Trial, Integer>{
	
}
