package com.dsc.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsc.app.entities.Booking;
import com.dsc.app.entities.CricketMatch;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByMatch(CricketMatch match);
}
