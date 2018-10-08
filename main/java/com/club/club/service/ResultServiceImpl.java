package com.club.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.club.club.dao.ResultDAO;
import com.club.club.model.Result;
import com.club.club.model.Trial;

@Service
public class ResultServiceImpl implements ResultService{
	
	@Autowired
	ResultDAO resultDAO;
	
	@Autowired
	TrialService trialService;

	@Override
	public Result create(Result result, Integer idTrial) {
		final Optional<Trial> trial = trialService.findById(idTrial);
		result.setTrial(trial.get());
		return resultDAO.save(result);
	}

	@Override
	public Optional<Result> findById(Integer id) {
		return resultDAO.findById(id);
	}

	@Override
	public List<Result> BestClubs(Pageable of, Integer id) {
		// ALGORITMO COMPLEJO
		return resultDAO.findAllByOrderBySecondsAsc();
	}

	@Override
	public List<Result> BestAges(Pageable of, Integer id) {
		// QUERY DE MEJOR PRUEBA POR EDADES
		return resultDAO.findAllByOrderBySecondsAsc();
	}

}
