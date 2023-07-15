package com.esgi.greedgherkin;

import com.esgi.greedgherkin.domain.Greed;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Greed greed = new Greed();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Greed Dice Game ===");

        boolean replay = true;
        while (replay) {
            // Ask the user for the dice values
            System.out.print("Entrez les valeurs des dés séparées par des espaces : ");
            String input = scanner.nextLine();
            String[] diceValues = input.split(" ");
            int[] dice = new int[diceValues.length];
            for (int i = 0; i < diceValues.length; i++) {
                dice[i] = Integer.parseInt(diceValues[i]);
            }

            // Calculate the score
            int score = greed.score(dice);
            System.out.println("Score : " + score);

            // Ask the user if he wants to replay
            System.out.print("Rejouer ? (O/N) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("O")) {
                replay = false;
            }
        }

        scanner.close();
    }
}