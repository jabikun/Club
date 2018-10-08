package com.club.club.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.club.dto.TrialDTO;
import com.club.club.mapper.TrialMapper;
import com.club.club.model.Trial;
import com.club.club.service.TrialService;

@RestController
@RequestMapping(value = "/trial")
public class TrialController {
	
	@Autowired
	TrialService trialService;
	
	@Autowired
	TrialMapper trialMapper;

	@PostMapping
	public TrialDTO create(@RequestBody TrialDTO trialToCreate) {
		final Trial trial = trialMapper.mapToModel(trialToCreate);
		final Trial trialCreated = trialService.create(trial);
		return trialMapper.mapToDTO(trialCreated);
	}
	
	@GetMapping("/{id}")
	public TrialDTO findById(@PathVariable Integer id) {
		final Optional<Trial> trial = trialService.findById(id);
		return trialMapper.mapToDTO(trial.get());
	}

}
