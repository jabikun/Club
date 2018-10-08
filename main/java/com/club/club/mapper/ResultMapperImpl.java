package com.club.club.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.club.club.dto.ResultDTO;
import com.club.club.model.Result;
import com.club.club.model.Runner;
import com.club.club.service.ResultService;
import com.club.club.service.RunnerService;

@Component
public class ResultMapperImpl implements ResultMapper{
	
	@Autowired
	ResultService resultService;
	
	@Autowired
	RunnerService runnerService;

	@Override
	public Result mapToModel(ResultDTO dto) {
		final Result result = resultService.findById(dto.getId()).orElse(new Result());
		final Optional<Runner> runner = runnerService.findById(dto.getIdRunner());
		result.setId(dto.getId());
		result.setRunner(runner.get());
		result.setSeconds(dto.getSeconds());
		return result;
	}

	@Override
	public ResultDTO mapToDTO(Result model) {
		return ResultDTO.builder().id(model.getId()).idRunner(model.getRunner().getId()).seconds(model.getSeconds())
				.build();
	}

	@Override
	public List<ResultDTO> mapToDTO(List<Result> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
