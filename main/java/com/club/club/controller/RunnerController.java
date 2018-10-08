package com.club.club.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.club.club.dto.RunnerDTO;
import com.club.club.mapper.RunnerMapper;
import com.club.club.model.Runner;
import com.club.club.service.RunnerService;

@RestController
@RequestMapping(value = "/club/{idClub}/runner")
public class RunnerController {
	
	@Autowired
	RunnerService runnerService;
	
	@Autowired
	RunnerMapper runnerMapper;	

	@PostMapping
	public RunnerDTO create(@PathVariable Integer idClub, @RequestBody RunnerDTO runnerToCreate) {
		final Runner runner = runnerMapper.mapToModel(runnerToCreate);
		final Runner runnerCreated = runnerService.create(runner, idClub);
		return runnerMapper.mapToDTO(runnerCreated);
	}
	
	@GetMapping
	public List<RunnerDTO> findAll(
			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "3", value = "size", required = false) Integer size,
			@RequestParam(value = "club_id", required = false) Integer club_id) {
		final List<Runner> runners = runnerService.findAll(PageRequest.of(page, size),
				club_id);
		return runnerMapper.mapToDTO(runners);
	}

	@GetMapping("/{id}")
	public RunnerDTO findById(@PathVariable Integer id) {
		final Optional<Runner> runner = runnerService.findById(id);
		return runnerMapper.mapToDTO(runner.get());
	}

	@PutMapping("/{id}")
	public void update(@RequestBody RunnerDTO runnerToUpdate,
			@PathVariable Integer id) {
		final Runner runner = runnerMapper.mapToModel(runnerToUpdate);
		runner.setId(id);
		runnerService.update(id, runner);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		runnerService.delete(id);
	}

}
