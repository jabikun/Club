package com.club.club.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.club.club.dto.ResultDTO;
import com.club.club.mapper.ResultMapper;
import com.club.club.model.Result;
import com.club.club.service.ResultService;

@RestController
@RequestMapping(value = "trial/{idTrial}/result")
public class ResultController {
	
	@Autowired
	ResultService resultService;
	
	@Autowired
	ResultMapper resultMapper;
	
	@PostMapping
	public ResultDTO create(@PathVariable Integer idTrial, @RequestBody ResultDTO resultToCreate) {
		final Result result = resultMapper.mapToModel(resultToCreate);
		final Result resultCreated = resultService.create(result, idTrial);
		return resultMapper.mapToDTO(resultCreated);
	}
	
	@GetMapping("/all/BestClubs")
	public List<ResultDTO> BestClubs(
			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "3", value = "size", required = false) Integer size,
			@RequestParam(value = "seconds", required = false) Integer seconds) {
		final List<Result> results = resultService.BestClubs(PageRequest.of(page, size),
				seconds);
		return resultMapper.mapToDTO(results);
	}
	
	@GetMapping("/all/BestAges")
	public List<ResultDTO> BestAges(
			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "3", value = "size", required = false) Integer size,
			@RequestParam(value = "seconds", required = false) Integer seconds) {
		final List<Result> results = resultService.BestAges(PageRequest.of(page, size),
				seconds);
		return resultMapper.mapToDTO(results);
	}
	
	@GetMapping("/{id}")
	public ResultDTO findById(@PathVariable Integer id) {
		final Optional<Result> result = resultService.findById(id);
		return resultMapper.mapToDTO(result.get());
	}
	
}
