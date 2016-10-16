package homework.lab7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Order extends LibraryPart {
    private Set<Book> bookList = new HashSet<>();

    Order(Book book) {
        super("Order", Type.ORDER);
        bookList.add(book);
    }

    Order(Book[] booksArray) {
        Collections.addAll(bookList, booksArray);
    }

    Book[] getBooks() {
        return bookList.toArray(new Book[bookList.size()]);
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
