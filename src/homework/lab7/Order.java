package homework.lab7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Order extends LibraryPart {
    private Set<Book> bookSet = new HashSet<>();
    enum Place { READINGROOM, HOME, NONE }
    private Place place;

    Order(Book book) {
        super("Order", Type.ORDER);
        bookSet.add(book);
        place = Place.READINGROOM;
    }

    Order(Book book, Place place) {
        super("Order", Type.ORDER);
        bookSet.add(book);
        this.place = place;
    }

    Order(Book[] booksArray) {
        super("Order", Type.ORDER);
        Collections.addAll(bookSet, booksArray);
        place = Place.READINGROOM;
    }

    Order(Book[] booksArray, Place place) {
        super("Order", Type.ORDER);
        Collections.addAll(bookSet, booksArray);
        this.place = place;
    }

    Set<Book> getBookSet() {
        return bookSet;
    }

    Book[] getBookArray() {
        return bookSet.toArray(new Book[bookSet.size()]);
    }

    Place getPlace() {
        return place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return bookSet.equals(order.bookSet);

    }

    @Override
    public int hashCode() {
        return bookSet.hashCode();
    }
}
