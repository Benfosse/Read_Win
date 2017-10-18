package bookmanager.chalmers.edu.readwin.services;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Answer;
import bookmanager.chalmers.edu.readwin.models.Multiple;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.interfaces.IQuestionService;

/**
 * Created by benedikt on 13/10/2017.
 */

public class QuestionService implements IQuestionService {
    private Multiple question1 = new Multiple(1, "What is the name of the main hobbit?", "Multiple", "Random");
    private Multiple question2 = new Multiple(2, "Where are the dwarfes and the hobbit heading?", "Multiple", "Random");

    public List<Question> getBookQuestions(int bookId) {
        List<Question> questions = new ArrayList<>();

        if(bookId == 1) {
            questions.add(question1);
            questions.add(question2);
        }
        return questions;
    }

    public Question getBookQuestion(int bookId, int questionNumber) {
        if(bookId == 1 && questionNumber == 1)
            return question1;
        else if(bookId == 1 && questionNumber == 2)
            return question2;
        else
            return null;
    }

    public void answerBookQuestions(int bookId, List<Answer> answers) {

    }

}
