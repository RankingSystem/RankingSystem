/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author v_lon
 */
public class DataWriter {

    private static FileWriter writer;
    private static File file;
    private static final String LINE_BREAK = "\n";

    public void writeWinRate(String header, String path, ArrayList<Team> tl) throws IOException {
        try {
            file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            System.out.println("New File Created");
            writer = new FileWriter(file);

            writer.append(header);
            writer.append(LINE_BREAK);
            for (Team ht : tl) {
                String column = ht.getName();
                for (Team at : tl) {
                    if (ht == at) {
                        column += ", ";
                    } else {
                        column += "," + Analysis.winRate(ht, at);
                    }
                }
                writer.append(column);
                writer.append(LINE_BREAK);
            }

        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public void writePredict(String header, String path, ArrayList<Match> ml) throws IOException {
        try {
            file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            System.out.println("New File Created");
            writer = new FileWriter(file);

            writer.append(header);
            writer.append(LINE_BREAK);
            for (Match m : ml) {
                m = Analysis.predict(m);
                String column = m.getHomeTeam().getName() + "," + m.getAwayTeam().getName() + "," + m.getHomeTeamGoal() + "," + m.getAwayTeamGoal() + "," + m.getResult();
                writer.append(column);
                writer.append(LINE_BREAK);
            }
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public void writeRank(String header, String path, ArrayList<Team> tl) throws IOException {
        Comparator<Team> c = new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                if (t1.getScore() > t2.getScore()) {
                    return -1;
                } else if (t1.getScore() < t2.getScore()) {
                    return 1;
                }
                return 0;
            }
        };
        Collections.sort(tl, c);
        try {
            file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            System.out.println("New File Created");
            writer = new FileWriter(file);

            writer.append(header);
            writer.append(LINE_BREAK);
            for (Team t: tl) {
                String column = t.getName()+","+t.getWin()+","+t.getDraw()+","+t.getLose()+","+t.getScore();
                writer.append(column);
                writer.append(LINE_BREAK);
            }
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}
