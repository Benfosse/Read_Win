package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.Question;

public class Questionnaire_Q1_Book1 extends AppCompatActivity {

    final String Answer1 = "Answer1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_multiplechoice);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            final Book book = bundle.getParcelable("book");

            TextView title = (TextView) findViewById(R.id.textTitle_Book1);
            title.setText(book.getTitle());
            int IdBook = book.getId();


            final Button A1_B1 = (Button) findViewById(R.id.buttonAnswer1_Q1_B1);
            final Button A2_B1 = (Button) findViewById(R.id.buttonAnswer2_Q1_B1);
            final Button A3_B1 = (Button) findViewById(R.id.buttonAnswer3_Q1_B1);
            final Button A4_B1 = (Button) findViewById(R.id.buttonAnswer4_Q1_B1);
            final ImageButton ArrowQ1toQ2 = (ImageButton) findViewById(R.id.imageButton_Q1toQ2_B1);


            View.OnClickListener clickonAnswer1_B1 = new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent Question1_Book1 = new Intent(Questionnaire_Q1_Book1.this, Questionnaire_Q2_Book1.class);
                    Question1_Book1.putExtra(Answer1, A1_B1.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("book", book);
                    Question1_Book1.putExtras(bundle);
                    startActivity(Question1_Book1);
                }
            };

            View.OnClickListener clickonAnswer2_B1 = new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent Question1_Book1 = new Intent(Questionnaire_Q1_Book1.this, Questionnaire_Q2_Book1.class);
                    Question1_Book1.putExtra(Answer1, A2_B1.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("book", book);
                    Question1_Book1.putExtras(bundle);
                    startActivity(Question1_Book1);
                }
            };

            View.OnClickListener clickonAnswer3_B1 = new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent Question1_Book1 = new Intent(Questionnaire_Q1_Book1.this, Questionnaire_Q2_Book1.class);
                    Question1_Book1.putExtra(Answer1, A3_B1.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("book", book);
                    Question1_Book1.putExtras(bundle);
                    startActivity(Question1_Book1);
                }
            };

            View.OnClickListener clickonAnswer4_B1 = new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent Question1_Book1 = new Intent(Questionnaire_Q1_Book1.this, Questionnaire_Q2_Book1.class);
                    Question1_Book1.putExtra(Answer1, A4_B1.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("book", book);
                    Question1_Book1.putExtras(bundle);
                    startActivity(Question1_Book1);
                }
            };

            View.OnClickListener clickonBoutonArrow_B1 = new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent Question1_Book1 = new Intent(Questionnaire_Q1_Book1.this, Questionnaire_Q2_Book1.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("book", book);
                    Question1_Book1.putExtras(bundle);
                    startActivity(Question1_Book1);
                }
            };

            A1_B1.setOnClickListener(clickonAnswer1_B1);
            A2_B1.setOnClickListener(clickonAnswer2_B1);
            A3_B1.setOnClickListener(clickonAnswer3_B1);
            A4_B1.setOnClickListener(clickonAnswer4_B1);
            ArrowQ1toQ2.setOnClickListener(clickonBoutonArrow_B1);

        }
    }
}
