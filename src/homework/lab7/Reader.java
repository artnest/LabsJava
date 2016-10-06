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


    public Reader() {
        bookList = new ArrayList<>();
    }

    public Reader(Book[] booksArray) {
        Collections.addAll(bookList, booksArray);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void takeBook(Book book) {
        bookList.add(book);
    }

    public void takeBook(Book[] booksArray) {
        Collections.addAll(bookList, booksArray);
    }

    public Order makeOrder(Book book) {
        return new Order(book);
    }

    // equals
}
