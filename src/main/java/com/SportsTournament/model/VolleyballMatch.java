package com.SportsTournament.model;

import javax.persistence.*;


@Entity
@Table (name = "VolleyballMatch")


public class VolleyballMatch {

    @Id
    private int id;

    @Column(name = "Team_A")
    private String teamA;

    @Column(name = "Team_B")
    private String teamB;

    @Column(name = "Match_Time")
    private String time;

    public VolleyballMatch(){
    }

    public int getId() {
    return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", Team A Name='" + getTeamA() + '\'' +
                ", Team A Name='" + getTeamA() + '\'' +
                ", Match Date='" + getDate() + '\'' +
                ", Match Time='" + getTime() + '\'' +
                '}';
    }
}


