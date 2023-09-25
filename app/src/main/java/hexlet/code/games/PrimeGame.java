package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class PrimeGame {

    public static final int MENU_NUMBER = 6;
    public static final String MENU_DESCRIPTION = "Prime";
    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 20;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static boolean numberIsPrime(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("Number %d is not natural", number));
        }

        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        int lastDivider = (int) Math.ceil(Math.sqrt(number));

        for (int i = 2; i <= lastDivider; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static GameData getGameData() {
        Random random = new Random();
        GameData gameData = new GameData();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int randomNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
            gameData.getQuestions()[i] = String.format("Question: %d", randomNumber);
            gameData.getAnswers()[i] = numberIsPrime(randomNumber) ? "yes" : "no";
        }

        gameData.setGameDescription(DESCRIPTION);
        return gameData;
    }
}
