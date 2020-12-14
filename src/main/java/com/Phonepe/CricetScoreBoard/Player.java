package com.Phonepe.CricetScoreBoard;

public class Player extends Score {

    private int id;

    private String name;

    private boolean isPlaying;

    public int getId() {
        return id;
    }

    Player(int id, String name) {
        this.id  = id;
        this.name  = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
