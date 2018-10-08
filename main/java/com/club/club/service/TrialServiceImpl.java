package com.club.club.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.club.dao.TrialDAO;
import com.club.club.model.Trial;

@Service
public class TrialServiceImpl implements TrialService{
	
	@Autowired
	TrialDAO trialDAO;
	
	@Autowired
	RunnerService runnerService;

	@Override
	public Trial create(Trial trial) {
		return trialDAO.save(trial);
	}

	@Override
	public Optional<Trial> findById(Integer id) {
		return trialDAO.findById(id);
	}

}
