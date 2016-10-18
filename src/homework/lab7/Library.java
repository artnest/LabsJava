package homework.lab7;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private Catalog catalog;
    private Librarian librarian;
    private Administrator administrator;

    public Library() {
        catalog = Catalog.getInstance();
        librarian = Librarian.getInstance();
        administrator = Administrator.getInstance();
    }

    public Set<Book> checkBooks(Reader.Order order) {
        Set<Book> copyBookSet = new HashSet<>(order.getBookSet());
/*
        for (Book book : order.getBookSet()) {
            if (!catalog.booksCatalog.containsKey(book)) {
                copyBookSet.remove(book);
            }
        }
*/
        order.getBookSet().stream().filter(book -> !catalog.booksCatalog.containsKey(book)).forEach(copyBookSet::remove);
        return copyBookSet;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public Administrator getAdministrator() {
        return administrator;
    }
}
