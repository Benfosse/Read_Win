package bookmanager.chalmers.edu.readwin;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.services.BookService;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // TODO: Replace. The book should be passed in as a bundle from the books overview
        BookService bookService = new BookService();
        Book book = bookService.getBook(1);

        TextView title = (TextView) findViewById(R.id.bookTitle);
        TextView author = (TextView) findViewById(R.id.bookAuthor);
        TextView date = (TextView) findViewById(R.id.bookDate);
        TextView genre = (TextView) findViewById(R.id.bookGenre);
        TextView description = (TextView) findViewById(R.id.bookDescription);
        ImageView image = (ImageView) findViewById(R.id.bookImage);

        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        date.setText(book.getDate());
        genre.setText(book.getGenre());
        description.setText(book.getDescription());
        //image.setImageURI();
    }
}
