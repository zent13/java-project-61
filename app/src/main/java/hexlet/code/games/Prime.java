package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {
    public static void game(int scoreToWin, int maxInterval, boolean mistakeFlag, int score) {
        Scanner scanner = new Scanner(System.in);

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
                System.out.print("'" + answer + "'" + " is wrong answer ;(. Correct answer was " + "'" + rightAnswer + "'.");
                break;
            }
        }

        Engine.printAnswer(mistakeFlag, name);
        scanner.close();
    }

    private static String getRightAnswer(int random) {
        boolean isPrime = true;

        if (random == 1) {
            isPrime = false;
        } else {
            for (int i = 2; i < random; i++) {
                if (random % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime ? "yes" : "no";
    }

}
