package com.dsc.app.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequestDTO {

    @NotBlank(message = "Required Field Error: name")
    private String name;

    @NotNull(message = "Required Field Error: age")
    @Min(value = 1, message = "Age Cannot be less than 1")
    private Integer age;

    @NotNull(message = "Required Field Error: gender")
    private Character gender;


	@NotBlank(message = "Required Field Error: matchDate")
	private String dateOfMatch;


    @Min(value = 1, message = "Required Field Error: numberOfTickets")
    private int numberOfTickets;
}