package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void startGame(String username, GameData gameData) {
        System.out.println(gameData.getGameDescription());
        Scanner sc = new Scanner(System.in);
        String[] questions = gameData.getQuestions();
        String[] answers = gameData.getAnswers();

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
