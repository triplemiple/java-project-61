package hexlet.code;

public class GameData {

    public String[] getQuestions() {
        return questions;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    private final String[] questions = new String[Constants.QUESTION_COUNT];

    private final String[] answers = new String[Constants.QUESTION_COUNT];

    private String gameDescription;
}
