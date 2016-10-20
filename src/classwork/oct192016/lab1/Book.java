package classwork.oct192016.lab1;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    String strISBN;
    String author;
    String name;
    String year;
    String publisher;
    String annotation;
    String price;

    public Book() {
    }

    public static Book read(Scanner fin) {
        Book book = new Book;
        book.strISBN = fin.nextLine();

        //
    }

    @Override
    public String toString() {
        return new String(strISBN + " | " +
                author + " | " +
                name + " | " +
                year + " | " +
                publisher + " | " +
                annotation + " | " +
                price);
    }
}
