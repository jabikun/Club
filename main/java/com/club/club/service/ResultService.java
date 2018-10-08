package com.club.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.club.club.model.Result;

public interface ResultService {
	
	Result create(Result result, Integer idTrial);

	Optional<Result> findById(Integer id);

	List<Result> BestClubs(Pageable of, Integer id);
	
	List<Result> BestAges(Pageable of, Integer id);

}
