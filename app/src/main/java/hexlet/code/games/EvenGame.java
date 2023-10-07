package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class EvenGame {

    public static final int MENU_NUMBER = 2;
    public static final String MENU_DESCRIPTION = "Even";
    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 100;
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
    }

    private static boolean numberIsEven(int number) {
        return number % 2 == 0;
    }

    private static GameData.GameRound getGameRound(int number) {
        String question = String.format("Question: %d", number);
        String answer = numberIsEven(number) ? "yes" : "no";
        return new GameData.GameRound(question, answer);
    }

    public static GameData getGameData() {
        GameData gameData = new GameData();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int number = getRandomNumber();
            GameData.GameRound gameRound = getGameRound(number);
            gameData.setGameRound(i, gameRound);
        }

        gameData.setGameDescription(DESCRIPTION);
        return gameData;
    }
}
