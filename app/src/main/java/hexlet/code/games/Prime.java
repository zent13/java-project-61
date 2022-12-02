package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {
    public static void game() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int scoreToWin = 3;
        boolean mistakeFlag = false;
        int maxInterval = 100;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (score < scoreToWin) {
            int random = Engine.getRandomInt(maxInterval);
            String rightAnswer = getRightAnswer(random);

            System.out.print("Question: ");
            System.out.println(random);
            System.out.print("Your answer (yes/no): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase(rightAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                mistakeFlag = true;
                System.out.print("'" + answer + "'" + " is wrong answer ;(. ");
                System.out.println("Correct answer was " + "'" + rightAnswer + "'.");
                break;
            }
        }

        if (!mistakeFlag) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
        scanner.close();
    }

    private static String getRightAnswer(int random) {
        boolean isPrime = true;
        for (int i = 2; i < random; i++) {
            if (random == 1 || random % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime ? "yes" : "no";
    }

}
