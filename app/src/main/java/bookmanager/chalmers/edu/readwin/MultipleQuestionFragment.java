package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bookmanager.chalmers.edu.readwin.models.Answer;
import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.MultipleQuestion;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.QuestionService;
import bookmanager.chalmers.edu.readwin.services.UserService;

public class MultipleQuestionFragment extends Fragment {

    private View rootView;

    RadioButton ans1, ans2, ans3, ans4;
    TextView question;
    FloatingActionButton next, prev;
    int question_index, n_of_questions;
    Question currentQuestion;
    Book currentBook;
    User currentUser;

    public MultipleQuestionFragment() {
        // Required empty public constructor
    }

    public static MultipleQuestionFragment newInstance(int questionIndex, int questionsSize, Question question, Book book) {
        MultipleQuestionFragment fragment = new MultipleQuestionFragment();
        Bundle args = new Bundle();
        args.putInt("QuestionIndex", questionIndex);
        args.putInt("QuestionsSize", questionsSize);
        args.putParcelable("Question", question);
        args.putParcelable("Book", book);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_questionnaire_multiplechoice, container, false);

        UserService userService = new UserService(getContext());
        currentUser = userService.getCurrentUser();

        Bundle bundle = this.getArguments();
        if(bundle != null) {
            question_index = bundle.getInt("QuestionIndex");
            n_of_questions = bundle.getInt("QuestionsSize");
            currentQuestion = bundle.getParcelable("Question");
            currentBook = bundle.getParcelable("Book");
        }

        MultipleQuestion mQuestion = currentQuestion.getMultiple();

        TextView title = rootView.findViewById(R.id.multipleQuestionTitle);
        question = (TextView) rootView.findViewById(R.id.multipleQuestion);
        ans1 = (RadioButton) rootView.findViewById(R.id.radioButton1);
        ans2 = (RadioButton) rootView.findViewById(R.id.radioButton2);
        ans3 = (RadioButton) rootView.findViewById(R.id.radioButton3);
        ans4 = (RadioButton) rootView.findViewById(R.id.radioButton4);
        next = (FloatingActionButton) rootView.findViewById(R.id.next_Button);
        prev = (FloatingActionButton) rootView.findViewById(R.id.prev_Button);
        Button finishQuestionsButton = rootView.findViewById(R.id.finishedWithQuestionsButton);

        title.setText(currentBook.getTitle());
        question.setText(mQuestion.getQuestion());

        String[] options = mQuestion.getOptions();
        ans1.setText(options[0]);
        ans2.setText(options[1]);
        ans3.setText(options[2]);
        ans4.setText(options[3]);

        // Initializing answers to false unless they have been answered before
        Answer answer = getAnswer();
        if(answer == null) {
            ans1.setChecked(false);
            ans2.setChecked(false);
            ans3.setChecked(false);
            ans4.setChecked(false);
        }
        else {
            if(answer.getAnswer().equals(options[0]))
                ans1.setChecked(true);
            else
                ans1.setChecked(false);

            if(answer.getAnswer().equals(options[1]))
                ans2.setChecked(true);
            else
                ans2.setChecked(false);

            if(answer.getAnswer().equals(options[2]))
                ans3.setChecked(true);
            else
                ans3.setChecked(false);

            if(answer.getAnswer().equals(options[3]))
                ans4.setChecked(true);
            else
                ans4.setChecked(false);
        }



        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(true);
                ans2.setChecked(false);
                ans3.setChecked(false);
                ans4.setChecked(false);
                saveAnswer(ans1.getText().toString());
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(true);
                ans3.setChecked(false);
                ans4.setChecked(false);
                saveAnswer(ans2.getText().toString());
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(false);
                ans3.setChecked(true);
                ans4.setChecked(false);
                saveAnswer(ans3.getText().toString());
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(false);
                ans3.setChecked(false);
                ans4.setChecked(true);
                saveAnswer(ans4.getText().toString());
            }
        });


        if(question_index <= 0) {
            prev.setAlpha(.5f);
            prev.setClickable(false);
        }

        if(question_index == (n_of_questions - 1))
        {
            next.setAlpha(.5f);
            next.setClickable(false);
            finishQuestionsButton.setVisibility(View.VISIBLE);
        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question_index < (n_of_questions - 1))
                    ((QuestionsActivity)getActivity()).setCurrentQuestion(question_index + 1, true);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question_index > 0)
                    ((QuestionsActivity)getActivity()).setCurrentQuestion(question_index - 1, true);
            }
        });

        finishQuestionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionService questionService = new QuestionService();
                List<Answer> answers = new ArrayList<Answer>();
                markQuestionsFinished();
                int score = gradeQuestions();
                getActivity().finish();
                Toast.makeText(getContext(), "Congratulation you have earned your self " + score + " points!" , Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private int gradeQuestions() {
        QuestionService answerService = new QuestionService();
        List<Answer> answers = getAnswers();

        int score = answerService.answerBookQuestions(currentBook.getId(), answers);

        currentUser.setCurrentScore(currentUser.getCurrentScore() + score);
        UserService userService = new UserService(getContext());
        userService.modifyCurrentUser(currentUser);
        return score;
    }

    private void markQuestionsFinished() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("questionsAnswered", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        // User Id - Book Id
        editor.putString(currentUser.getId() + "-" + currentBook.getId(), "Finished");
        editor.commit();
    }

    private void saveAnswer(String answer) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("questions", Context.MODE_PRIVATE);

        List<Answer> answers = getAnswers();
        Answer currentAnswer = getAnswer();

        if(currentAnswer != null) {
            for(int i = 0; i < answers.size(); i++) {
                Answer a = answers.get(i);
                if(a.getQuestionNumber() == currentAnswer.getQuestionNumber())
                    answers.remove(i);
            }
        }

        Answer answerObject = new Answer(question_index, answer);
        answers.add(answerObject);

        Gson gson = new Gson();
        String serializedAnswer = gson.toJson(answerObject);
        String serializedAnswers = gson.toJson(answers);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        // User Id - Book Id - Question Id
        editor.remove(currentUser.getId() + "-" + currentBook.getId() + "-" + question_index);
        editor.putString(currentUser.getId() + "-" + currentBook.getId() + "-" + question_index, serializedAnswer);

        editor.remove(currentUser.getId() + "-" + currentBook.getId());
        editor.putString(currentUser.getId() + "-" + currentBook.getId(), serializedAnswers);

        editor.commit();
    }

    private Answer getAnswer() {
        SharedPreferences sharedpreferences = getContext().getSharedPreferences("questions", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        return gson.fromJson(sharedpreferences.getString(currentUser.getId() + "-" + currentBook.getId() + "-" + question_index, ""), Answer.class);
    }

    private List<Answer> getAnswers() {
        SharedPreferences sharedpreferences = getContext().getSharedPreferences("questions", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String list = sharedpreferences.getString(currentUser.getId() + "-" + currentBook.getId(), "");
        Type answerListType = new TypeToken<List<Answer>>() {}.getType();
        List<Answer> answerList = gson.fromJson(list, answerListType);
        if(answerList == null)
            return new ArrayList<Answer>();
        return answerList;
    }
}
