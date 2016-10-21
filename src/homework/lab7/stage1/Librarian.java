package homework.lab7;

import java.util.HashSet;
import java.util.Set;

class Librarian extends LibraryPart {
    private static Librarian ourInstance = new Librarian();

    static Librarian getInstance() {
        return ourInstance;
    }

    private Librarian() {
        super("Librarian", Type.STAFF);
    }

    private Set<Reader> readerSet = new HashSet<>();

    Set<Reader> getReaderSet() {
        return readerSet;
    }

    void showReaderSet() {
        readerSet.forEach(System.out::println);
    }

    void giveBooks(Catalog catalog, Set<Book> bookSet, Reader reader, Reader.Place place) {
        readerSet.add(reader);
        reader.takeBooks(bookSet, place);
        for (Book book : bookSet) {
            takeBookFromCatalog(catalog, book);
        }
    }

    private void takeBookFromCatalog(Catalog catalog, Book book) {
        if (catalog.booksCatalog.get(book) != 0) {
            catalog.booksCatalog.put(book, catalog.booksCatalog.get(book) - 1);
        } else {
            catalog.booksCatalog.remove(book);
        }
    }

    void returnBooks(Catalog catalog, Reader reader) {
        for (Book book : reader.getBookSet()) {
            if (catalog.booksCatalog.containsKey(book)) {
                catalog.booksCatalog.put(book, catalog.booksCatalog.get(book) + 1);
            } else {
                catalog.booksCatalog.put(book, 1);
            }
        }

        reader.returnBooks();
        readerSet.remove(reader);
    }
}
