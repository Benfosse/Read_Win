package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    RadioButton Option1, Option2, Option3, Option4, OptionA, OptionB, OptionC, OptionD;
    TextView Question;
    private Question currentQuestion;
    private Book currentBook;
    private Integer[] answer = new Integer[4];
    private int number_selected = -1;
    private int letter_selected = -1;
    private Boolean[] array_letters_selected = {false, false, false, false};


    MyImageView imageView;

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
        Option1 = (RadioButton) rootView.findViewById(R.id.option1);
        Option2 = (RadioButton) rootView.findViewById(R.id.option2);
        Option3 = (RadioButton) rootView.findViewById(R.id.option3);
        Option4 = (RadioButton) rootView.findViewById(R.id.option4);
        OptionA = (RadioButton) rootView.findViewById(R.id.optionA);
        OptionB = (RadioButton) rootView.findViewById(R.id.optionB);
        OptionC = (RadioButton) rootView.findViewById(R.id.optionC);
        OptionD = (RadioButton) rootView.findViewById(R.id.optionD);
        Button finishQuestionsButton = rootView.findViewById(R.id.finishedWithQuestionsButton);
        imageView = (MyImageView) rootView.findViewById(R.id.draw);


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

        for(int i=0; i < 4; i++)
            answer[i] = -1;


        Option1.setChecked(false);
        Option2.setChecked(false);
        Option3.setChecked(false);
        Option4.setChecked(false);
        OptionA.setChecked(false);
        OptionB.setChecked(false);
        OptionC.setChecked(false);
        OptionD.setChecked(false);



        Option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number_selected != 0) {
                    number_selected = 0;
                    update();
                }
                else {
                    number_selected = -1;
                    update();
                }

            }
        });
        Option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number_selected != 1) {
                    number_selected = 1;
                    update();
                }
                else {
                    number_selected = -1;
                    update();
                }
            }
        });
        Option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number_selected != 2) {
                    number_selected = 2;
                    update();
                }
                else {
                    number_selected = -1;
                    update();
                }
            }
        });
        Option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number_selected != 3) {
                    number_selected = 3;
                    update();
                }
                else {
                    number_selected = -1;
                    update();
                }
            }
        });

        OptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(letter_selected != 0) {
                    letter_selected = 0;
                    update();
                }
                else {
                    letter_selected = -1;
                    update();
                }
            }
        });

        OptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(letter_selected != 1) {
                    letter_selected = 1;
                    update();
                }
                else {
                    letter_selected = -1;
                    update();
                }
            }
        });

        OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(letter_selected != 2) {
                    letter_selected = 2;
                    update();
                }
                else {
                    letter_selected = -1;
                    update();
                }
            }
        });

        OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(letter_selected != 3) {
                    letter_selected = 3;
                    update();
                }
                else {
                    letter_selected = -1;
                    update();
                }
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

    private void update() {

        RegisterAnswers();
        CheckButtons();
        PrintLines();
    }

    private void RegisterAnswers() {

        if((number_selected != -1) && (letter_selected != -1)) {
            answer[number_selected] = -1;
            for(int i = 0; i < 4; i++) {
                if (answer[i] == letter_selected) {
                    answer[i] = -1;
                    break;
                }
            }
            answer[number_selected] = letter_selected;
            number_selected = -1;
            letter_selected = -1;
        }

        else if(number_selected != -1 && letter_selected == -1)
            answer[number_selected] = -1;

        else if (number_selected == -1 && letter_selected != -1) {
            for(int i = 0; i < 4; i++) {
                if (answer[i] == letter_selected) {
                    answer[i] = -1;
                    break;
                }
            }
        }
    }

    private void PrintLines() {
        Float[][] Coords_number = new Float[4][2];
        Float[][] Coords_letter = new Float[4][2];

        Coords_number[0][0] = Option1.getX() + Option1.getWidth() - 10;
        Coords_number[0][1] = Option1.getY() + Option1.getHeight() - 10;
        Coords_number[1][0] = Option2.getX() + Option2.getWidth() - 10;
        Coords_number[1][1] = Option2.getY() + Option2.getHeight() - 10;
        Coords_number[2][0] = Option3.getX() + Option3.getWidth() - 10;
        Coords_number[2][1] = Option3.getY() + Option3.getHeight() - 10;
        Coords_number[3][0] = Option4.getX() + Option4.getWidth() - 10;
        Coords_number[3][1] = Option4.getY() + Option4.getHeight() - 10;

        Coords_letter[0][0] = OptionA.getX();
        Coords_letter[0][1] = OptionA.getY() + OptionA.getHeight() - 15;
        Coords_letter[1][0] = OptionB.getX();
        Coords_letter[1][1] = OptionB.getY() + OptionA.getHeight() - 15;
        Coords_letter[2][0] = OptionC.getX();
        Coords_letter[2][1] = OptionC.getY() + OptionA.getHeight() - 15 ;
        Coords_letter[3][0] = OptionD.getX();
        Coords_letter[3][1] = OptionD.getY() + OptionA.getHeight() - 15;

        imageView.setCoords_number(Coords_number);
        imageView.setCoords_letter(Coords_letter);
        imageView.setAnswers(answer);
        imageView.invalidate();
    }

    private void CheckButtons() {

        if((number_selected == 0) || (answer[0] != -1))
            Option1.setChecked(true);
        else
            Option1.setChecked(false);

        if((number_selected == 1) || (answer[1] != -1))
            Option2.setChecked(true);
        else
            Option2.setChecked(false);

        if((number_selected == 2) || (answer[2] != -1))
            Option3.setChecked(true);
        else
            Option3.setChecked(false);

        if((number_selected == 3) || (answer[3] != -1))
            Option4.setChecked(true);
        else
            Option4.setChecked(false);

        for(int i = 0; i < 4; i++)
            array_letters_selected[i] = false;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++)
                if (answer[i] == j) {
                    array_letters_selected[j] = true;
                    break;
                }
        }

        if((letter_selected == 0) || array_letters_selected[0])
            OptionA.setChecked(true);
        else
            OptionA.setChecked(false);

        if((letter_selected == 1) || array_letters_selected[1])
            OptionB.setChecked(true);
        else
            OptionB.setChecked(false);

        if((letter_selected == 2) || array_letters_selected[2])
            OptionC.setChecked(true);
        else
            OptionC.setChecked(false);

        if((letter_selected == 3) || array_letters_selected[3])
            OptionD.setChecked(true);
        else
            OptionD.setChecked(false);
    }

}
