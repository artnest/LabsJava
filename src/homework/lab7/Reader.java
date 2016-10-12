package homework.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by theme on 10/5/16.
 */
class Reader {
    private List<Book> bookList;
    //история заказов
    //история взятых книг


    Reader() {
        bookList = new ArrayList<>();
    }

    List<Book> getBookList() {
        return bookList;
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

    // equals
}
