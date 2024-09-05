package org.example;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Score score = new Score();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter point series:");
        String pointsWonSeries = keyboard.nextLine();
        score.updateScore(pointsWonSeries);
    }

}