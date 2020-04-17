/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 *
 * @author v_lon
 */
public class Analysis {

    public static double winRate(Team homeTeam, Team awayTeam) {
        double homeMean = getMean(homeTeam, awayTeam, true);
        double awayMean = getMean(homeTeam, awayTeam, false);
        double homeSigma = getSigma(homeTeam, awayTeam, homeMean, awayMean, true);
        double awaySigma = getSigma(homeTeam, awayTeam, homeMean, awayMean, false);
        if (homeSigma != 0 && awaySigma != 0) {
            NormalDistribution homeNd = new NormalDistribution(homeMean, homeSigma);
            NormalDistribution awayNd = new NormalDistribution(awayMean, awaySigma);
            int win = 0;
            for (int i = 0; i < 10000; i++) {
                int homeGoal = Math.round((float) homeNd.sample());
                int awayGoal = Math.round((float) awayNd.sample());
                while (homeGoal < 0) {
                    homeGoal = Math.round((float) homeNd.sample());
                }
                while (awayGoal < 0) {
                    awayGoal = Math.round((float) awayNd.sample());
                }
                if (homeGoal > awayGoal) {
                    win++;
                }
            }
            return win / 10000.0;
        } else if (homeSigma == 0 && awaySigma != 0) {
            NormalDistribution awayNd = new NormalDistribution(awayMean, awaySigma);
            int win = 0;
            for (int i = 0; i < 10000; i++) {
                int homeGoal = Math.round((float) homeMean);
                int awayGoal = Math.round((float) awayNd.sample());
                while (awayGoal < 0) {
                    awayGoal = Math.round((float) awayNd.sample());
                }
                if (homeGoal > awayGoal) {
                    win++;
                }
            }
            return win / 10000.0;
        } else if (homeSigma != 0 && awaySigma == 0) {
            NormalDistribution homeNd = new NormalDistribution(homeMean, homeSigma);
            int win = 0;
            for (int i = 0; i < 10000; i++) {
                int awayGoal = Math.round((float) awayMean);
                int homeGoal = Math.round((float) homeNd.sample());
                while (homeGoal < 0) {
                    homeGoal = Math.round((float) homeNd.sample());
                }
                if (homeGoal > awayGoal) {
                    win++;
                }
            }
            return win / 10000.0;
        } else {
            int awayGoal = Math.round((float) awayMean);
            int homeGoal = Math.round((float) homeMean);
            if (awayGoal > homeGoal) {
                return 0;
            } else if (awayGoal < homeGoal) {
                return 1;
            } else {
                return 0.5;
            }
        }
    }

