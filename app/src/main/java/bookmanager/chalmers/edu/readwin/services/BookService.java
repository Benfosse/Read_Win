package bookmanager.chalmers.edu.readwin.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.services.interfaces.IBookService;

/**
 * Created by benedikt on 13/10/2017.
 */

public class BookService implements IBookService {
    private List<String> bookCategories = Arrays.asList("Adventure", "Fantasy", "Children's Novel", "Novel");

    private Book book1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", "9780582186552", "September 21, 1937", "High fantasy, Juvenile fantasy", "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien.", "https://images-na.ssl-images-amazon.com/images/I/61aqO0sPF%2BL._SX329_BO1,204,203,200_.jpg", "Fantasy");
    private Book book2 = new Book(2, "Alice's Adventures in Wonderland", "Lewis Carrol", "9781533345455", "26 November 1865", "Children's fiction", "Alice's Adventures in Wonderland is an 1865 fantasy novel written by English mathematician Charles Lutwidge Dodgson under the pseudonym Lewis Carroll.", "http://t3.gstatic.com/images?q=tbn:ANd9GcSz9Z5sm0vXcZzhcPl6p_Cq53SDgFgiC8qS-Q6EPEHvSNic2eLr", "Children's Novel");
    private Book book3 = new Book(3, "Charlie and the Chocolate Factory", "Roald Dahl", "9780375829307", "October 10, 2003", "Children's fantasy novel", "Charlie and the Chocolate Factory is a 1964 children's novel by British author Roald Dahl. The story features the adventures of young Charlie Bucket inside the chocolate factory of eccentric chocolatier Willy Wonka.", "https://images.gr-assets.com/books/1386924269l/73810.jpg", "Fantasy");
    private Book book4 = new Book(4, "The Lion, the Witch, and the Wardrobe", "C.S. Lewis", "9780060764890", "October 16, 1950", "Adventure, Fantasy", "They open a door and enter a world NARNIA...the land beyond the wardrobe, the secret country known only to Peter, Susan, Edmund, and Lucy...the place where the adventure begins.", "https://images.gr-assets.com/books/1353029077l/100915.jpg", "Fantasy");
    private Book book5 = new Book(5, "The Adventures of Pippi Longstocking", "Astrid Lindgren", "9780670876129", "1997", "Children´s novel", "Since Pippi Longstocking was first published in 1950, the escapades of the incomparable Pippi,the girl with upside-down braids and no parents to tell her what to do, have delighted boys and girls alike.", "https://images.gr-assets.com/books/1406919233l/19301.jpg", "Children's Novel");
    private Book book6 = new Book(6, "The Secret Garden", "Frances Hodgson Burnett", "9780517189603", "September 1, 1998", "Childrens novel", "When orphaned Mary Lennox comes to live at her uncle's great house on the Yorkshire Moors, she finds it full of secrets. The mansion has nearly one hundred rooms, and her uncle keeps himself locked up. And at night, she hears the sound of crying down one of the long corridors.", "https://images.gr-assets.com/books/1327873635l/2998.jpg" , "Children's Novel");
    private Book book7 = new Book(7, "The Wonderful Wizard of Oz", "L. Frank Baum", "9780140621679", "1995", "Adventure, Childrens novel", "Dorothy thinks she's lost forever when a tornado whirls her and her dog, Toto, into a magical world. To get home, she must find the wonderful wizard in the Emerald City of Oz. On the way she meets the Scarecrow, the Tin Woodman and the Cowardly Lion.", "https://images.gr-assets.com/books/1398003737l/236093.jpg" , "Children's Novel");
    private Book book8 = new Book(8, "Matilda", "Roald Dahl", "9780141301068", "June 1st 1998", "Childrens novel", "Matilda is a little girl who is far too good to be true. At age five-and-a-half she's knocking off double-digit multiplication problems and blitz-reading Dickens. Even more remarkably, her classmates love her even though she's a super-nerd and the teacher's pet. But everything is not perfect in Matilda's world. For starters she has two of the most idiotic, self-centered parents who ever lived. Then there's the large, busty nightmare of a school principal, Mrs. ('The') Trunchbull, a former hammer-throwing champion who flings children at will and is approximately as sympathetic as a bulldozer. Fortunately for Matilda, she has the inner resources to deal with such annoyances: astonishing intelligence, saintly patience, and an innate predilection for revenge.", "https://images.gr-assets.com/books/1388793265l/39988.jpg" , "Children's Novel");
    private Book book9 = new Book(9, "Peter Pan", "J. M. Barrie", "9780805072457", "October 1, 2003", "Fantasy, Adventure", "Peter Pan, the book based on J.M. Barrie's famous play, is filled with unforgettable characters: Peter Pan, the boy who would not grow up; the fairy, Tinker Bell; the evil pirate, Captain Hook; and the three children--Wendy, John, and Michael--who fly off with Peter Pan to Neverland, where they meet Indians and pirates and a crocodile that ticks.", "https://images.gr-assets.com/books/1337714526l/34268.jpg" , "Fantasy");
    private Book book10 = new Book(10, "The Indian in the Cupboard", "Lynne Reid Banks", "9780007148981", "2003", "Adventure, Childrens novel", "At first, Omri is unimpressed with the plastic Indian toy he is given for his birthday. But when he puts it in his old cupboard and turns the key, something extraordinary happens that will change Omri's life for ever. For Little Bull, the Iroquois Indian brave, comes to life...", "https://images.gr-assets.com/books/1171903915l/125404.jpg" , "Adventure");
    private Book book11 = new Book(11, "The BFG", "Roald Dahl", "9780141311371", "2001", "Fantasy, Adventure", "Captured by a giant! The BFG is no ordinary bone-crunching giant. He is far too nice and jumbly. It's lucky for Sophie that he is. Had she been carried off in the middle of the night by the Bloodbottler, the Fleshlumpeater, the Bonecruncher, or any of the other giants-rather than the BFG-she would have soon become breakfast.", "https://images.gr-assets.com/books/1327872673l/6319.jpg" , "Novel");
    private Book book12 = new Book(12, "Five on a Treasure Island", "Enid Blyton", "9780340796146", "June 14th 2001", "Adventure", "The very first Famous Five adventure, featuring Julian, Dick, Anne, not forgetting tomboy George and her beloved dog, Timmy! There's a shipwreck off Kirrin Island! But where is the treasure? The Famous Five are on the trail - looking for clues - but they're not alone! Someone else has got the same idea. Time is running out for the Famous Five, who will follow the clues and get to the treasure first?", "https://images.gr-assets.com/books/1408926754l/17488.jpg" , "Novel");
    private Book book13 = new Book(13, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", "9788700631625", "26 June 1997", "Fantasy", "Adaptation of the first of J.K. Rowling's popular children's novels about Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful wizards and possesses unique magical powers of his own. He is summoned from his life as an unwanted child to become a student at Hogwarts, an English boarding school for wizards. There, he meets several friends who become his closest allies and help him discover the truth about his parents' mysterious deaths.", "http://t2.gstatic.com/images?q=tbn:ANd9GcTp0w1QBM18O90jGjFPLNGoRlDfbdRG44zZa-8zokr_EocYL0z-", "Fantasy");
    private Book book14 = new Book(14, "The Lightning Thief (Percy Jackson and the Olympians, #1)", "Rick Riordan", "9780786856299", "June 28, 2005", "Juvenile fantasy", "Percy Jackson is a good kid, but he can't seem to focus on his schoolwork or control his temper. And lately, being away at boarding school is only getting worse-Percy could have sworn his pre-algebra teacher turned into a monster and tried to kill him. When Percy's mom finds out, she knows it's time that he knew the truth about where he came from, and that he go to the one place he'll be safe. She sends Percy to Camp Half Blood, a summer camp for demigods (on Long Island), where he learns that the father he never knew is Poseidon, God of the Sea. Soon a mystery unfolds and together with his friends -- one a satyr and the other the demigod daughter of Athena -- Percy sets out on a quest across the United States to reach the gates of the Underworld (located in a recording studio in Hollywood) and prevent a catastrophic war between the gods.", "https://images.gr-assets.com/books/1331236472l/893174.jpg", "Novel");
    private Book book15 = new Book(15, "Bridge to Terabithia", "Katherine Paterson", "9780439366779", "January 1st 1996", "Adventure, Fantasy", "Jess Aarons' greatest ambition is to be the fastest runner in his grade. He's been practicing all summer and can't wait to see his classmates' faces when he beats them all. But on the first day of school, a new girl boldly crosses over to the boys' side and outruns everyone. That's not a very promising beginning for a friendship, but Jess and Leslie Burke become inseparable. Together they create Terabithia, a magical kingdom in the woods where the two of them reign as king and queen, and their imaginations set the only limits.", "https://images.gr-assets.com/books/1327880087l/2839.jpg" , "Adventure");
    private Book book16 = new Book(16, "The Adventures of Captain Underpants", "Dav Pilkey", "9780439014571", "2000", "Childrens comedy, Comic book for children", "Pilkey plays with words and pictures, providing great entertainment. The story is immediately engaging—two fourth-grade boys who write comic books and love to pull pranks find themselves in big trouble. Mean Mr. Krupp, their principal, videotapes George and Harold setting up their stunts and threatens to expose them. The boys' luck changes when they send for a 3-D Hypno-Ring and hypnotize Krupp, turning him into Captain Underpants, their own superhero creation. Later, Pilkey includes several pages of flip-o-ramas that animate the action. The simple black-and-white illustrations on every page furnish comic-strip appeal. The cover features Captain Underpants, resplendent in white briefs, on top of a tall building.", "https://images.gr-assets.com/books/1348215410l/207266.jpg", "Novel");
    private Book book17 = new Book(17, "The City of Ember", "Jeanne DuPrau", "9780375822742", "2003", "Fantasy, Adventure", "Many hundreds of years ago, the city of Ember was created by the Builders to contain everything needed for human survival. It worked…but now the storerooms are almost out of food, crops are blighted, corruption is spreading through the city and worst of all—the lights are failing. Soon Ember could be engulfed by darkness… But when two children, Lina and Doon, discover fragments of an ancient parchment, they begin to wonder if there could be a way out of Ember. Can they decipher the words from long ago and find a new future for everyone? Will the people of Ember listen to them?", "https://images.gr-assets.com/books/1397931596l/307791.jpg" , "Fantasy");
    private Book book18 = new Book(18, "Peter Nimble and His Fantastic Eyes", "Jonathan Auxier ", "9781419700255", "August 1st 2011", "Fantasy, Fiction", "Peter Nimble and His Fantastic Eyes is the utterly beguiling tale of a ten-year-old blind orphan who has been schooled in a life of thievery. One fateful afternoon, he steals a box from a mysterious traveling haberdasher—a box that contains three pairs of magical eyes. When he tries the first pair, he is instantly transported to a hidden island where he is presented with a special quest: to travel to the dangerous Vanished Kingdom and rescue a people in need. Along with his loyal sidekick—a knight who has been turned into an unfortunate combination of horse and cat—and the magic eyes, he embarks on an unforgettable, swashbuckling adventure to discover his true destiny.", "https://images.gr-assets.com/books/1353594747l/10806008.jpg", "Novel");
    private Book book19 = new Book(19, "The Cat in the Hat", "Dr. Seuss", "9782371000193", "12 March 1957", "Children's literature", "The Cat in the Hat is a children's book written and illustrated by Theodor Geisel under the pen name Dr. Seuss and first published in 1957. The story centers on a tall anthropomorphic cat, who wears a red and white-striped hat and a red bow tie.", "http://t2.gstatic.com/images?q=tbn:ANd9GcSrobA2bx30tEpLERBmMZCkBEP-bjbWdxFFWZcCal_vKEaskZ-d", "Children's Novel");
    private Book book20 = new Book(20, "Moby-Dick", "Herman Melville", "9781535277181", "18 October 1851", "Novel, adventure fiction, epic", "Moby-Dick; or, The Whale is a novel by American writer Herman Melville, published in 1851 during the period of the American Renaissance.", "http://t0.gstatic.com/images?q=tbn:ANd9GcRVzGSCtcxuJZ51obbG92GWfkq9L7d3vIJhy5XHEr-4WoKN7FJP", "Adventure");
    private Book book21 = new Book(21, "Oliver Twist", "Charles Dickens", "9781844280681", "February 1837", "Novel", "Oliver Twist, or The Parish Boy's Progress, is the second novel by English author Charles Dickens and was first published as a serial 1837–39.", "http://t0.gstatic.com/images?q=tbn:ANd9GcTcq1eCXim9jmezfg0VZecCEVc7STUjYkI74d1nM-ansyUZ3RoN", "Adventure");
    private Book book22 = new Book(22, "Adventures of Huckleberry Finn", "Mark Twain", "9780886767273", "10 December 1884", "Picaresque novel", "Adventures of Huckleberry Finn is a novel by Mark Twain, first published in the United Kingdom in December 1884 and in the United States in February 1885.", "http://t3.gstatic.com/images?q=tbn:ANd9GcSHCuXxly3yxOR3Wfdc1usU1iAOUyc4enO5VgtuuRdaKSl4VV2M", "Novel");
    private Book book23 = new Book(23, "The Bad Beginning", "Lemony Snicket", "9781405207263", "30 September 1999", "Gothic fiction\n" + "Absurdist fiction\n" + "Steampunk\n" + "Mystery", "The Bad Beginning is the first novel of the children's novel series A Series of Unfortunate Events by Lemony Snicket.", "http://t0.gstatic.com/images?q=tbn:ANd9GcQEBB2TpgNvBwDt8ors4jxFHrPOF4pKWaaWuhLzShXe_cQGV3g0", "Fantasy");
    private Book book24 = new Book(24, "Holes", "Louis Sachar", "9780439244190", "September 2nd 2000", "Young Adult", "Stanley tries to dig up the truth in this inventive and darkly humorous tale of crime and punishment—and redemption. Ages 10+ Stanley Yelnats is under a curse. A curse that began with his no-good-dirty-rotten- pig-stealing-great-great-grandfather and has since followed generations of Yelnats. Now Stanley has been unjustly sent to a boys' detention center, Camp Green Lake, where the warden makes the boys 'build character' by spending all day, every day, digging holes: five feet wide and five feet deep. It doesn't take long for Stanley to realize there's more than character improvement going on at Camp Green Lake. The boys are digging holes because the warden is looking for something. Stanley tries to dig up the truth in this inventive and darkly humorous tale of crime and punishment—and redemption.", "https://images.gr-assets.com/books/1327781893l/38709.jpg", "Novel");

    public ArrayList<Book> getBooks(final String ageCategory) {
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
        books.add(book11);
        books.add(book12);
        books.add(book13);
        books.add(book14);
        books.add(book15);
        books.add(book16);
        books.add(book17);
        books.add(book18);
        books.add(book19);
        books.add(book20);
        books.add(book21);
        books.add(book22);
        books.add(book23);
        books.add(book24);

        if(ageCategory == null)
            return books;
        else {
            ArrayList<Book> filteredList = new ArrayList<Book>();
            for (Book book : books) {
                if(book.getAgeCategory() == ageCategory)
                    filteredList.add(book);
            }
            return filteredList;
        }
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
        else if (id == 9)
            return book9;
        else if (id == 10)
            return book10;
        else if (id == 11)
            return book11;
        else if (id == 12)
            return book12;
        else  if (id == 13)
            return book13;
        else if (id == 14)
            return book14;
        else  if (id == 15)
            return book15;
        else if (id == 16)
            return book16;
        else if (id == 17)
            return book17;
        else if (id == 18)
            return book18;
        else if (id == 19)
            return book19;
        else if (id == 20)
            return book20;
        else  if (id == 21)
            return book21;
        else if (id == 22)
            return book22;
        else  if (id == 23)
            return book23;
        else if (id == 24)
            return book24;
        else
            return null;
    }

    public List<String> getBookCategories() {
        return bookCategories;
    }

}
