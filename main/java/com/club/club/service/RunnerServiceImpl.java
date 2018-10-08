package com.club.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.club.club.dao.RunnerDAO;
import com.club.club.model.Club;
import com.club.club.model.Runner;

@Service
public class RunnerServiceImpl implements RunnerService{

	@Autowired
	RunnerDAO runnerDAO;
	
	@Autowired
	ClubService clubService;
	
	@Override
	public Runner create(Runner runner, Integer idClub) {
		final Optional<Club> club = clubService.findById(idClub);
		runner.setClub(club.get());
		return runnerDAO.save(runner);
	}

	@Override
	public Optional<Runner> findById(Integer id) {
		return runnerDAO.findById(id);
	}
	
	@Override
	public List<Runner> findAll(Pageable pagination, Integer club_id) {
		return runnerDAO.findAllByOrderByIdAsc();
	}

	@Override
	public void update(Integer id, Runner runnerToUpdate) {
		runnerDAO.saveAndFlush(runnerToUpdate);
	}

	@Override
	public void delete(Integer id) {
		runnerDAO.deleteById(id);
	}

}
