package org.example;

import java.util.Map;
import java.util.Objects;

public class Score {

    private int playerAScore;
    private int playerBScore;
    private String winner;

    private final Map<Integer, String> tennisPoints = Map.of(
            0, "0",
            1, "15",
            2, "30",
            3, "40",
            4, "Ad");

    public Score() {
        playerAScore = 0;
        playerBScore = 0;
    }

    public void updateScore(String pointsWonSeries) {
        printScore();
        pointsWonSeries.chars()
                .forEach(c -> {
                    updateScore((char) c);
                    printScore();
                });
    }

    private void updateScore(char pointWinner) {
        if(Objects.nonNull(winner)) {
            throw new RuntimeException("The match has ended! we already have a winner: " + winner );
        }
        if(pointWinner == 'A') {
            incrementPlayerA();
        } else if (pointWinner == 'B'){
            incrementPlayerB();
        } else {
            throw new RuntimeException("Player " + pointWinner + " is not participating in this match!");
        }
    }

    public void printScore() {
        if(Objects.isNull(winner)) {
            System.out.println("Player A : " + tennisPoints.get(playerAScore) + "/ Player B : " + tennisPoints.get(playerBScore));
        } else {
            System.out.println(winner + " wins the game");
        }
    }

    private void incrementPlayerA() {
        switch (playerAScore) {
            case 0, 1, 2 ->  playerAScore++;
            case 3 -> {
                if(playerBScore < 3) {
                    winner = "player A";
                } else if(playerBScore == 3) {
                    playerAScore = 4;
                } else if (playerBScore == 4) {
                    playerBScore = 3;
                }
            }
            case 4 -> winner = "player A";
        }

    }

    private void incrementPlayerB() {
        switch (playerBScore) {
            case 0, 1, 2 ->  playerBScore++;
            case 3 -> {
                if(playerAScore < 3) {
                    winner = "player B";
                } else if(playerAScore == 3) {
                    playerBScore = 4;
                } else if (playerAScore == 4) {
                    playerAScore = 3;
                }
            }
            case 4 -> winner = "player B";
        }
    }

}
