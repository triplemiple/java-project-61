package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class CalcGame {

    private static final int START_RANGE_NUMBER = 0;
    private static final int END_RANGE_NUMBER = 100;
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final String[] OPERATIONS = {"+", "-", "*"};

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
        Random random = new Random();
        GameData gameData = new GameData();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int firstNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
            int secondNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
            String operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

            gameData.questions[i] = String.format("Question: %d %s %d", firstNumber, operation, secondNumber);
            gameData.answers[i] = String.valueOf(compute(operation, firstNumber, secondNumber));
        }

        gameData.gameDescription = DESCRIPTION;
        return gameData;
    }
}
