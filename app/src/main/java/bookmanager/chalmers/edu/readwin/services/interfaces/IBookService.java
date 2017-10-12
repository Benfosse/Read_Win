package bookmanager.chalmers.edu.readwin.services.interfaces;

import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Book;

/**
 * Created by benedikt on 12/10/2017.
 */

public interface IBookService {
    List<Book> getBooks(String ageCategory);
    Book getBook(int id);
}
