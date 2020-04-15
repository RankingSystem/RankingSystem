/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author v_lon
 */
public class RankingSystem {

    DataReader teamReader;
    DataReader matchReader;
    TeamList tl;
    MatchList ml;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public RankingSystem() throws IOException {
        teamReader = new DataReader("data/team.csv");
        matchReader = new DataReader("data/match.csv");
        tl = new TeamList();
        ml = new MatchList();
    }

    public static void main(String[] args) throws IOException {
        RankingSystem sys = new RankingSystem();
        sys.readData();
    }

    private void readData() throws IOException {
        String[] row;
        while ((row = teamReader.getNextRow()) != null) {
            generateTeam(row);
        }
        while ((row = matchReader.getNextRow()) != null) {
            generateMatch(row);
        }
    }

    private void generateTeam(String[] row) {
        String name = row[0];
        Team t = new Team(name);
        tl.getTeamList().add(t);
    }

    private void generateMatch(String[] row) {
        try {
            Date date = format.parse(row[0]);
            Team ht = new Team();
            Team at = new Team();
            for (Team t : tl.getTeamList()) {
                if (t.getName().equals(row[1])) {
                    ht = t;
                }
                if (t.getName().equals(row[2])) {
                    at = t;
                }
            }
            char result = row[5].charAt(0);
            int hg = Integer.parseInt(row[3]);
            int ag = Integer.parseInt(row[4]);
            Match m = new Match(date, ht, at, result, hg, ag);
            ml.getMatchList().add(m);
            ht.getHomeMatchList().add(m);
            at.getAwayMatchList().add(m);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
