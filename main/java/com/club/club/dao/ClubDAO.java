package com.club.club.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.club.model.Club;

@Repository
public interface ClubDAO extends JpaRepository<Club, Integer>{

}
