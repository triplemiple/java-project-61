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

    private static int[] getProgresison() {
        Random random = new Random();
        int progressionSize = random.nextInt(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int commonDifference = random.nextInt(START_RANGE_COMMON_DIFFERENCE, END_RANGE_COMMON_DIFFERENCE);
        int progressionNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
        int[] progression = new int[progressionSize];

        for (int i = 0; i < progression.length; i++) {
            progression[i] = progressionNumber;
            progressionNumber += commonDifference;
        }

        return progression;
    }

    private static int getQuestionIndex(int progressionSize) {
        Random random = new Random();
        return random.nextInt(0, progressionSize);
    }

    private static GameData.GameRound getGameRound(int[] progression, int questionIndex) {
        String[] progressionStringArray = new String[progression.length];

        for (int i = 0; i < progressionStringArray.length; i++) {
            progressionStringArray[i] = i == questionIndex ? ".." : String.valueOf(progression[i]);
        }

        String progressionString = String.join(" ", progressionStringArray);
        String question = String.format("Question: %s", progressionString);
        String answer = String.valueOf(progression[questionIndex]);
        return new GameData.GameRound(question, answer);
    }


    public static GameData getGameData() {
        GameData gameData = new GameData();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int[] progression = getProgresison();
            int questionIndex = getQuestionIndex(progression.length);
            GameData.GameRound gameRound = getGameRound(progression, questionIndex);
            gameData.setGameRound(i, gameRound);
        }

        gameData.setGameDescription(DESCRIPTION);
        return gameData;
    }
}
