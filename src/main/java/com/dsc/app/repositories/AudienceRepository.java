package com.dsc.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsc.app.entities.Audience;
import com.dsc.app.entities.Booking;

public interface AudienceRepository extends JpaRepository<Audience, Integer>{

	List<Audience> findByBooking(Booking booking);

}
