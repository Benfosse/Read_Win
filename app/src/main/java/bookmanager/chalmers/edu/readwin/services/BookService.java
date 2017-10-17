package bookmanager.chalmers.edu.readwin.services;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.services.interfaces.IBookService;

/**
 * Created by benedikt on 13/10/2017.
 */

public class BookService implements IBookService {
    private Book book1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", "9780582186552",
            "September 21, 1937", "High fantasy, Juvenile fantasy",
            "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien.",
            "/", "8To9");

    private Book book2 = new Book(2, "Alice's Adventures in Wonderland", "Lewis Carrol", "9781533345455",
            "26 November 1865", "Children's fiction",
            "Alice's Adventures in Wonderland is an 1865 fantasy novel written by English mathematician Charles Lutwidge Dodgson under the pseudonym Lewis Carroll.",
            "http://t3.gstatic.com/images?q=tbn:ANd9GcSz9Z5sm0vXcZzhcPl6p_Cq53SDgFgiC8qS-Q6EPEHvSNic2eLr", "8To9");

    public ArrayList<Book> getBooks(String ageCategory) {
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(book1);
        books.add(book2);
        return books;
    }

    public Book getBook(int id) {
        if (id == 1)
            return book1;
        else if (id == 2)
            return book2;
        else
            return null;
    }

}
