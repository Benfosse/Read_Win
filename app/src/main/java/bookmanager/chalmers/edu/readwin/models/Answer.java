package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Answer {
    private int QuestionNumber;
    private String Answer;

    public int getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        QuestionNumber = questionNumber;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
