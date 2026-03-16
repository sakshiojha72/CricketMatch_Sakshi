package com.dsc.app.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MatchDTO {
	@NotBlank(message = "Required Field Error: matchDate")
	private String dateOfMatch;
	@NotBlank(message="Required Field Error: cityName")
	private String cityName;
}