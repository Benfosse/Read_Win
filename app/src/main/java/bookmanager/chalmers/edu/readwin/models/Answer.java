package bookmanager.chalmers.edu.readwin.models;

import java.lang.reflect.Type;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Answer {
    private int QuestionNumber;
    private String QuestionType; // Multiple, Pair
    private String MultiAnswer; // Used with Multiple choice questions
    private String[] PairAnswer; // Uset with Pairing questions

    public Answer(int questionNumber, String type, String multiAnswer, String[] pairAnswer) {
        QuestionNumber = questionNumber;
        QuestionType = type;
        MultiAnswer = multiAnswer;
        PairAnswer = pairAnswer;
    }

    public int getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        QuestionNumber = questionNumber;
    }

    public String getQuestionType() {
        return QuestionType;
    }

    public void setQuestionType(String questionType) {
        QuestionType = questionType;
    }

    public String getMultiAnswer() {
        return MultiAnswer;
    }

    public void setMultiAnswer(String multiAnswer) {
        MultiAnswer = multiAnswer;
    }

    public String[] getPairAnswer() {
        return PairAnswer;
    }

    public void setPairAnswer(String[] pairAnswer) {
        PairAnswer = pairAnswer;
    }
}
