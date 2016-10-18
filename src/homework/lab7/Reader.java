package homework.lab7;

import java.util.HashSet;
import java.util.Set;

class Reader extends LibraryPart {
    private Set<Book> bookSet = new HashSet<>();
    private Order.Place place;
    //история заказов
    //история взятых книг

    Reader() {
        super("Reader", Type.USER);
    }

    Set<Book> getBookSet() {
        return bookSet;
    }

    void takeBooks(Set<Book> bookSet, Order.Place place) {
        this.bookSet.addAll(bookSet);
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

        return bookSet.equals(reader.bookSet);

    }

    @Override
    public int hashCode() {
        return bookSet.hashCode();
    }
}
