package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.GameData;

import java.util.Random;

public class ProgressionGame {

    public static final int MENU_NUMBER = 5;
    public static final String MENU_DESCRIPTION = "Progression";
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
            int progressionEndNumber = progressionNumber + commonDifference * progressionSize;
            int questionIndex = random.nextInt(0, progressionSize);
            int answerNumber = progressionNumber + commonDifference * questionIndex;

            StringBuilder question = new StringBuilder();

            do {
                String toInsert = progressionNumber == answerNumber ? ".." : String.valueOf(progressionNumber);
                question.append(" ").append(toInsert).append(" ");
                progressionNumber += commonDifference;
            } while (progressionNumber <= progressionEndNumber);

            gameData.setGameRound(i, question.toString().trim(), String.valueOf(answerNumber));
        }

        gameData.setGameDescription(DESCRIPTION);
        return gameData;
    }
}
