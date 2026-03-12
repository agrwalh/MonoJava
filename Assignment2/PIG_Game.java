// package com.assignments.loop;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int turn = 1;
        final int TARGET_SCORE = 20;

        System.out.println("===== PIG Dice Game =====");
        System.out.println();
        System.out.println("Rules:");
        System.out.println("1. Try to reach " + TARGET_SCORE + " points.");
        System.out.println("2. Each turn you can Roll (r) or Hold (h).");
        System.out.println("3. If you roll 1 → your turn ends and you lose turn points.");
        System.out.println("4. If you hold → your turn points are added to total score.");
        System.out.println();

        while (totalScore < TARGET_SCORE) {

            int turnScore = 0;

            System.out.println("------------");
            System.out.println("TURN " + turn);
            System.out.println("Current Total Score: " + totalScore);

            while (true) {

                System.out.print("Roll or Hold? (r/h): ");
                String choice = scanner.next().toLowerCase();

                if (choice.equals("r")) {

                    int die = random.nextInt(6) + 1;

                    System.out.println("You rolled: " + die);

                    if (die == 1) {
                        System.out.println("Oops! You rolled 1.");
                        System.out.println("Turn Over! No points added.");
                        turnScore = 0;
                        break;
                    } else {
                        turnScore += die;
                        System.out.println("Turn Score: " + turnScore);
                    }

                } else if (choice.equals("h")) {

                    totalScore += turnScore;

                    System.out.println("Turn Score Saved: " + turnScore);
                    System.out.println("Total Score: " + totalScore);
                    break;

                } else {
                    System.out.println("Invalid input! Please enter 'r' for roll or 'h' for hold.");
                }
            }

            System.out.println();
            turn++;
        }

        System.out.println(" Congratulations!");
        System.out.println("You reached the target score in " + (turn - 1) + " turns.");
        System.out.println("Game Over!");

        scanner.close();
    }
}
