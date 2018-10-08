package com.club.club.service;

import java.util.Optional;

import com.club.club.model.Trial;

public interface TrialService {
	
	Trial create(Trial trial);
	
	Optional<Trial> findById(Integer id);


}
