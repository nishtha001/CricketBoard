package com.Phonepe.CricetScoreBoard;

import java.util.*;

public class ScoreBoard  {

    private static int noOfPlayer;

    private static int noOfOver;

    private static Scanner s = new Scanner(System.in);

    public static void generateScoreBoard(Team team, int over) {
        System.out.println("Player"+"-"+"Score"+"-"+"4s"+"-"+"6s"+"-"+"Balls Played");
        Player players[] = team.getPlayer();
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            System.out.println(player.getName()+"-"+player.getRuns()+"-"+player.getNoOfFour()+"-"+player.getNoOfSix()+"-"+player.getBallPlayed());
        }
        System.out.println("Total - "+ team.getTotalRun() +"/"+ team.getWicketFall());
        String overStr = "" +over/6+"."+over%6;
        System.out.println("Over - " + overStr);
    }

    public static void changePlayer(Team playingTeam) {
        Player playerA = playingTeam.getCurrentPlayingPlayer1();
        Player playerB = playingTeam.getCurrentPlayingPlayer2();
        playingTeam.setCurrentPlayingPlayer1(playerB);
        playingTeam.setCurrentPlayingPlayer2(playerA);

    }

    public static void setBattingSequence(Team playingTeam) {
        Queue<Player> q = playingTeam.getBattingSequence();
        Player players[] = new Player[noOfPlayer];
        System.out.println("Enter Batting Sequence");
        for(int i = 0; i < noOfPlayer; i++) {
            String playerName = s.next();
            Player p = new Player( i+1, playerName);
            if(q == null)
                q = new LinkedList();
            q.add(p);
            players[i] = p;
        }
        playingTeam.setBattingSequence(q);
        playingTeam.setPlayer(players);
    }

    public static void taskAfterCompletingOver(Team playingTeam, Player[] players, int totalScore, int noOfWicket, int overNo, Over over, Ball[] ballArray) {
        changePlayer(playingTeam);
        playingTeam.setPlayer(players);
        over.setBall(ballArray);
        playingTeam.setTotalRun(totalScore);
        playingTeam.setWicketFall(noOfWicket);
        generateScoreBoard(playingTeam, overNo);
    }

    public static void startGame(Team playingTeam) {
        Queue<Player> q = playingTeam.getBattingSequence();
        Player players[] = playingTeam.getPlayer();
        Player currentPlayer;
        int noOfWicket = playingTeam.getWicketFall();
        int totalScore = 0;
        int totalNoOfBall = 0;
        for(int j = 0; j < noOfOver; j++) {
            Over over = new Over();
            Ball ballArray[] = new Ball[6];
            for (int i = 0; i < 6; i++) {
                if (noOfWicket == noOfPlayer - 1)
                    break;
                System.out.println("Enter Ball");
                String b = s.next();
                int runScored = 0;
                currentPlayer = playingTeam.getCurrentPlayingPlayer1();
                Ball ball = new Ball();
                Ball.BallType ballType;
                boolean playerChange = false;
                boolean wicketFall = false;

                if (b.equals("Wd")) {
                    ballType = Ball.BallType.WIDE;
                    runScored = 1;

                } else if (b.equals("Nb")) {
                    ballType = Ball.BallType.NOBALL;
                    runScored = 1;

                } else if (b.equals("4")) {
                    ballType = Ball.BallType.FOUR;
                    runScored = 4;
                    currentPlayer.setNoOfFour(currentPlayer.getNoOfFour() + 1);

                } else if (b.equals("6")) {
                    ballType = Ball.BallType.SIX;
                    runScored = 6;
                    currentPlayer.setNoOfSix(currentPlayer.getNoOfSix() + 1);

                } else if (b.equals("W")) {
                    ballType = Ball.BallType.WICKET;
                    runScored = 0;
                    wicketFall = true;

                } else {
                    ballType = Ball.BallType.RUN;
                    runScored = Integer.parseInt(b);
                    if (b.equals("1") || b.equals("3"))
                        playerChange = true;
                }
                ball.setBallType(ballType);
                ball.setRunScored(runScored);
                ballArray[i] = ball;
                currentPlayer.setBallPlayed(currentPlayer.getBallPlayed() + 1);
                currentPlayer.setRuns(currentPlayer.getRuns() + runScored);
                players[currentPlayer.getId() - 1] = currentPlayer;
                totalScore += runScored;
                totalNoOfBall++;
                if (playerChange) {
                    changePlayer(playingTeam);
                }
                if (wicketFall) {
                    noOfWicket++;
                    if(q.isEmpty())
                        break;
                    playingTeam.setCurrentPlayingPlayer1(q.remove());
                }

            }
            playingTeam.setTotalRun(totalScore);
            taskAfterCompletingOver(playingTeam, players, totalScore, noOfWicket, totalNoOfBall, over, ballArray);
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter No of player in each team");
        noOfPlayer = s.nextInt();
        System.out.println("Enter No of Over");
        noOfOver = s.nextInt();

        Match match = new Match(noOfOver);
        Team[] teams = new Team[2];
        for(int i = 0; i < 2; i++)
            teams[i] = new Team(i, noOfPlayer, noOfOver);
        match.setTeam(teams);

        for(Team playingTeam : teams) {
            setBattingSequence(playingTeam);
            Queue<Player> q = playingTeam.getBattingSequence();
            playingTeam.setCurrentPlayingPlayer1(q.remove());
            playingTeam.setCurrentPlayingPlayer2(q.remove());
            startGame(playingTeam);
        }
        int scoreDiff = Math.abs(match.getTeam()[0].getTotalRun() - match.getTeam()[1].getTotalRun());
        if(match.getTeam()[0].getTotalRun() > match.getTeam()[1].getTotalRun()) {
            match.setWinningTeam(match.getTeam()[0]);
        }
        else
            match.setWinningTeam(match.getTeam()[1]);
        System.out.println("Team " + match.getWinningTeam().getTeamId()+ " win the match by "+ scoreDiff);

    }


}
