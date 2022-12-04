package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class EvenGame {
    public static void game(int scoreToWin, int maxInterval, boolean mistakeFlag) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (score < scoreToWin) {
            int random = Engine.getRandomInt(maxInterval);

            System.out.print("Question: ");
            System.out.println(random);
            System.out.print("Your answer (yes/no): ");
            String answer = scanner.next();

            if (random % 2 == 0 && answer.equalsIgnoreCase("yes")) {
                score++;
                System.out.println("Correct!");
            } else if (random % 2 == 0) {
                mistakeFlag = true;
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'yes'.");
                break;
            } else if (random % 2 != 0 && answer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
                score++;
            } else {
                mistakeFlag = true;
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'no'.");
                break;
            }
        }

        Engine.printAnswer(mistakeFlag, name);
        scanner.close();
    }
}
