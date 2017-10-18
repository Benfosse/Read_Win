package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Question {
    private int QuestionNumber;
    private String Question;
    private String Type;


    public Question(int questionNumber, String question, String type) {
        QuestionNumber = questionNumber;
        Question = question;
        Type = type;
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

    public String getType() { return Type; }

    public void setType(String type) { this.Type = type; }


}
