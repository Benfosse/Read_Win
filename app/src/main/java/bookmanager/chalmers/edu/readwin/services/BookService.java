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
            "https://images-na.ssl-images-amazon.com/images/I/61aqO0sPF%2BL._SX329_BO1,204,203,200_.jpg", "8To9");

    private Book book2 = new Book(2, "Alice's Adventures in Wonderland", "Lewis Carrol", "9781533345455",
            "26 November 1865", "Children's fiction",
            "Alice's Adventures in Wonderland is an 1865 fantasy novel written by English mathematician Charles Lutwidge Dodgson under the pseudonym Lewis Carroll.",
            "http://t3.gstatic.com/images?q=tbn:ANd9GcSz9Z5sm0vXcZzhcPl6p_Cq53SDgFgiC8qS-Q6EPEHvSNic2eLr", "8To9");

    private Book book3 = new Book(3, "Moby-Dick", "Herman Melville", "9781535277181",
            "18 October 1851", "Novel, adventure fiction, epic, sea story, encyclopedic novel",
            "Moby-Dick; or, The Whale is a novel by American writer Herman Melville, published in 1851 during the period of the American Renaissance.",
            "http://t0.gstatic.com/images?q=tbn:ANd9GcRVzGSCtcxuJZ51obbG92GWfkq9L7d3vIJhy5XHEr-4WoKN7FJP", "10To11");

    private Book book4 = new Book(4, "Oliver Twist", "Charles Dickens", "9781844280681",
            "February 1837", "Novel",
            "Oliver Twist, or The Parish Boy's Progress, is the second novel by English author Charles Dickens and was first published as a serial 1837–39.",
            "http://t0.gstatic.com/images?q=tbn:ANd9GcTcq1eCXim9jmezfg0VZecCEVc7STUjYkI74d1nM-ansyUZ3RoN", "8To9");

    private Book book5 = new Book(5, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", "9788700631625",
            "26 June 1997", "Fantasy",
            "Adaptation of the first of J.K. Rowling's popular children's novels about Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful wizards and possesses unique magical powers of his own. He is summoned from his life as an unwanted child to become a student at Hogwarts, an English boarding school for wizards. There, he meets several friends who become his closest allies and help him discover the truth about his parents' mysterious deaths.",
            "http://t2.gstatic.com/images?q=tbn:ANd9GcTp0w1QBM18O90jGjFPLNGoRlDfbdRG44zZa-8zokr_EocYL0z-", "8To9");

    private Book book6 = new Book(6, "Adventures of Huckleberry Finn", "Mark Twain", "9780886767273",
            "10 December 1884", "Picaresque novel",
            "Adventures of Huckleberry Finn is a novel by Mark Twain, first published in the United Kingdom in December 1884 and in the United States in February 1885.",
            "http://t3.gstatic.com/images?q=tbn:ANd9GcSHCuXxly3yxOR3Wfdc1usU1iAOUyc4enO5VgtuuRdaKSl4VV2M", "8To9");

    private Book book7 = new Book(7, "The Cat in the Hat", "Dr. Seuss", "9782371000193",
            "12 March 1957", "Children's literature",
            "The Cat in the Hat is a children's book written and illustrated by Theodor Geisel under the pen name Dr. Seuss and first published in 1957. The story centers on a tall anthropomorphic cat, who wears a red and white-striped hat and a red bow tie.",
            "http://t2.gstatic.com/images?q=tbn:ANd9GcSrobA2bx30tEpLERBmMZCkBEP-bjbWdxFFWZcCal_vKEaskZ-d", "8To9");

    private Book book8 = new Book(8, "The Bad Beginning", "Daniel Handler", "9781405207263",
            "30 September 1999", "Gothic fiction\n" +
            "Absurdist fiction\n" +
            "Steampunk\n" +
            "Mystery",
            "The Bad Beginning is the first novel of the children's novel series A Series of Unfortunate Events by Lemony Snicket.",
            "http://t0.gstatic.com/images?q=tbn:ANd9GcQEBB2TpgNvBwDt8ors4jxFHrPOF4pKWaaWuhLzShXe_cQGV3g0", "8To9");

    public ArrayList<Book> getBooks(String ageCategory) {
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        return books;
    }

    public Book getBook(int id) {
        if (id == 1)
            return book1;
        else if (id == 2)
            return book2;
        else if (id == 3)
            return book3;
        else if (id == 4)
            return book4;
        else  if (id == 5)
            return book5;
        else if (id == 6)
            return book6;
        else  if (id == 7)
            return book7;
        else if (id == 8)
            return book8;
        else
            return null;
    }

}
