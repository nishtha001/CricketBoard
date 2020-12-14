package com.Phonepe.CricetScoreBoard;

public class Over {

    private Ball ball[];

    Over() {
        ball = new Ball[6];
    }

    public Ball[] getBall() {
        return ball;
    }

    public void setBall(Ball[] ball) {
        this.ball = ball;
    }
}
