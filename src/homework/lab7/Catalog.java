package homework.lab7;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;

/**
 * Created by theme on 10/5/16.
 */
class Catalog extends HashMap<Book, Integer> {
    private static Catalog ourInstance = new Catalog();

    static Catalog getInstance() {
        return ourInstance;
    }

    private Catalog() {
    }

    {
        try (LineNumberReader reader = new LineNumberReader(new FileReader("books.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                try {
                    String[] strings = s.split(" ");

                    if (strings.length == 2) {
                        Book book = new Book(strings[0], strings[1]);

                        if (this.containsKey(book)) {
                            this.put(book, this.get(book) + 1);
                        } else {
                            this.put(book, 1);
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid book data: line " + reader.getLineNumber());
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
