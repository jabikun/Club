package com.club.club.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.club.club.dto.RunnerDTO;
import com.club.club.model.Runner;
import com.club.club.service.RunnerService;

@Component
public class RunnerMapperImpl implements RunnerMapper{
	
	@Autowired
	RunnerService runnerService;

	@Override
	public Runner mapToModel(RunnerDTO dto) {
		final Runner runner = runnerService.findById(dto.getId()).orElse(new Runner());
		runner.setId(dto.getId());
		runner.setName(dto.getName());
		runner.setYear(dto.getYear());
		return runner;
	}

	@Override
	public RunnerDTO mapToDTO(Runner model) {
		return RunnerDTO.builder().id(model.getId()).name(model.getName()).year(model.getYear())
				.build();
	}

	@Override
	public List<RunnerDTO> mapToDTO(List<Runner> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
