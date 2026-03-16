package com.dsc.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.app.entities.Audience;
import com.dsc.app.entities.Booking;
import com.dsc.app.exceptions.RequiredFieldException;
import com.dsc.app.repositories.AudienceRepository;

@Service
public class AudienceServiceImpl implements IAudeinceService{
	@Autowired
	private AudienceRepository audienceRepo;

	@Override
	public List<Audience> findByBooking(Booking booking) {

		if(booking== null)
		{
			throw new RequiredFieldException("Booking not prodivded");
		}
		return audienceRepo.findByBooking(booking);
	}

	@Override
	public Audience getAudienceById(Integer id) {
		
		return audienceRepo.findById(id)
				.orElseThrow(()->
				new RequiredFieldException("Audience not found with ID:" +id));
	}

}