    public static Match predict(Match match) {
        double homeMean = getMean(match.getHomeTeam(), match.getAwayTeam(), true);
        double awayMean = getMean(match.getHomeTeam(), match.getAwayTeam(), false);
        double homeSigma = getSigma(match.getHomeTeam(), match.getAwayTeam(), homeMean, awayMean, true);
        double awaySigma = getSigma(match.getHomeTeam(), match.getAwayTeam(), homeMean, awayMean, false);
        if (homeSigma != 0 && awaySigma != 0) {
            NormalDistribution homeNd = new NormalDistribution(homeMean, homeSigma);
            NormalDistribution awayNd = new NormalDistribution(awayMean, awaySigma);
            int homeGoal = Math.round((float) homeNd.getMean());
            int awayGoal = Math.round((float) awayNd.getMean());
            char result;
            if (homeGoal > awayGoal) {
                result = 'H';
                match.getHomeTeam().setWin(match.getHomeTeam().getWin() + 1);
                match.getAwayTeam().setLose(match.getAwayTeam().getLose() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 3);
            } else if (homeGoal < awayGoal) {
                result = 'A';
                match.getHomeTeam().setLose(match.getHomeTeam().getLose() + 1);
                match.getAwayTeam().setWin(match.getAwayTeam().getWin() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 3);
            } else {
                result = 'D';
                match.getHomeTeam().setDraw(match.getHomeTeam().getDraw() + 1);
                match.getAwayTeam().setDraw(match.getAwayTeam().getDraw() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 1);
            }
            match.setResult(result);
            match.setHomeTeamGoal(homeGoal);
            match.setAwayTeamGoal(awayGoal);
        } else if (homeSigma == 0 && awaySigma != 0) {
            NormalDistribution awayNd = new NormalDistribution(awayMean, awaySigma);
            int homeGoal = Math.round((float) homeMean);
            int awayGoal = Math.round((float) awayNd.getMean());
            char result;
            if (homeGoal > awayGoal) {
                result = 'H';
                match.getHomeTeam().setWin(match.getHomeTeam().getWin() + 1);
                match.getAwayTeam().setLose(match.getAwayTeam().getLose() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 3);
            } else if (homeGoal < awayGoal) {
                result = 'A';
                match.getHomeTeam().setLose(match.getHomeTeam().getLose() + 1);
                match.getAwayTeam().setWin(match.getAwayTeam().getWin() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 3);
            } else {
                result = 'D';
                match.getHomeTeam().setDraw(match.getHomeTeam().getDraw() + 1);
                match.getAwayTeam().setDraw(match.getAwayTeam().getDraw() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 1);
            }
            match.setResult(result);
            match.setHomeTeamGoal(homeGoal);
            match.setAwayTeamGoal(awayGoal);
        } else if (homeSigma != 0 && awaySigma == 0) {
            NormalDistribution homeNd = new NormalDistribution(homeMean, homeSigma);
            int homeGoal = Math.round((float) homeNd.getMean());
            int awayGoal = Math.round((float) awayMean);
            char result;
            if (homeGoal > awayGoal) {
                result = 'H';
                match.getHomeTeam().setWin(match.getHomeTeam().getWin() + 1);
                match.getAwayTeam().setLose(match.getAwayTeam().getLose() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 3);
            } else if (homeGoal < awayGoal) {
                result = 'A';
                match.getHomeTeam().setLose(match.getHomeTeam().getLose() + 1);
                match.getAwayTeam().setWin(match.getAwayTeam().getWin() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 3);
            } else {
                result = 'D';
                match.getHomeTeam().setDraw(match.getHomeTeam().getDraw() + 1);
                match.getAwayTeam().setDraw(match.getAwayTeam().getDraw() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 1);
            }
            match.setResult(result);
            match.setHomeTeamGoal(homeGoal);
            match.setAwayTeamGoal(awayGoal);
        } else {
            int homeGoal = Math.round((float) homeMean);
            int awayGoal = Math.round((float) awayMean);
            char result;
            if (homeGoal > awayGoal) {
                result = 'H';
                match.getHomeTeam().setWin(match.getHomeTeam().getWin() + 1);
                match.getAwayTeam().setLose(match.getAwayTeam().getLose() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 3);
            } else if (homeGoal < awayGoal) {
                result = 'A';
                match.getHomeTeam().setLose(match.getHomeTeam().getLose() + 1);
                match.getAwayTeam().setWin(match.getAwayTeam().getWin() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 3);
            } else {
                result = 'D';
                match.getHomeTeam().setDraw(match.getHomeTeam().getDraw() + 1);
                match.getAwayTeam().setDraw(match.getAwayTeam().getDraw() + 1);
                match.getHomeTeam().setScore(match.getHomeTeam().getScore() + 1);
                match.getAwayTeam().setScore(match.getAwayTeam().getScore() + 1);
            }
            match.setResult(result);
            match.setHomeTeamGoal(homeGoal);
            match.setAwayTeamGoal(awayGoal);
        }
        return match;
    }

    public static Double getMean(Team homeTeam, Team awayTeam, Boolean b) {
        double homeSum = 0;
        double awaySum = 0;
        int num = 0;
        for (Match m : homeTeam.getHomeMatchList()) {
            if (m.getAwayTeam().getName() == awayTeam.getName()) {
                homeSum += m.getHomeTeamGoal();
                awaySum += m.getAwayTeamGoal();
                num++;
            }
        }
        double homeMean = homeSum / num;
        double awayMean = awaySum / num;
        if (b) {
            return homeMean;
        } else {
            return awayMean;
        }
    }

    public static Double getSigma(Team homeTeam, Team awayTeam, Double homeMean, Double awayMean, Boolean b) {
        double homeDev = 0;
        double awayDev = 0;
        int num = 0;
        for (Match m : homeTeam.getHomeMatchList()) {
            if (m.getAwayTeam().getName() == awayTeam.getName()) {
                homeDev += Math.pow(m.getHomeTeamGoal() - homeMean, 2);
                awayDev += Math.pow(m.getAwayTeamGoal() - awayMean, 2);
                num++;
            }
        }

        double homeSigma = Math.sqrt(homeDev / num);
        double awaySigma = Math.sqrt(awayDev / num);
        if (b) {
            return homeSigma;
        } else {
            return awaySigma;
        }
    }
}
