package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Question {
    private int QuestionNumber;
    private String Question;

    public Question(int questionNumber, String question) {
        QuestionNumber = questionNumber;
        Question = question;
    }

    public int getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        QuestionNumber = questionNumber;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}
