package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class CalcGame {
    public static void game() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean mistakeFlag = false;
        int maxInterval = 10;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");

        while (score < 3) {
            String mathSign = getMathSign(score);
            int random1 = getRandomInt(maxInterval);
            int random2 = getRandomInt(maxInterval);
            int rightAnswer = getRightAnswer(score, random1, random2);

            System.out.print("Question: ");
            System.out.println(random1 + " " + mathSign + " " + random2);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (Integer.parseInt(answer) == rightAnswer) {
                score++;
                System.out.println("Correct!");
            } else {
                mistakeFlag = true;
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
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

    private static String getMathSign(int score) {
        if (score == 0) {
            return "+";
        } else if (score == 1) {
            return "-";
        } else {
            return "*";
        }
    }
    private static int getRandomInt (int maxInterval) {
        Random random = new Random();
        return random.nextInt(1, maxInterval);
    }
    private static int getRightAnswer (int score, int random1, int random2) {
        if (score == 0) {
            return random1 + random2;
        } else if (score == 1) {
            return random1 - random2;
        } else {
            return random1 * random2;
        }
    }
}
