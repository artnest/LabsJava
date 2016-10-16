package homework.lab7;

import java.util.HashMap;
import java.util.Map;

class Librarian extends LibraryPart {
    private static Librarian ourInstance = new Librarian();

    static Librarian getInstance() {
        return ourInstance;
    }

    private Librarian() {
        super("Librarian", Type.STAFF);
    }

    private Map<Map<Reader, Book>, Boolean> givenBooks = new HashMap<>();

    public void giveBook(Book book, Reader reader/*, boolean place*/) {
        reader.takeBook(book/*, place*/);
    }

    public void giveBook(Book[] booksArray, Reader reader/*, boolean place*/) {
        //givenBooks.keySet().
        reader.takeBook(booksArray/*, place*/);
    }
}
