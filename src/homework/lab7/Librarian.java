package homework.lab7;

import java.util.Map;

/**
 * Created by theme on 10/6/16.
 */
class Librarian {
    private static Librarian ourInstance = new Librarian();

    static Librarian getInstance() {
        return ourInstance;
    }

    private Librarian() {
    }

    //private List<Book> givenBooks;
    private Map<Book, Reader> givenBooks;
    private Map<Reader, Boolean> readersPlaces;

    public void giveBook(Book book, Reader reader/*, boolean place*/) {
        /*reader.takeBook(book*//*, place*//*);*/
    }
}
