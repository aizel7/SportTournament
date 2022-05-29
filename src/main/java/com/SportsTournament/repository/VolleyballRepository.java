package com.SportsTournament.repository;

import com.SportsTournament.model.VolleyballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VolleyballRepository extends JpaRepository<VolleyballMatch, Integer> {
    public List<VolleyballMatch> findbydate(String date);

    @Query(value="select max(s.id) from sportstournament.volleyballmatch s", nativeQuery = true)
    public Integer findMaxId();

    public boolean existbydate(String date);
}


