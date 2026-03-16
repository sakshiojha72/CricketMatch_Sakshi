package com.dsc.app.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CricketMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchNumber;
    

    private LocalDate dateOfMatch;

    private String cityName;
    private final Integer seats=30;
    
    //one match can have many bookings
    @OneToMany(mappedBy ="match" )
    List<Booking> allBookings;
}
