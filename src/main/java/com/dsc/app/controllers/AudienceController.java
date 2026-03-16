package com.dsc.app.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dsc.app.dto.BookingRequestDTO;
import com.dsc.app.dto.BookingResponseDTO;
import com.dsc.app.dto.BookingStatusDTO;
import com.dsc.app.services.IBookingService;
import com.dsc.app.services.ICricketMatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/audience")
public class AudienceController {

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private ICricketMatchService matchService;

    @PostMapping("/book")
    public ResponseEntity<BookingResponseDTO> bookTickets(@Valid @RequestBody BookingRequestDTO dto) {
        BookingResponseDTO response = bookingService.bookTickets(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/bookingstatus/{bookingId}")
    public ResponseEntity<BookingStatusDTO> getBookingStatus(@PathVariable Integer bookingId) {
        BookingStatusDTO result = bookingService.getBookingStatus(bookingId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/upcomingmatches")
    public ResponseEntity<List<LocalDate>> upcomingMatches() {
        return ResponseEntity.ok(matchService.getUpcomingMatches());
    }
}