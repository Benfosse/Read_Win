package bookmanager.chalmers.edu.readwin;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.content.Context;
import java.util.ArrayList;
import android.view.ViewGroup;
import bookmanager.chalmers.edu.readwin.models.Book;

/**
 * Created by benedikt on 18/10/2017.
 */
public class BooksAdapter extends ArrayAdapter<Book> {
    public BooksAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }
        // Lookup view for data population
        TextView bookTitle = (TextView) convertView.findViewById(R.id.bookTitleList);

        // Populate the data into the template view using the data object
        bookTitle.setText(book.getTitle());

        // Return the completed view to render on screen
        return convertView;
    }


}