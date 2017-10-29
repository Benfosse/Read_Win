package bookmanager.chalmers.edu.readwin;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.services.BookService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IntroFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IntroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class BookListFragment extends Fragment{

    private View rootView;
    private int ageCategoryIndex;
    private IntroFragment.OnFragmentInteractionListener mListener;

    public BookListFragment() {
        // Required empty public constructor
    }

    public static BookListFragment newInstance() {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
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
        rootView = inflater.inflate(R.layout.fragment_book_list, container, false);

        final BookService bookService = new BookService();
        final List<String> bookCategories = bookService.getBookCategories();
        final TextView bookListHeader = rootView.findViewById(R.id.book_list_header);
        final GridView bookGrid = rootView.findViewById(R.id.book_grid);
        ageCategoryIndex = 0;

        bookListHeader.setText(bookCategories.get(ageCategoryIndex));

        // TODO: Should be showing the age category that the current user falls into, instead of default category
        setUpBookListGrid(bookGrid, bookService.getBooks(bookCategories.get(0)));

        // Listener for age category arrow buttons
        ImageButton ageCategoryLeft = rootView.findViewById(R.id.age_category_left);
        ImageButton ageCategoryRight = rootView.findViewById(R.id.age_category_right);

        ageCategoryLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(ageCategoryIndex == 0)
                    ageCategoryIndex = bookCategories.size() - 1;
                else
                    ageCategoryIndex -= 1;

                bookListHeader.setText(bookCategories.get(ageCategoryIndex));
                setUpBookListGrid(bookGrid, bookService.getBooks(bookCategories.get(ageCategoryIndex)));
            }
        });

        ageCategoryRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(ageCategoryIndex == (bookCategories.size() - 1))
                    ageCategoryIndex = 0;
                else
                    ageCategoryIndex += 1;

                bookListHeader.setText(bookCategories.get(ageCategoryIndex));
                setUpBookListGrid(bookGrid, bookService.getBooks(bookCategories.get(ageCategoryIndex)));
            }
        });

        return rootView;
    }

    // TODO: Decide whether to remove this
    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    */

    @Override
    public void onResume() {
        super.onResume();

        final BookService bookService = new BookService();
        final List<String> bookCategories = bookService.getBookCategories();
        final TextView bookListHeader = rootView.findViewById(R.id.book_list_header);
        final GridView bookGrid = rootView.findViewById(R.id.book_grid);
        ageCategoryIndex = 0;

        bookListHeader.setText(bookCategories.get(ageCategoryIndex));

        // TODO: Should be showing the age category that the current user falls into, instead of default category
        setUpBookListGrid(bookGrid, bookService.getBooks(bookCategories.get(0)));

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void setUpBookListGrid(GridView bookGrid, ArrayList<Book> books) {
        bookGrid.setAdapter(new BooksAdapter(getContext(), books));

        AdapterView.OnItemClickListener bookClicked = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Start NewActivity.class
                Intent myIntent = new Intent(getActivity(),
                        BookActivity.class);

                Book book = (Book) adapterView.getAdapter().getItem(i);

                Bundle bundle = new Bundle();
                bundle.putParcelable("book", book);
                myIntent.putExtras(bundle);

                startActivity(myIntent);
            }
        };

        bookGrid.setOnItemClickListener(bookClicked);
    }
}