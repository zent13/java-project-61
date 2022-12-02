package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class ProgressionGame {
    public static void game() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int scoreToWin = 3;
        boolean mistakeFlag = false;
        int maxInterval = 10;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");

        while (score < scoreToWin) {
            int startNumber = Engine.getRandomInt(maxInterval);
            int increment = Engine.getRandomInt(maxInterval);
            int skippedNumber = Engine.getRandomInt(maxInterval);
            int rightAnswer = getRightAnswer(startNumber, increment, skippedNumber);

            System.out.print("Question: ");

            int currSequenceLenght = startNumber;
            for (int i = 0; i < 10; i++) {
                if (skippedNumber != i) {
                    System.out.print(currSequenceLenght + " ");
                    currSequenceLenght = currSequenceLenght + increment;
                } else {
                    System.out.print(".." + " ");
                    currSequenceLenght = currSequenceLenght + increment;
                }
            }

            System.out.println("");
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

    private static int getRightAnswer(int startNumber, int increment, int skippedNumber) {
        int answer = startNumber;
        for (int i = 0; i < skippedNumber; i++) {
            answer = answer + increment;
        }

        return answer;
    }
}
