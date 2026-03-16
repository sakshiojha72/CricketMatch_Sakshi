package com.dsc.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dsc.app.entities.CricketMatch;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface CricketMatchRepository extends JpaRepository<CricketMatch, Integer> {

    Optional<CricketMatch> findByMatchNumber(Integer matchNumber);

    Optional<CricketMatch> findByDateOfMatch(LocalDate date);

    List<CricketMatch> findAllByDateOfMatchAfter(LocalDate date);
}