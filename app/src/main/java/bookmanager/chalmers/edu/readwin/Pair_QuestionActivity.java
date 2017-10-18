package bookmanager.chalmers.edu.readwin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import bookmanager.chalmers.edu.readwin.models.Book;

public class Pair_QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_pair);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            final Book book = bundle.getParcelable("book");

            TextView title = (TextView) findViewById(R.id.textTitle_Book1);
            title.setText(book.getTitle());
        }
    }
}
