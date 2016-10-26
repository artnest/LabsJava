package homework.lab7.stage1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Reader extends LibraryPart {
    private Set<Book> bookSet = new HashSet<>();

    enum Place { READINGROOM, HOME, NONE }
    private Place place = Place.NONE;

    Reader(String name) {
        super(name, Type.USER);
    }

    Place getPlace() {
        return place;
    }

    Set<Book> getBookSet() {
        return bookSet;
    }

    void takeBooks(Set<Book> bookSet, Place place) {
        this.bookSet.addAll(bookSet);
        this.place = place;
    }

    void returnBooks() {
        bookSet.clear();
        place = Place.NONE;
    }

    Order makeOrder(Book book) {
        return new Order(book);
    }

    Order makeOrder(Book book, Place place) {
        return new Order(book, place);
    }

    Order makeOrder(Book[] booksArray) {
        return new Order(booksArray);
    }

    Order makeOrder(Book[] booksArray, Place place) {
        return new Order(booksArray, place);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        return bookSet.equals(reader.bookSet) && place == reader.place;
    }

    @Override
    public int hashCode() {
        int result = bookSet.hashCode();
        result = 31 * result + place.hashCode();
        return result;
    }

    class Order extends LibraryPart {
        private Set<Book> bookSet = new HashSet<>();
        private Place place;

        private Order(Book book) {
            super("Order", Type.ORDER);
            bookSet.add(book);
            place = Place.READINGROOM;
        }

        private Order(Book book, Place place) {
            super("Order", Type.ORDER);
            bookSet.add(book);
            this.place = place;
        }

        private Order(Book[] booksArray) {
            super("Order", Type.ORDER);
            Collections.addAll(bookSet, booksArray);
            place = Place.READINGROOM;
        }

        private Order(Book[] booksArray, Place place) {
            super("Order", Type.ORDER);
            Collections.addAll(bookSet, booksArray);
            this.place = place;
        }

        Set<Book> getBookSet() {
            return bookSet;
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
}
