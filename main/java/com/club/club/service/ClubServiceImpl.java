package com.club.club.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.club.dao.ClubDAO;
import com.club.club.model.Club;

@Service
public class ClubServiceImpl implements ClubService{
	
	@Autowired
	ClubDAO clubDAO;
	
	@Override
	public Club create(Club club) {
		return clubDAO.save(club);
	}

	@Override
	public Optional<Club> findById(Integer id) {
		return clubDAO.findById(id);
	}

	

}
