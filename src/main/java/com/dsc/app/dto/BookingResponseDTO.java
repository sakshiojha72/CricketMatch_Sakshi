package com.dsc.app.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDTO {

    private Integer bookingId;
    private String dateOfMatch;
    private List<Integer> seatNumbers;  
    private int totalTickets;
    private String bookedBy;
}