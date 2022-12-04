package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class ProgressionGame {
    public static void game(int scoreToWin, int maxInterval, boolean mistakeFlag, int score) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfProgression = 10; //progression length

        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");

        while (score < scoreToWin) {
            int startNumber = Engine.getRandomInt(maxInterval);
            int increment = Engine.getRandomInt(maxInterval);
            int skippedNumber = Engine.getRandomInt(lengthOfProgression);
            int rightAnswer = getRightAnswer(startNumber, increment, skippedNumber);

            System.out.print("Question: ");

            int currSequenceLength = startNumber;
            for (int i = 0; i < lengthOfProgression; i++) {
                if (skippedNumber != i) {
                    System.out.print(currSequenceLength + " ");
                    currSequenceLength = currSequenceLength + increment;
                } else {
                    System.out.print(".." + " ");
                    currSequenceLength = currSequenceLength + increment;
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

        Engine.printAnswer(mistakeFlag, name);
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
