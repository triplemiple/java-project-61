package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class ProgressionGame {

    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 100;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 11;
    private static final int START_RANGE_COMMON_DIFFERENCE = 1;
    private static final int END_RANGE_COMMON_DIFFERENCE = 6;
    private static final String DESCRIPTION = "What number is missing in the progression?";

    public static GameData getGameData() {
        GameData gameData = new GameData();
        Random random = new Random();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int progressionSize = random.nextInt(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int commonDifference = random.nextInt(START_RANGE_COMMON_DIFFERENCE, END_RANGE_COMMON_DIFFERENCE);
            int progressionNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
            int questionIndex = random.nextInt(0, progressionSize);
            String answerNumber = String.valueOf(progressionNumber + commonDifference * questionIndex);

            StringBuilder question = new StringBuilder();

            for (int j = 0; j < MAX_PROGRESSION_LENGTH; j++) {
                question.append(" ").append(progressionNumber);
                progressionNumber += commonDifference;
            }

            gameData.questions[i] = question.toString().trim().replace(answerNumber, "..");
            gameData.answers[i] = answerNumber;
        }

        gameData.gameDescription = DESCRIPTION;
        return gameData;
    }
}
