package com.dsc.app.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.dsc.app.entities.Audience;
import com.dsc.app.entities.Booking;
import com.dsc.app.entities.CricketMatch;
import com.dsc.app.repositories.AudienceRepository;
import com.dsc.app.repositories.BookingRepository;
import com.dsc.app.repositories.CricketMatchRepository;

@Configuration
public class AppSeeder {

//    @Autowired
//    private CricketMatchRepository matchRepo;
//
//    @Autowired
//    private BookingRepository bookingRepo;
//
//    @Autowired
//    private AudienceRepository audienceRepo;
//
//    @Bean
//    public CommandLineRunner seedDatabase() {
//
//        return args -> {
//
//            // ---- INSERT MATCHES ----
//            CricketMatch m1 = new CricketMatch();
//            m1.setDateOfMatch(LocalDate.parse("2026-03-23"));
//            m1.setCityName("Delhi");
//            m1.setSeatNumber(20);
//
//            CricketMatch m2 = new CricketMatch();
//            m2.setDateOfMatch(LocalDate.parse("2026-03-27"));
//            m2.setCityName("Mumbai");
//            m2.setSeats(20);
//
//            CricketMatch m3 = new CricketMatch();
//            m3.setDateOfMatch(LocalDate.parse("2026-03-28"));
//            m3.setCityName("Pune");
//            m3.setSeats(20);
//
//            matchRepo.save(m1);
//            matchRepo.save(m2);
//            matchRepo.save(m3);
//
//            // ---- INSERT BOOKINGS ----
//            Booking b1 = new Booking(null, 3, m1, new ArrayList<>());
//            Booking b2 = new Booking(null, 4, m1, new ArrayList<>());
//            Booking b3 = new Booking(null, 2, m1, new ArrayList<>());
//
//            bookingRepo.save(b1);
//            bookingRepo.save(b2);
//            bookingRepo.save(b3);
//
//            // ---- INSERT AUDIENCE ----
//            Audience a1 = new Audience(null, "Ramesh", 30, 'M', 1, b1);
//            Audience a2 = new Audience(null, "Lokesh", 28, 'M', 2, b1);
//            Audience a3 = new Audience(null, "Ganesh", 27, 'M', 3, b1);
//
//            Audience a4 = new Audience(null, "Suresh", 35, 'M', 4, b2);
//            Audience a5 = new Audience(null, "Mahesh", 29, 'M', 5, b2);
//            Audience a6 = new Audience(null, "Rakesh", 32, 'M', 6, b2);
//            Audience a7 = new Audience(null, "Bhavesh", 30, 'M', 7, b2);
//
//            Audience a8 = new Audience(null, "Kavita", 28, 'F', 8, b3);
//            Audience a9 = new Audience(null, "Sarita", 33, 'F', 9, b3);
//
//            audienceRepo.save(a1);
//            audienceRepo.save(a2);
//            audienceRepo.save(a3);
//            audienceRepo.save(a4);
//            audienceRepo.save(a5);
//            audienceRepo.save(a6);
//            audienceRepo.save(a7);
//            audienceRepo.save(a8);
//            audienceRepo.save(a9);
//
//            System.out.println("---- SAMPLE DATA SEEDED SUCCESSFULLY ----");
//        };
//    }
}