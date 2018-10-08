package com.club.club.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.club.club.dto.TrialDTO;
import com.club.club.model.Trial;
import com.club.club.service.TrialService;

@Component
public class TrialMapperImpl implements TrialMapper{
	
	@Autowired
	TrialService trialService;

	@Override
	public Trial mapToModel(TrialDTO dto) {
		final Trial trial = trialService.findById(dto.getId()).orElse(new Trial());
		trial.setId(dto.getId());
		trial.setName(dto.getName());
		trial.setDate(dto.getDate());
		return trial;
	}

	@Override
	public TrialDTO mapToDTO(Trial model) {
		return TrialDTO.builder().id(model.getId()).name(model.getName()).date(model.getDate())
				.build();
	}

	@Override
	public List<TrialDTO> mapToDTO(List<Trial> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
