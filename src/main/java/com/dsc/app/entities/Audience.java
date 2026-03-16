package com.dsc.app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Audience {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer audienceId;

	    private String audienceName;

	    private Integer age;

//	    @NotNull(message = "Required Field Error: gender")
	    private char gender;

	    private Integer seatNumber;  

/*
     * MANY Audience entries belong to ONE Booking.
     * Reason:
     *   If a user books 5 seats, we create:
     *     - Audience 1
     *     - Audience 2
     *     - Audience 3
     *     - Audience 4
     *     - Audience 5
     *   All linked to the same bookingId.
     */
    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;
}
