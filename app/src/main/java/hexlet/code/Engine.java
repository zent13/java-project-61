package hexlet.code;

import java.util.Random;
import java.util.Scanner;
import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GCD;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.Prime;


public class Engine {
    public static void startGame() {
        Scanner scannerGame = new Scanner(System.in);

        final int greatGame = 1; //GreatGame
        final int evenGame = 2; //evenGame
        final int calcGame = 3; //calcGame
        final int gcdGame = 4; //gcdGame
        final int progressionGame = 5; //progressionGame
        final int primeGame = 6; //primeGame

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        int gameNum = Integer.parseInt(scannerGame.next());

        switch (gameNum) {
            case greatGame -> Cli.whatYourName();
            case evenGame -> EvenGame.game();
            case calcGame -> CalcGame.game();
            case gcdGame -> GCD.game();
            case progressionGame -> ProgressionGame.game();
            case primeGame -> Prime.game();
            default -> System.out.print("BB!");
        }
/*
        if (gameNum == 0) {
            System.out.print("BB!");
        } else if (gameNum == 1) {
            Cli.whatYourName();
        } else if (gameNum == 2) {
            EvenGame.game();
        } else if (gameNum == 3) {
            CalcGame.game();
        } else if (gameNum == 4) {
            GCD.game();
        } else if (gameNum == 5) {
            ProgressionGame.game();
        } else if (gameNum == 6) {
            Prime.game();
        } else {
            System.out.print("Sorry, i don't know this number, bb!");
        }

 */

        scannerGame.close();
    }

    public static int getRandomInt(int maxInterval) {
        Random random = new Random();
        return random.nextInt(1, maxInterval);
    }

    public static void printAnswer(boolean mistakeFlag, String name) {
        if (!mistakeFlag) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
    }
}
