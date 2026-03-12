// package com.assignment.loops;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesserGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("===== Welcome to Number Guessing Game =====");

		while (true) {

			int randomNumber = random.nextInt(100) + 1;
			int maxAttempts = 5;
			boolean isGuessed = false;

			System.out.println("\nGuess the number between 1 and 100");
			System.out.println("Maximum Attempts Allowed -> " + maxAttempts);

			for (int attempts = 1; attempts <= maxAttempts; attempts++) {

				int guess = 0;

				try {
					System.out.print("Attempt " + attempts + " - Enter your guess: ");
					guess = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter only numeric values.");
					scanner.next();
					attempts--;
					continue;
				}

				if (guess < 1 || guess > 100) {
					System.out.println("Number must be between 1 and 100.");
					attempts--;
					continue;
				}

				if (guess < randomNumber) {
					System.out.println("Too Low! Try again.");
				} else if (guess > randomNumber) {
					System.out.println("Too High! Try again.");
				} else {
					System.out.println(" Congratulations! You guessed the number in " + attempts + " attempts.");
					isGuessed = true;
					break;
				}

				System.out.println("Remaining Attempts: " + (maxAttempts - attempts));
			}

			if (!isGuessed) {
				System.out.println("Game Over! The correct number was: " + randomNumber);
			}

			String playAgain;

			while (true) {
				System.out.print("\nDo you want to play again? (yes/no): ");
				playAgain = scanner.next();

				if (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("no")) {
					break;
				}

				System.out.println("Invalid choice! Please type 'yes' or 'no'.");
			}

			if (playAgain.equalsIgnoreCase("no")) {
				System.out.println("Thank you for playing! ");
				break;
			}
		}

		scanner.close();
	}
}
