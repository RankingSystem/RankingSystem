
package Business;

import java.util.ArrayList;

/**
 *
 * @author v_lon
 */
public class Team {
    String name;
    ArrayList<Match> homeMatchList;
    ArrayList<Match> awayMatchList;

    public Team(String name){
        this.name=name;
        this.homeMatchList=new ArrayList<Match>();
        this.awayMatchList=new ArrayList<Match>();
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
    
    
}