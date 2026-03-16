package com.dsc.app.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SeatStatusDTO {
    private int booked;
    private int empty;
}