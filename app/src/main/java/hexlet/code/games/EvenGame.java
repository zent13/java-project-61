package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class EvenGame {
    public static void game(int scoreToWin, int maxInterval, boolean mistakeFlag, int score) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

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
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
                break;
            }
        }

        Engine.printAnswer(mistakeFlag, name);
        scanner.close();
    }

    private static String getRightAnswer(int random) {
        if (random % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
