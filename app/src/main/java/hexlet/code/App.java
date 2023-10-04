package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    private static final int GREET_MENU_NUMBER = 1;
    private static final String GREET_MENU_DESCRIPTION = "Greet";
    private static final int EXIT_MENU_NUMBER = 0;
    private static final String EXIT_MENU_DESCRIPTION = "Exit";
    private static final String MENU_DESCRIPTION = "Please enter the game number and press Enter.";

    private static String formatMenu() {
        return MENU_DESCRIPTION + "\n"
                + GREET_MENU_NUMBER + " - " + GREET_MENU_DESCRIPTION + "\n"
                + EvenGame.MENU_NUMBER + " - " + EvenGame.MENU_DESCRIPTION + "\n"
                + CalcGame.MENU_NUMBER + " - " + CalcGame.MENU_DESCRIPTION + "\n"
                + GCDGame.MENU_NUMBER + " - " + GCDGame.MENU_DESCRIPTION + "\n"
                + ProgressionGame.MENU_NUMBER + " - " + ProgressionGame.MENU_DESCRIPTION + "\n"
                + PrimeGame.MENU_NUMBER + " - " + PrimeGame.MENU_DESCRIPTION + "\n"
                + EXIT_MENU_NUMBER + " - " + EXIT_MENU_DESCRIPTION;
    }

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println(formatMenu());
                Scanner sc = new Scanner(System.in);
                int gameNumber = sc.nextInt();
                System.out.printf("Your choice: %d%n", gameNumber);

                switch (gameNumber) {
                    case GREET_MENU_NUMBER -> {
                        Cli.askName();
                        return;
                    }
                    case EvenGame.MENU_NUMBER -> Engine.startGame(EvenGame.getGameData());
                    case CalcGame.MENU_NUMBER -> Engine.startGame(CalcGame.getGameData());
                    case GCDGame.MENU_NUMBER -> Engine.startGame(GCDGame.getGameData());
                    case ProgressionGame.MENU_NUMBER -> Engine.startGame(ProgressionGame.getGameData());
                    case PrimeGame.MENU_NUMBER -> Engine.startGame(PrimeGame.getGameData());
                    case EXIT_MENU_NUMBER -> {
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
