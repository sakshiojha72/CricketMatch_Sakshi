package com.dsc.app.services;

import java.time.LocalDate;
import java.util.List;

import com.dsc.app.dto.AudienceDetailsDTO;
import com.dsc.app.dto.MatchDTO;
import com.dsc.app.dto.SeatStatusDTO;

public interface ICricketMatchService {
	
	//admin features:
	
		//add a match
		public void addMatch(MatchDTO dto);
		
		//get audience details by match date
		List<AudienceDetailsDTO> getAudienceDetails(LocalDate matchDate);
		
		//get seat status 
		SeatStatusDTO getSeatStatus(LocalDate matchDate);
		
	//audience features:
		
		//See upcoming matches
		List<LocalDate> getUpcomingMatches();

}
