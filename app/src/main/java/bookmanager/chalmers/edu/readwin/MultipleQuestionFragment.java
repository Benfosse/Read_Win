package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.MultipleQuestion;
import bookmanager.chalmers.edu.readwin.models.Question;

public class MultipleQuestionFragment extends Fragment {

    private View rootView;

    RadioButton ans1, ans2, ans3, ans4;
    TextView question;
    FloatingActionButton next, prev;
    int question_index, n_of_questions;
    Question currentQuestion;
    Book currentBook;

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

        title.setText(currentBook.getTitle());
        question.setText(mQuestion.getQuestion());

        String[] options = mQuestion.getOptions();
        ans1.setText(options[0]);
        ans2.setText(options[1]);
        ans3.setText(options[2]);
        ans4.setText(options[3]);

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(true);
                ans2.setChecked(false);
                ans3.setChecked(false);
                ans4.setChecked(false);
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(true);
                ans3.setChecked(false);
                ans4.setChecked(false);
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(false);
                ans3.setChecked(true);
                ans4.setChecked(false);
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(false);
                ans3.setChecked(false);
                ans4.setChecked(true);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question_index < n_of_questions) {

                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question_index > 0) {

                }
            }
        });

        return rootView;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
