package com.dsc.app.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingStatusDTO {
    private Integer bookingId;
    private LocalDate dateOfMatch;
    private String bookedBy; 
    private List<AudienceDetailsDTO> audienceList;  
}