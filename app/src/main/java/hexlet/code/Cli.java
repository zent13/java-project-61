package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void whatYourName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        scanner.close();
    }
}
