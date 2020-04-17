package System;

import java.util.ArrayList;

/**
 *
 * @author v_lon
 */
public class Team{

    String name;
    ArrayList<Match> homeMatchList;
    ArrayList<Match> awayMatchList;
    int win;
    int draw;
    int lose;
    int score;

    public Team() {
        this.homeMatchList = new ArrayList<Match>();
        this.awayMatchList = new ArrayList<Match>();
    }

    public Team(String name,int win,int draw,int lose,int score) {
        this.name = name;
        this.win=win;
        this.draw=draw;
        this.lose=lose;
        this.score=score;
        this.homeMatchList = new ArrayList<Match>();
        this.awayMatchList = new ArrayList<Match>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Match> getHomeMatchList() {
        return homeMatchList;
    }

    public void setHomeMatchList(ArrayList<Match> homeMatchList) {
        this.homeMatchList = homeMatchList;
    }

    public ArrayList<Match> getAwayMatchList() {
        return awayMatchList;
    }

    public void setAwayMatchList(ArrayList<Match> awayMatchList) {
        this.awayMatchList = awayMatchList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

}
