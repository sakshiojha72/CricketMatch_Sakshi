package com.dsc.app.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dsc.app.dto.AudienceDetailsDTO;
import com.dsc.app.dto.MatchDTO;
import com.dsc.app.dto.SeatStatusDTO;
import com.dsc.app.services.ICricketMatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ICricketMatchService matchService;

    @PostMapping("/match")
    public ResponseEntity<String> addMatch(@Valid @RequestBody MatchDTO dto) {
        matchService.addMatch(dto);
        return ResponseEntity.ok("match added successfully!");
    }

    @GetMapping("/audience/{date}")
    public ResponseEntity<List<AudienceDetailsDTO>> audienceByDate(@PathVariable String date) {
        LocalDate matchDate = LocalDate.parse(date);
        return ResponseEntity.ok(matchService.getAudienceDetails(matchDate));
    }

    @GetMapping("/seatstatus/{date}")
    public ResponseEntity<SeatStatusDTO> seatStatus(@PathVariable LocalDate date) {
        return ResponseEntity.ok(matchService.getSeatStatus(date));
    }

    @GetMapping("/upcomingmatches")
    public ResponseEntity<List<LocalDate>> upcomingMatches() {
        return ResponseEntity.ok(matchService.getUpcomingMatches());
    }
}