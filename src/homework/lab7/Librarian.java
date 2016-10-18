package homework.lab7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Librarian extends LibraryPart {
    private static Librarian ourInstance = new Librarian();

    static Librarian getInstance() {
        return ourInstance;
    }

    private Librarian() {
        super("Librarian", Type.STAFF);
    }

    private Map<Reader, Set<Book>> givenBooks = new HashMap<>();

    public void giveBooks(Book book, Reader reader, Order.Place place) {
        reader.takeBooks(book, place);
    }

    public void giveBooks(Book[] booksArray, Reader reader, Order.Place place) {
        reader.takeBooks(booksArray, place);
    }
}
