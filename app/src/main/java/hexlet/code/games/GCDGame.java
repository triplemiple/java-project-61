package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class GCDGame {

    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 100;
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static int findGreatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber == secondNumber) {
            return firstNumber;
        }

        int min = Math.abs(Math.min(firstNumber, secondNumber));
        int max = Math.abs(Math.max(firstNumber, secondNumber));
        int temp;

        while (min != 0) {
            temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }

    public static GameData getGameData() {
        GameData gameData = new GameData();
        Random random = new Random();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int firstNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
            int secondNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);

            gameData.questions[i] = String.format("Question: %d %d", firstNumber, secondNumber);
            gameData.answers[i] = String.valueOf(findGreatestCommonDivisor(firstNumber, secondNumber));
        }

        gameData.gameDescription = DESCRIPTION;

        return gameData;
    }
}
