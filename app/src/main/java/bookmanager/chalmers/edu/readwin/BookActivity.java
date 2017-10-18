package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.services.BookService;

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

            // TODO: Finish fetching image
            // Bitmap image = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + book.getImage());
            // imageView.setImageBitmap(image);

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
}
