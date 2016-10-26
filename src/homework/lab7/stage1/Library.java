package homework.lab7.stage1;

import java.util.HashSet;
import java.util.Set;

public class Library extends LibraryPart {
    private Catalog catalog;
    private Librarian librarian;
    private Administrator administrator;

    public Library(String name) {
        super(name, Type.LIBRARY);

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

    public void doOrder(Reader reader, Reader.Order order) {
        Set<Book> booksInLibrarySet = checkBooks(order);

        if (!booksInLibrarySet.isEmpty() && administrator.checkReader(reader)) {
            librarian.giveBooks(catalog, booksInLibrarySet, reader, order.getPlace());
        } else {
            System.out.println("Данные книги в каталоге отсутствуют, или " +
                    "читатель не может делать заказы (находится в черном списке)!");
        }
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
