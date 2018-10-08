package com.club.club.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RunnerDTO {
	
	Integer id;
	String name;
	Integer year;

}
