package com.club.club.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.club.dto.ClubDTO;
import com.club.club.mapper.ClubMapper;
import com.club.club.model.Club;
import com.club.club.service.ClubService;

@RestController
@RequestMapping(value = "/club")
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@Autowired
	ClubMapper clubMapper;

	@PostMapping
	public ClubDTO create(@RequestBody ClubDTO clubToCreate) {
		final Club club = clubMapper.mapToModel(clubToCreate);
		final Club clubCreated = clubService.create(club);
		return clubMapper.mapToDTO(clubCreated);
	}
	
	@GetMapping("/{id}")
	public ClubDTO findById(@PathVariable Integer id) {
		final Optional<Club> club = clubService.findById(id);
		return clubMapper.mapToDTO(club.get());
	}

}
