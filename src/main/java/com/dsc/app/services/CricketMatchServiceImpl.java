package com.dsc.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.app.dto.AudienceDetailsDTO;
import com.dsc.app.dto.MatchDTO;
import com.dsc.app.dto.SeatStatusDTO;
import com.dsc.app.entities.Audience;
import com.dsc.app.entities.Booking;
import com.dsc.app.entities.CricketMatch;
import com.dsc.app.exceptions.RequiredFieldException;
import com.dsc.app.repositories.BookingRepository;
import com.dsc.app.repositories.CricketMatchRepository;

@Service
public class CricketMatchServiceImpl implements ICricketMatchService {

    @Autowired
    private CricketMatchRepository matchRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @Override
    public void addMatch(MatchDTO dto) {

        // Validate fields
        if (dto.getDateOfMatch() == null || dto.getDateOfMatch().isBlank()) {
            throw new RequiredFieldException("matchDate field is empty!");
        }
        if (dto.getCityName() == null || dto.getCityName().isBlank()) {
            throw new RequiredFieldException("cityName is empty!");
        }

        // ⭐ Convert String → LocalDate
        LocalDate date = LocalDate.parse(dto.getDateOfMatch());

        // Check if match already exists on this date
        Optional<CricketMatch> existingMatch = matchRepo.findByDateOfMatch(date);
        if (existingMatch.isPresent()) {
            throw new RequiredFieldException("Match already scheduled on this date");
        }

        // Create entity
        CricketMatch match = new CricketMatch();
        match.setDateOfMatch(date); // ⭐ set LocalDate value
        match.setCityName(dto.getCityName());

        matchRepo.save(match);
    }

    @Override
    public List<AudienceDetailsDTO> getAudienceDetails(LocalDate matchDate) {

        if (matchDate == null) {
            throw new RequiredFieldException("matchDate invalid!");
        }

        CricketMatch match = matchRepo.findByDateOfMatch(matchDate)
                .orElseThrow(() -> new RequiredFieldException("Match not found for the given Date"));

        List<Booking> bookings = bookingRepo.findByMatch(match);
        List<AudienceDetailsDTO> result = new ArrayList<>();

        for (Booking b : bookings) {
            for (Audience a : b.getAllAudience()) {
                AudienceDetailsDTO dto = new AudienceDetailsDTO();
                dto.setSeatNumber(a.getSeatNumber());
                dto.setName(a.getAudienceName());
                dto.setGender(a.getGender());
                result.add(dto);
            }
        }

        return result;
    }

    @Override
    public SeatStatusDTO getSeatStatus(LocalDate matchDate) {

        if (matchDate == null) {
            throw new RequiredFieldException("matchDate");
        }

        CricketMatch match = matchRepo.findByDateOfMatch(matchDate)
                .orElseThrow(() -> new RequiredFieldException("Match not found"));

        List<Booking> bookings = bookingRepo.findByMatch(match);

        int bookedSeats = 0;
        for (Booking b : bookings) {
            bookedSeats += b.getAllAudience().size();
        }

        SeatStatusDTO dto = new SeatStatusDTO();
        dto.setBooked(bookedSeats);
        dto.setEmpty(20 - bookedSeats);

        return dto;
    }

    @Override
    public List<LocalDate> getUpcomingMatches() {

        LocalDate today = LocalDate.now();

        List<CricketMatch> allMatches = matchRepo.findAll();
        List<LocalDate> result = new ArrayList<>();

        for (CricketMatch match : allMatches) {
            if (!match.getDateOfMatch().isBefore(today)) {
                result.add(match.getDateOfMatch());
            }
        }

        return result;
    }
}