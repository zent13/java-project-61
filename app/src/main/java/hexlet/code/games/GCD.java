package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class GCD {
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
        System.out.println("Find the greatest common divisor of given numbers.");

        while (score < scoreToWin) {
            int random1 = Engine.getRandomInt(maxInterval);
            int random2 = Engine.getRandomInt(maxInterval);
            int rightAnswer = getRightAnswer(random1, random2);

            System.out.print("Question: ");
            System.out.println(random1 + " " + random2);
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

    private static int getRightAnswer(int random1, int random2) {
        while (random1 != random2) {
            if (random1 > random2) {
                random1 = random1 - random2;
            } else {
                random2 = random2 - random1;
            }
        }

        return random2;
    }

}
