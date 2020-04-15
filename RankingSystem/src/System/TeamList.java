/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.util.ArrayList;

/**
 *
 * @author v_lon
 */
public class TeamList {
    ArrayList<Team> teamList;

    public TeamList(){
        teamList=new ArrayList<Team>();
    }
    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }
    
    
}
