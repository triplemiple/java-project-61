package hexlet.code;

public final class GameData {

    public String[] getQuestions() {
        return questions;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getGameDescription() {
        return this.gameDescription;
    }

    public void setGameDescription(String gameDescriptionParam) {
        this.gameDescription = gameDescriptionParam;
    }

    private final String[] questions = new String[Constants.QUESTION_COUNT];

    private final String[] answers = new String[Constants.QUESTION_COUNT];

    private String gameDescription = "Empty description";
}
