package com.SportsTournament.repository;

import com.SportsTournament.model.VolleyballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<VolleyballMatch, Integer> {
    public boolean existsByDate(String date);

    public List<VolleyballMatch> findByDate(String date);

    @Query("select max(s.id) from FootballMatch s")
    public Integer findMaxId();
}
