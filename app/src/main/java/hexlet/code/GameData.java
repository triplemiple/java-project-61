package hexlet.code;

public final class GameData {

    private final GameRound[] gameRound = new GameRound[Constants.QUESTION_COUNT];

    private String gameDescription = "Empty description";

    public void setGameRound(int roundNumber, String question, String answer) {
        this.gameRound[roundNumber] = new GameRound(question, answer);
    }

    public GameRound getGameRound(int roundNumber) {
        return this.gameRound[roundNumber];
    }

    public void setGameDescription(String gameDescriptionParam) {
        this.gameDescription = gameDescriptionParam;
    }

    public String getGameDescription() {
        return this.gameDescription;
    }

    public static final class GameRound {

        private final String question;
        private final String answer;

        GameRound(String questionArg, String answerArg) {
            this.question = questionArg;
            this.answer = answerArg;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
