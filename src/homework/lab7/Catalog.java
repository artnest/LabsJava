package homework.lab7;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;

class Catalog extends LibraryPart {
    private static Catalog ourInstance = new Catalog();

    static Catalog getInstance() {
        return ourInstance;
    }

    private Catalog() {
        super("Catalog", Type.ITEM);
    }

    HashMap<Book, Integer> booksCatalog = new HashMap<>();

    void setBooksCatalog(String filename) {
        try (LineNumberReader reader = new LineNumberReader(new FileReader("books.txt"))) {
            String s;

            while ((s = reader.readLine()) != null) {
                try {
                    assert !s.isEmpty(): "Empty string: " + reader.getLineNumber();
                    String[] strings = s.split(" ");

                    if (strings.length == 2) {
                        Book book = new Book(strings[0], strings[1]);

                        if (booksCatalog.containsKey(book)) {
                            booksCatalog.put(book, booksCatalog.get(book) + 1);
                        } else {
                            booksCatalog.put(book, 1);
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

    void showBooksCatalog() {
        booksCatalog.forEach((book, amount) -> System.out.println(book + " " + amount.toString()));
    }
}
