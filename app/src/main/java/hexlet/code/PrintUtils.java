package hexlet.code;

public final class PrintUtils {

    public static String getFailPrint(String userInput, String correctAnswer, String username) {
        return String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                + "Let's try again, %s!", userInput, correctAnswer, username);
    }

    public static String getCongratulationPrint(String username) {
        return String.format("Congratulations, %s!", username);
    }

    public static String getCorrectAnswerPrint() {
        return "Correct!";
    }

    public static String getInvalidInputPrint() {
        return "Invalid input!";
    }
}
