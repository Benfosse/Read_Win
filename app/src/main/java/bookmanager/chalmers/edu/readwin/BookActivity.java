package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import bookmanager.chalmers.edu.readwin.models.Book;


public class BookActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            final Book book = bundle.getParcelable("book");

            TextView title = (TextView) findViewById(R.id.bookTitle);
            TextView author = (TextView) findViewById(R.id.bookAuthor);
            TextView date = (TextView) findViewById(R.id.bookDate);
            TextView genre = (TextView) findViewById(R.id.bookGenre);
            TextView description = (TextView) findViewById(R.id.bookDescription);
            ImageView imageView = (ImageView) findViewById(R.id.bookImage);

            title.setText(book.getTitle());
            author.setText(book.getAuthor());
            date.setText(book.getDate());
            genre.setText(book.getGenre());
            description.setText(book.getDescription());

            Picasso.with(getApplicationContext()).load(book.getImage()).into(imageView);

            Button startQuestionsButton = (Button) findViewById(R.id.startQuestionnaire);
            startQuestionsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent bookQuestionsIntent = new Intent(BookActivity.this,
                            QuestionsActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("book", book);
                    bookQuestionsIntent.putExtras(bundle);

                    startActivity(bookQuestionsIntent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.user_account) {
            Intent userAccountIntent = new Intent(BookActivity.this,
                    UserAccountActivity.class);

            startActivity(userAccountIntent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
