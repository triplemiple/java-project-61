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

    public static GameData getGameData() {
        Random random = new Random();
        GameData gameData = new GameData();

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            int randomNumber = random.nextInt(START_RANGE_NUMBER, END_RANGE_NUMBER);
            boolean numberIsEven = randomNumber % 2 == 0;

            String question = String.format("Question: %d", randomNumber);
            String answer = numberIsEven ? "yes" : "no";
            gameData.setGameRound(i, question, answer);
        }

        gameData.setGameDescription(DESCRIPTION);
        return gameData;
    }
}
