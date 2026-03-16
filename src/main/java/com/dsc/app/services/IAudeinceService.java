package com.dsc.app.services;

import java.util.List;

import com.dsc.app.entities.Audience;
import com.dsc.app.entities.Booking;

public interface IAudeinceService {

List<Audience> findByBooking(Booking booking);

Audience getAudienceById(Integer id);


}
