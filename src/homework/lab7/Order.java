package homework.lab7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Order extends LibraryPart {
    private Set<Book> bookList = new HashSet<>();
    enum Place { READINGROOM, HOME, NONE }
    private Place place;

    Order(Book book) {
        super("Order", Type.ORDER);
        bookList.add(book);
        place = Place.READINGROOM;
    }

    Order(Book book, Place place) {
        super("Order", Type.ORDER);
        bookList.add(book);
        this.place = place;
    }

    Order(Book[] booksArray) {
        super("Order", Type.ORDER);
        Collections.addAll(bookList, booksArray);
        place = Place.READINGROOM;
    }

    Order(Book[] booksArray, Place place) {
        super("Order", Type.ORDER);
        Collections.addAll(bookList, booksArray);
        this.place = place;
    }

    Set<Book> getBookList() {
        return bookList;
    }

    Book[] getBooks() {
        return bookList.toArray(new Book[bookList.size()]);
    }

    Place getPlace() {
        return place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return bookList.equals(order.bookList);

    }

    @Override
    public int hashCode() {
        return bookList.hashCode();
    }
}
