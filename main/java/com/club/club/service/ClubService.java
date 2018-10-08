package com.club.club.service;

import java.util.Optional;

import com.club.club.model.Club;

public interface ClubService {
	
	Club create(Club club);
	
	Optional<Club> findById(Integer id);

}
