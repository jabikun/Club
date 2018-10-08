package com.club.club.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.club.club.dto.ClubDTO;
import com.club.club.model.Club;
import com.club.club.service.ClubService;

@Component
public class ClubMapperImpl implements ClubMapper{
	
	@Autowired
	ClubService clubService;

	@Override
	public Club mapToModel(ClubDTO dto) {
		final Club club = clubService.findById(dto.getId()).orElse(new Club());
		club.setId(dto.getId());
		club.setName(dto.getName());
		return club;
	}

	@Override
	public ClubDTO mapToDTO(Club model) {
		return ClubDTO.builder().id(model.getId()).name(model.getName())
				.build();
	}

	@Override
	public List<ClubDTO> mapToDTO(List<Club> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
