package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Answer;
import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.MultipleQuestion;
import bookmanager.chalmers.edu.readwin.models.PairQuestion;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.QuestionService;

public class PairQuestionFragment extends Fragment {

    private View rootView;

    FloatingActionButton next, prev;
    int question_index, n_of_questions;
    TextView Option1, Option2, Option3, Option4, OptionA, OptionB, OptionC, OptionD, Question;
    private Question currentQuestion;
    private Book currentBook;

    public PairQuestionFragment() {
    }

    public static PairQuestionFragment newInstance(int questionIndex, int questionsSize, Question question, Book book) {
        PairQuestionFragment fragment = new PairQuestionFragment();
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

        rootView = inflater.inflate(R.layout.fragment_questionnaire_pair, container, false);

        Bundle bundle = this.getArguments();
        if(bundle != null) {
            question_index = bundle.getInt("QuestionIndex");
            n_of_questions = bundle.getInt("QuestionsSize");
            currentQuestion = bundle.getParcelable("Question");
            currentBook = bundle.getParcelable("Book");
        }

        PairQuestion pQuestion = currentQuestion.getPair();

        TextView title = rootView.findViewById(R.id.pairQuestionTitle);
        Question = (TextView) rootView.findViewById(R.id.pairQuestion);
        Option1 = (TextView) rootView.findViewById(R.id.option1);
        Option2 = (TextView) rootView.findViewById(R.id.option2);
        Option3 = (TextView) rootView.findViewById(R.id.option3);
        Option4 = (TextView) rootView.findViewById(R.id.option4);
        OptionA = (TextView) rootView.findViewById(R.id.optionA);
        OptionB = (TextView) rootView.findViewById(R.id.optionB);
        OptionC = (TextView) rootView.findViewById(R.id.optionC);
        OptionD = (TextView) rootView.findViewById(R.id.optionD);
        Button finishQuestionsButton = rootView.findViewById(R.id.finishedWithQuestionsButton);

        title.setText(currentBook.getTitle());
        Question.setText(pQuestion.getHeading());

        String[] letters = pQuestion.getLetterColumn();
        Option1.setText(letters[0]);
        Option2.setText(letters[1]);
        Option3.setText(letters[2]);
        Option4.setText(letters[3]);

        String[] numbers = pQuestion.getNumberColumn();
        OptionA.setText(numbers[0]);
        OptionB.setText(numbers[1]);
        OptionC.setText(numbers[2]);
        OptionD.setText(numbers[3]);

        Disable(OptionA);
        Disable(OptionB);
        Disable(OptionC);
        Disable(OptionD);

        Option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.BOLD);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
                Enable(OptionA);
                Enable(OptionB);
                Enable(OptionC);
                Enable(OptionD);
            }
        });
        Option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.BOLD);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });
        Option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.BOLD);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });
        Option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.BOLD);
            }
        });

        OptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });

        OptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });

        OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });

        OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });


        next = (FloatingActionButton) rootView.findViewById(R.id.next_Button);
        prev = (FloatingActionButton) rootView.findViewById(R.id.prev_Button);

        // Greying out prev button if it's the first question
        if(question_index <= 0) {
            prev.setAlpha(.5f);
            prev.setClickable(false);
        }

        // Greying out next button if it's the last question
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
                int points = questionService.answerBookQuestions(currentBook.getId(), answers);
                getActivity().finish();
                Toast.makeText(getContext(), "You got x out of " + n_of_questions + " questions correct! Congratulation you have earned your self " + points + " points!" , Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void Enable(TextView text) {
        text.setTextColor(Color.parseColor("#000000"));
        text.setEnabled(true);
    }

    private void Disable(TextView text) {
        text.setTextColor(Color.parseColor("#9d9c9e"));
       text.setEnabled(false);
    }

}
