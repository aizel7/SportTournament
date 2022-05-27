package com.SportsTournament.service;


import com.SportsTournament.model.VolleyballMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service

public class VolleyballMatchesService {

    @Autowired
    private Repository repository;
    @Transactional
    public String createVolleyballMatch(VolleyballMatch volleyballMatch){}
    try {
        if (!repository.existByDate(VolleyballMatch.getDate())){
            VolleyballMatch.setId(null == repository.findMaxId()? 0 : repository.findMaxId() + 1 );
            repository.save(VolleyballMatch);
            return "Match record created succesfully.";
        } else {
            return "Match already exists in the database.";
        }
        catch (Exeption e) {
            throw e;
        }
    }

    public List<VolleyballMatch> readMatchs(){
        return repository.findAll();
    }

    @Transactional
    public String updateFootballMatch(VolleyballMatch volleyballMatch){
        if (repository.existsByDate(volleyballMatch.getDate())){
            try {
                List<VolleyballMatch> footballMatches = volleyballMatch.findByDate(volleyballMatch.getDate());
                volleyballMatch.stream().forEach(s -> {
                    VolleyballMatch volleyballMatchToBeUpdate = repository.findById(s.getId()).get();
                    volleyballMatchToBeUpdate.setTeamA(VolleyballMatch.getTeamA());
                    volleyballMatch.setTeamB(volleyballMatch.getTeamB());
                    volleyballMatchToBeUpdate.setDate(volleyballMatch.getDate());
                    volleyballMatchToBeUpdate.setTime(volleyballMatch.getTime());
                    repository.save(volleyballMatchToBeUpdate);
                });
                return "Match record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Match does not exists in the database.";
        }
    }

    @Transactional
    public String deleteVolleyballMatch(VolleyballMatch volleyballMatch){
        if (repository.existsByDate(volleyballMatch.getDate())){
            try {
                List<VolleyballMatch> volleyballMatches = repository.findByDate(volleyballMatch.getDate());
                volleyballMatches.stream().forEach(s -> {
                    volleyballMatches.delete(s);
                });
                return "Match record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Match does not exist";
        }
    }
}
