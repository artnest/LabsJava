package homework.lab7;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

class Catalog extends LibraryPart {
    private static Catalog ourInstance = new Catalog();

    static Catalog getInstance() {
        return ourInstance;
    }

    private Catalog() {
        super("Catalog", Type.ITEM);
    }

    Map<Book, Integer> booksCatalog = new HashMap<>();

    void setBooksCatalog(String filename) {
        try (LineNumberReader reader = new LineNumberReader(new FileReader(filename))) {
            String s;

            while ((s = reader.readLine()) != null) {
                try {
                    assert !s.isEmpty(): "Empty string: " + reader.getLineNumber();
                    String[] strings = s.split(" by ");

                    if (strings.length == 2) {
                        Book book = new Book(strings[0].replace("\"", "").trim(), strings[1].trim());

                        if (booksCatalog.containsKey(book)) {
                            booksCatalog.put(book, booksCatalog.get(book) + 1);
                        } else {
                            booksCatalog.put(book, 1);
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid book data: " +
                                                            "file " + filename + ", line " + reader.getLineNumber());
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
        booksCatalog.forEach((book, amount) -> System.out.println(book + ", " + amount.toString()));
    }

    public String toStringBooksCatalog() {
        StringBuilder stringBooksCatalog = new StringBuilder();

        for (Book book : booksCatalog.keySet()) {
//            stringBooksCatalog.append(book + ", " + booksCatalog.get(book) + System.lineSeparator());
            stringBooksCatalog.append(book).append(", ").append(booksCatalog.get(book)).append(System.lineSeparator());
        }

        return stringBooksCatalog.toString();
    }
}
