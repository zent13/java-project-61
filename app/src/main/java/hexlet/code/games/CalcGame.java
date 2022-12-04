package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {
    public static void game(int scoreToWin, int maxInterval, boolean mistakeFlag, int score) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");

        while (score < scoreToWin) {
            String mathSign = getMathSign(score);
            int random1 = Engine.getRandomInt(maxInterval);
            int random2 = Engine.getRandomInt(maxInterval);
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

        Engine.printAnswer(mistakeFlag, name);
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
    private static int getRightAnswer(int score, int random1, int random2) {
        if (score == 0) {
            return random1 + random2;
        } else if (score == 1) {
            return random1 - random2;
        } else {
            return random1 * random2;
        }
    }
}
