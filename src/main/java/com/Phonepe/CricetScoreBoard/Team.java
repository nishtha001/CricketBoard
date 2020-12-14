package com.Phonepe.CricetScoreBoard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Team {
    private int teamId;

    private int totalPlayer;

    private int totalOver;

    private Over[] over;

    private Player[] player;

    private Queue<Player> battingSequence;

    Team(int teamId, int totalPlayer, int totalOver) {
        this.teamId = teamId;
        this.totalOver = totalOver;
        this.totalPlayer = totalPlayer;
        over = new Over[totalOver];
        player = new Player[totalPlayer];
        battingSequence = new LinkedList<Player>();
    }

    private int totalRun;

    private int wicketFall;

    private boolean isWinner;

    private Player currentPlayingPlayer1;

    private Player currentPlayingPlayer2;

    public int getTotalPlayer() {
        return totalPlayer;
    }

    public void setTotalPlayer(int totalPlayer) {
        this.totalPlayer = totalPlayer;
    }

    public int getTotalOver() {
        return totalOver;
    }

    public void setTotalOver(int totalOver) {
        this.totalOver = totalOver;
    }

    public Over[] getOver() {
        return over;
    }

    public void setOver(Over[] over) {
        this.over = over;
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public int getTotalRun() {
        return totalRun;
    }

    public void setTotalRun(int totalRun) {
        this.totalRun = totalRun;
    }

    public int getWicketFall() {
        return wicketFall;
    }

    public void setWicketFall(int wicketFall) {
        this.wicketFall = wicketFall;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public Player getCurrentPlayingPlayer1() {
        return currentPlayingPlayer1;
    }

    public void setCurrentPlayingPlayer1(Player currentPlayingPlayer) {
        this.currentPlayingPlayer1 = currentPlayingPlayer;
    }

    public Player getCurrentPlayingPlayer2() {
        return currentPlayingPlayer2;
    }

    public void setCurrentPlayingPlayer2(Player currentPlayingPlayer2) {
        this.currentPlayingPlayer2 = currentPlayingPlayer2;
    }

    public Queue<Player> getBattingSequence() {
        return battingSequence;
    }

    public void setBattingSequence(Queue<Player> battingSequence) {
        this.battingSequence = battingSequence;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
