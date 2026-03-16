package com.dsc.app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column(name = "total_tickets")
    private Integer totalTickets;   

    // Many bookings belong to ONE match
    @ManyToOne
    @JoinColumn(name = "match_id")   
    private CricketMatch match;

    // One booking has MANY audience entries
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Audience> allAudience;   
}