/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author v_lon
 */
public class RankingSystem {

    DataReader teamReader;
    DataReader matchReader;
    DataReader unplayedReader;
    DataWriter writer = new DataWriter();
    static ArrayList<Team> teamList;
    static ArrayList<Match> matchList;
    static ArrayList<Match> unplayedList;

    public RankingSystem() throws IOException {
        teamReader = new DataReader("data/team.csv");
        matchReader = new DataReader("data/match.csv");
        unplayedReader = new DataReader("data/unplayed.csv");
        teamList = new ArrayList<Team>();
        matchList = new ArrayList<Match>();
        unplayedList = new ArrayList<Match>();
    }

    public static void main(String[] args) throws IOException {
        RankingSystem sys = new RankingSystem();
        sys.readData();
        sys.writeData();
    }

    private void readData() throws IOException {
        String[] row;
        while ((row = teamReader.getNextRow()) != null) {
            generateTeam(row);
        }
        while ((row = matchReader.getNextRow()) != null) {
            generateMatch(row);
        }
        while ((row = unplayedReader.getNextRow()) != null) {
            generateUnplayed(row);
        }
    }

    private void generateTeam(String[] row) {
        String name = row[0];
        int win = Integer.parseInt(row[1]);
        int draw = Integer.parseInt(row[2]);
        int lose = Integer.parseInt(row[3]);
        int score = Integer.parseInt(row[4]);
        Team t = new Team(name, win, draw, lose, score);
        teamList.add(t);
    }

    private void generateMatch(String[] row) {
        Team ht = new Team();
        Team at = new Team();
        for (Team t : teamList) {
            if (t.getName().equals(row[0])) {
                ht = t;
            }
            if (t.getName().equals(row[1])) {
                at = t;
            }
        }
        char result = row[4].charAt(0);
        int hg = Integer.parseInt(row[2]);
        int ag = Integer.parseInt(row[3]);
        Match m = new Match(ht, at, result, hg, ag);
        matchList.add(m);
        ht.getHomeMatchList().add(m);
        at.getAwayMatchList().add(m);
    }

    private void generateUnplayed(String[] row) {
        Team ht = new Team();
        Team at = new Team();
        for (Team t : teamList) {
            if (t.getName().equals(row[0])) {
                ht = t;
            }
            if (t.getName().equals(row[1])) {
                at = t;
            }
        }
        Match m = new Match(ht, at);
        unplayedList.add(m);
    }

    private void writeData() throws IOException {
        String header = "home/away";
        for (Team t : teamList) {
            header += "," + t.getName();
        }
        String path = "output/winRate.csv";
        writer.writeWinRate(header, path, teamList);

        header = "HomeTeam,AwayTeam,FTHG,FTAG,FTR";
        path = "output/predict.csv";
        writer.writePredict(header, path, unplayedList);
        header = "Team,Win,Draw,Lose,Score";
        path = "output/rank.csv";
        writer.writeRank(header, path, teamList);
    }

}
