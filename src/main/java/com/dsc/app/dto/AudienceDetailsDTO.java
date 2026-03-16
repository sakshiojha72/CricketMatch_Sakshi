package com.dsc.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AudienceDetailsDTO {
    private Integer seatNumber;
    private String name;
    private char gender;
}