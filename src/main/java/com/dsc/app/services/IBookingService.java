package com.dsc.app.services;

import com.dsc.app.dto.BookingRequestDTO;
import com.dsc.app.dto.BookingResponseDTO;
import com.dsc.app.dto.BookingStatusDTO;

public interface IBookingService {

    // AUDIENCE FEATURE: Book tickets for a match
    public  BookingResponseDTO bookTickets(BookingRequestDTO dto);

    // AUDIENCE FEATURE: Get booking status
    public BookingStatusDTO getBookingStatus(Integer bookingId);


}
