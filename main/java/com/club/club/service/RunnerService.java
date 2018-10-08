package com.club.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.club.club.model.Runner;

public interface RunnerService {
	
	Runner create(Runner runner, Integer idClub);

	Optional<Runner> findById(Integer id);
	
	List<Runner> findAll(Pageable of, Integer club_id);

	void update(Integer id, Runner runnerToUpdate);

	void delete(Integer id);

}
