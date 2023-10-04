package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void startGame(GameData gameData) {
        String username = Cli.askName();
        System.out.println(gameData.getGameDescription());
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < Constants.QUESTION_COUNT; i++) {
            GameData.GameRound round = gameData.getGameRound(i);
            System.out.println(round.question);
            String userInput = sc.next();

            boolean answerIsCorrect = userInput.equals(round.answer);

            if (!answerIsCorrect) {
                System.out.println(PrintUtils.getFailPrint(userInput, round.answer, username));
                return;
            }

            System.out.println(PrintUtils.getCorrectAnswerPrint());
        }

        System.out.println(PrintUtils.getCongratulationPrint(username));
    }
}
