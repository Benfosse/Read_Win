package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.QuestionService;


public class QuestionsActivity extends AppCompatActivity {

    private QuestionsPagerAdapter mQuestionsPagerAdapter;
    private ViewPager mViewPager;

    static final int RESULT_MULTIPLE = 0, RESULT_PAIR = 1, RESULT_ORDERING = 2;
    Book currentBook;
    List<Question> questions;
    int question_index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            currentBook = bundle.getParcelable("book");
            questions = new QuestionService().getBookQuestions(currentBook.getId());
        }

        mQuestionsPagerAdapter = new QuestionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.questions_container);
        mViewPager.setAdapter(mQuestionsPagerAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == RESULT_MULTIPLE) {
            if (data != null) {
                int temp = data.getIntExtra("index", -1);
                        question_index = temp;
            }
        }
    }

    // Used as a helper func to navigate within the fragments via button clicks
    public void setCurrentQuestion (int item, boolean smoothScroll) {
        mViewPager.setCurrentItem(item, smoothScroll);
    }

    public class QuestionsPagerAdapter extends FragmentPagerAdapter {

        public QuestionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Question question = questions.get(position);
            if (question.getType() == "Multiple")
                return MultipleQuestionFragment.newInstance(position, questions.size(), question, currentBook);
            else if (question.getType() == "Pair")
                return PairQuestionFragment.newInstance(position, questions.size(), question, currentBook);
            else
                return PairQuestionFragment.newInstance(position, questions.size(), question, currentBook);
        }

        @Override
        public int getCount() {
            return questions.size();
        }
    }
}
