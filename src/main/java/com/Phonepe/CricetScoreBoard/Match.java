package com.Phonepe.CricetScoreBoard;

public class Match {

    private int totalOver;

    private Team[] team;

    private Over[] over;

    private Team winningTeam;

    Match(int totalOver) {
        this.totalOver = totalOver;
        team = new Team[2];
        over = new Over[totalOver];
    }

    public int getTotalOver() {
        return totalOver;
    }

    public void setTotalOver(int totalOver) {
        this.totalOver = totalOver;
    }

    public Team[] getTeam() {
        return team;
    }

    public void setTeam(Team[] team) {
        this.team = team;
    }

    public Over[] getOver() {
        return over;
    }

    public void setOver(Over[] over) {
        this.over = over;
    }

    public Team getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(Team winningTeam) {
        this.winningTeam = winningTeam;
    }

}
