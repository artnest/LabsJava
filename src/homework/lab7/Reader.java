package homework.lab7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Reader extends LibraryPart {
    private Set<Book> bookList = new HashSet<>();
    private Order.Place place;
    //история заказов
    //история взятых книг

    Reader() {
        super("Reader", Type.USER);
    }

    Book[] getBooks() {
        return bookList.toArray(new Book[bookList.size()]);
    }

    void takeBooks(Book book, Order.Place place) {
        bookList.add(book);
        this.place = place;
    }

    void takeBooks(Book[] booksArray, Order.Place place) {
        Collections.addAll(bookList, booksArray);
        this.place = place;
    }

    Order makeOrder(Book book) {
        return new Order(book);
    }

    Order makeOrder(Book book, Order.Place place) {
        return new Order(book, place);
    }

    Order makeOrder(Book[] booksArray) {
        return new Order(booksArray);
    }

    Order makeOrder(Book[] booksArray, Order.Place place) {
        return new Order(booksArray, place);
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
