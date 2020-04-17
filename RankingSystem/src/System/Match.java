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

    Team homeTeam;
    Team awayTeam;
    char result;
    int homeTeamGoal;
    int awayTeamGoal;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Match(Team homeTeam, Team awayTeam, char result, int homeTeamGoal, int awayTeamGoal) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.homeTeamGoal = homeTeamGoal;
        this.awayTeamGoal = awayTeamGoal;
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

    public char getResult() {
        return result;
    }

    public void setResult(char result) {
        this.result = result;
    }

}
