package com.dsc.app.dto;

import java.time.LocalDate;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MatchResponseDTO {
    private Integer matchNumber;
    private LocalDate dateOfMatch;
    private String cityName;
    private Integer seats;  // always 20
}