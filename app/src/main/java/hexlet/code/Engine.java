package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void startGame(String username, GameData gameData) {
        System.out.println(gameData.gameDescription);
        Scanner sc = new Scanner(System.in);
        String[] questions = gameData.questions;
        String[] answers = gameData.answers;

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            System.out.println(questions[i]);
            String userInput = sc.next();

            boolean answerIsCorrect = userInput.equals(answers[i]);

            if (!answerIsCorrect) {
                System.out.println(PrintUtils.getFailPrint(userInput, answers[i], username));
                return;
            }

            System.out.println(PrintUtils.getCorrectAnswerPrint());
        }

        System.out.println(PrintUtils.getCongratulationPrint(username));
    }
}
