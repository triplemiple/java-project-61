package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class GCDGame {

    public static final int MENU_NUMBER = 4;
    public static final String MENU_DESCRIPTION = "GCD";
    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 100;
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static int findGreatestCommonDivisor(int[] numbers) {
        if (numbers[0] == numbers[1]) {
            return numbers[0];
        }

        int min = Math.abs(Math.min(numbers[0], numbers[1]));
        int max = Math.abs(Math.max(numbers[0], numbers[1]));
        int temp;

        while (min != 0) {
            temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }

    private static int[] getRandomNumbers() {
        Random random = new Random();
        int firstNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
        int secondNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
        return new int[]{firstNumber, secondNumber};
    }

    private static GameData.GameRound getGameRound(int[] numbers) {
        String question = String.format("Question: %d %d", numbers[0], numbers[1]);
        String answer = String.valueOf(findGreatestCommonDivisor(numbers));
        return new GameData.GameRound(question, answer);
    }

    public static GameData getGameData() {
        GameData gameData = new GameData();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int[] numbers = getRandomNumbers();
            GameData.GameRound gameRound = getGameRound(numbers);
            gameData.setGameRound(i, gameRound);
        }

        gameData.setGameDescription(DESCRIPTION);
        return gameData;
    }
}
