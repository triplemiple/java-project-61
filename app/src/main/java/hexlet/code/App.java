package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("""
                        Please enter the game number and press Enter.
                        1 - Greet
                        2 - Even
                        3 - Calc
                        4 - GCD
                        5 - Progression
                        6 - Prime
                        0 - Exit""");
                Scanner sc = new Scanner(System.in);
                int gameNumber = sc.nextInt();
                System.out.printf("Your choice: %d%n", gameNumber);

                switch (gameNumber) {
                    case 1 -> {
                        Cli.askName();
                        return;
                    }
                    case 2 -> {
                        String username = Cli.askName();
                        Engine.startGame(username, EvenGame.getGameData());
                    }
                    case 3 -> {
                        String username = Cli.askName();
                        Engine.startGame(username, CalcGame.getGameData());
                    }
                    case 4 -> {
                        String username = Cli.askName();
                        Engine.startGame(username, GCDGame.getGameData());
                    }
                    case 5 -> {
                        String username = Cli.askName();
                        Engine.startGame(username, ProgressionGame.getGameData());
                    }
                    case 6 -> {
                        String username = Cli.askName();
                        Engine.startGame(username, PrimeGame.getGameData());
                    }
                    case 0 -> {
                        return;
                    }
                    default -> {
                        System.out.println(PrintUtils.getInvalidInputPrint());
                        continue;
                    }
                }

                return;
            } catch (Exception e) {
                System.out.println(PrintUtils.getInvalidInputPrint());
            }
        }
    }
}
