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
        final int scoreToWin = 3; //player win, when player rich this number of score
        boolean mistakeFlag = false;
        final int maxInterval = 100; //level to genereating random number

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
            case evenGame -> EvenGame.game(scoreToWin, maxInterval, mistakeFlag);
            case calcGame -> CalcGame.game(scoreToWin, maxInterval, mistakeFlag);
            case gcdGame -> GCD.game(scoreToWin, maxInterval, mistakeFlag);
            case progressionGame -> ProgressionGame.game(scoreToWin, maxInterval, mistakeFlag);
            case primeGame -> Prime.game(scoreToWin, maxInterval, mistakeFlag);
            default -> System.out.print("BB!");
        }

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
