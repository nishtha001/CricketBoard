package com.Phonepe.CricetScoreBoard;

import java.io.Serializable;

public class Ball {

    public static enum BallType {
        WICKET, RUN, WIDE, NOBALL, FOUR, SIX;

    }

    private int runScored;

    private BallType ballType;

    public int getRunScored() {
        return runScored;
    }

    public void setRunScored(int runScored) {
        this.runScored = runScored;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }
}
