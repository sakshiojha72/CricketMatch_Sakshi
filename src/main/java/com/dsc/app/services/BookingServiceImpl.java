package com.dsc.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.app.dto.AudienceDetailsDTO;
import com.dsc.app.dto.BookingRequestDTO;
import com.dsc.app.dto.BookingResponseDTO;
import com.dsc.app.dto.BookingStatusDTO;
import com.dsc.app.entities.Audience;
import com.dsc.app.entities.Booking;
import com.dsc.app.entities.CricketMatch;
import com.dsc.app.exceptions.RequiredFieldException;
import com.dsc.app.repositories.AudienceRepository;
import com.dsc.app.repositories.BookingRepository;
import com.dsc.app.repositories.CricketMatchRepository;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepository bookingRepo;
    
    @Autowired
    private AudienceRepository audienceRepo;
    
    @Autowired
    private CricketMatchRepository matchRepo;
    
    @Override
    public BookingResponseDTO bookTickets(BookingRequestDTO dto) {

        // manual validations 
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new RequiredFieldException("name");
        }
        if (dto.getAge() == null) {
            throw new RequiredFieldException("age");
        }
        if (dto.getGender() == null) {
            throw new RequiredFieldException("gender");
        }
        if (dto.getDateOfMatch() == null) {
            throw new RequiredFieldException("matchDate");
        }
        if (dto.getNumberOfTickets() <= 0) {
            throw new RequiredFieldException("numberOfTickets");
        }

        LocalDate date = LocalDate.parse(dto.getDateOfMatch());

        // fetch match by date  
        CricketMatch match = matchRepo.findByDateOfMatch(date)
                .orElseThrow(() -> new RequiredFieldException("matchDate"));

        // existing bookings
        List<Booking> existingBookings = bookingRepo.findByMatch(match);

        // all booked seats
        Set<Integer> bookedSeats = new HashSet<>();

        for (Booking b : existingBookings) {
            for (Audience a : b.getAllAudience()) {
                bookedSeats.add(a.getSeatNumber());
            }
        }

        // available seats
        List<Integer> availableSeats = new ArrayList<>();

        for (int i = 1; i <= 25; i++) {
            if (!bookedSeats.contains(i)) {
                availableSeats.add(i);
            }
        }

        if (availableSeats.size() < dto.getNumberOfTickets()) {
            throw new RuntimeException("Not enough seats available");
        }

        List<Integer> allocatedSeats = new ArrayList<>();
        for (int i = 0; i < dto.getNumberOfTickets(); i++) {
            allocatedSeats.add(availableSeats.get(i));
        }

        //create booking
        Booking booking = new Booking();
        booking.setMatch(match);
        booking.setTotalTickets(dto.getNumberOfTickets());
        List<Audience> list = new ArrayList<>();

        for (Integer seat : allocatedSeats) {
            Audience aud = new Audience();
            aud.setAudienceName(dto.getName());
            aud.setAge(dto.getAge());
            aud.setGender(dto.getGender());
            aud.setSeatNumber(seat);
            aud.setBooking(booking);
            list.add(aud);
        }

        booking.setAllAudience(list);

        Booking saved = bookingRepo.save(booking);

        // response
        BookingResponseDTO response = new BookingResponseDTO();
        response.setBookingId(saved.getBookingId());
        response.setDateOfMatch(dto.getDateOfMatch());  
        response.setTotalTickets(dto.getNumberOfTickets());
        response.setBookedBy(dto.getName());
        response.setSeatNumbers(allocatedSeats);  // ← ADD THIS


        return response;
    }

    @Override
    public BookingStatusDTO getBookingStatus(Integer bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RequiredFieldException("no booking for this id exists!"));
        
        BookingStatusDTO dto = new BookingStatusDTO();
        dto.setBookingId(booking.getBookingId());
        dto.setDateOfMatch(booking.getMatch().getDateOfMatch());
        

        dto.setBookedBy(booking.getAllAudience().get(0).getAudienceName());

        // audience list
        List<AudienceDetailsDTO> audienceList = new ArrayList<>();

        for (Audience a : booking.getAllAudience()) {
            AudienceDetailsDTO ad = new AudienceDetailsDTO();
            ad.setSeatNumber(a.getSeatNumber());
            ad.setName(a.getAudienceName());
            ad.setGender(a.getGender());
            audienceList.add(ad);
        }

        dto.setAudienceList(audienceList);

        return dto;

    }
    
}