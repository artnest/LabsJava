package homework.lab7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by theme on 10/6/16.
 */
class Order {
    private List<Book> bookList = new LinkedList<>(); // TODO: 07.10.2016 change to HashMap<K, V>

    Order(Book book) {
        bookList.add(book);
    }

    Order(Book[] booksArray) {
        Collections.addAll(bookList, booksArray);
    }

    Book[] getBooks() {
        return (Book[]) bookList.toArray(new Book[bookList.size()]);
    }

    // equals
}
