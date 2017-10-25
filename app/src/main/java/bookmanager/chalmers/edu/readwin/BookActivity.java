package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.PairQuestion;
import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.UserService;


public class BookActivity extends AppCompatActivity {

    Context context;
    User currentUser;
    Book currentBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            currentBook = bundle.getParcelable("book");

            UserService userService = new UserService(getApplicationContext());
            currentUser = userService.getCurrentUser();

            TextView title = (TextView) findViewById(R.id.bookTitle);
            TextView author = (TextView) findViewById(R.id.bookAuthor);
            TextView date = (TextView) findViewById(R.id.bookDate);
            TextView genre = (TextView) findViewById(R.id.bookGenre);
            TextView description = (TextView) findViewById(R.id.bookDescription);
            ImageView imageView = (ImageView) findViewById(R.id.bookImage);

            title.setText(currentBook.getTitle());
            author.setText(currentBook.getAuthor());
            date.setText(currentBook.getDate());
            genre.setText(currentBook.getGenre());
            description.setText(currentBook.getDescription());

            Picasso.with(getApplicationContext()).load(currentBook.getImage()).into(imageView);

            Button startQuestionsButton = (Button) findViewById(R.id.startQuestionnaire);
            ImageView ribbon = (ImageView) findViewById(R.id.bookRibbon);
            if(checkIfQuestionsFinished(currentUser.getId(), currentBook.getId())) {
                startQuestionsButton.setAlpha(.5f);
                startQuestionsButton.setClickable(false);
                ribbon.setVisibility(View.VISIBLE);
            } else {
                startQuestionsButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent bookQuestionsIntent = new Intent(BookActivity.this,
                                QuestionsActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putParcelable("book", currentBook);
                        bookQuestionsIntent.putExtras(bundle);

                        startActivity(bookQuestionsIntent);
                    }
                });
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        Button startQuestionsButton = (Button) findViewById(R.id.startQuestionnaire);
        ImageView ribbon = (ImageView) findViewById(R.id.bookRibbon);
        if(checkIfQuestionsFinished(currentUser.getId(), currentBook.getId())) {
            startQuestionsButton.setAlpha(.5f);
            startQuestionsButton.setClickable(false);
            ribbon.setVisibility(View.VISIBLE);
        } else {
            startQuestionsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent bookQuestionsIntent = new Intent(BookActivity.this,
                            QuestionsActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("book", currentBook);
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

    private Boolean checkIfQuestionsFinished(int userId, int bookId) {
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("questionsAnswered", Context.MODE_PRIVATE);
        String hasRead = sharedpreferences.getString(userId + "-" + bookId, "");
        return hasRead.equals("Finished");
    }
}
