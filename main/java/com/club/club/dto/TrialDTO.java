package com.club.club.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrialDTO {
	
	Integer id;
	String name;
	String date;

}
