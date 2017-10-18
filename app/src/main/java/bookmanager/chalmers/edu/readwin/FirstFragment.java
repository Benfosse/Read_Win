package bookmanager.chalmers.edu.readwin;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import bookmanager.chalmers.edu.readwin.R;
import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.services.BookService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class FirstFragment extends Fragment{

    private View rootView;
    private SecondFragment.OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
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
        rootView = inflater.inflate(R.layout.fragment_first, container, false);

        BookService bookService = new BookService();
        GridView bookGrid = rootView.findViewById(R.id.book_grid);
        bookGrid.setAdapter(new BooksAdapter(getContext(), bookService.getBooks("")));

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

        return rootView;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}