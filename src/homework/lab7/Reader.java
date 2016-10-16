package homework.lab7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Reader extends LibraryPart {
    private Set<Book> bookList = new HashSet<>();
    //история заказов
    //история взятых книг

    Reader() {
        super("Reader", Type.USER);
    }

    Book[] getBooks() {
        return bookList.toArray(new Book[bookList.size()]);
    }

    void takeBook(Book book) {
        bookList.add(book);
    }

    void takeBook(Book[] booksArray) {
        Collections.addAll(bookList, booksArray);
    }

    Order makeOrder(Book book) {
        return new Order(book);
    }

    Order makeOrder(Book[] booksArray) {
        return new Order(booksArray);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        return bookList.equals(reader.bookList);

    }

    @Override
    public int hashCode() {
        return bookList.hashCode();
    }
}
