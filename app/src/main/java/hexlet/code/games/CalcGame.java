package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class CalcGame {

    public static final int MENU_NUMBER = 3;
    public static final String MENU_DESCRIPTION = "Calc";
    private static final int START_RANGE_NUMBER = 0;
    private static final int END_RANGE_NUMBER = 100;
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final String[] OPERATIONS = {"+", "-", "*"};

    private static int[] getRandomNumbers() {
        Random random = new Random();
        int firstNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
        int secondNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
        return new int[]{firstNumber, secondNumber};
    }

    private static String getRandomOperation() {
        Random random = new Random();
        return OPERATIONS[random.nextInt(OPERATIONS.length)];
    }

    private static GameData.GameRound getGameRound(int[] numbers, String operation) {
        String question = String.format("Question: %d %s %d", numbers[0], operation, numbers[1]);
        String answer = String.valueOf(compute(operation, numbers[0], numbers[1]));
        return new GameData.GameRound(question, answer);
    }

    private static int compute(String operation, int firstNumber, int secondNumber) {
        switch (operation) {
            case "+" -> {
                return firstNumber + secondNumber;
            }
            case "-" -> {
                return firstNumber - secondNumber;
            }
            case "*" -> {
                return firstNumber * secondNumber;
            }
            default -> throw new IllegalArgumentException(
                    String.format("No compute action for operation '%s'", operation));
        }
    }

    public static GameData getGameData() {
        GameData gameData = new GameData();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int[] numbers = getRandomNumbers();
            String operation = getRandomOperation();
            GameData.GameRound gameRound = getGameRound(numbers, operation);
            gameData.setGameRound(i, gameRound);
        }

        gameData.setGameDescription(DESCRIPTION);
        return gameData;
    }
}
