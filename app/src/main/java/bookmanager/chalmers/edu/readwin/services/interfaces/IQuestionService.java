package bookmanager.chalmers.edu.readwin.services.interfaces;

import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Answer;
import bookmanager.chalmers.edu.readwin.models.Question;

/**
 * Created by benedikt on 12/10/2017.
 */

public interface IQuestionService {
    List<Question> getBookQuestions(int bookId);
    Question getBookQuestion(int bookId, int questionNumber);
    int answerBookQuestions(int bookId, List<Answer> answers);
}
