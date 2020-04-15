/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.util.Date;

/**
 *
 * @author v_lon
 */
public class Match {
    Date date;
    Team homeTeam;
    Team awayTeam;
    char result;
    int homeTeamGoal;
    int awayTeamGoal;
    
    
    public Match(Date date,Team homeTeam,Team awayTeam,char result,int homeTeamGoal,int awayTeamGoal){
        this.date=date;
        this.homeTeam=homeTeam;
        this.awayTeam=awayTeam;
        this.result=result;
        this.homeTeamGoal=homeTeamGoal;
        this.awayTeamGoal=awayTeamGoal;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }


    public int getHomeTeamGoal() {
        return homeTeamGoal;
    }

    public void setHomeTeamGoal(int homeTeamGoal) {
        this.homeTeamGoal = homeTeamGoal;
    }

    public int getAwayTeamGoal() {
        return awayTeamGoal;
    }

    public void setAwayTeamGoal(int awayTeamGoal) {
        this.awayTeamGoal = awayTeamGoal;
    }
    
    
}
