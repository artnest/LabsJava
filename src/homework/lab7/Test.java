package homework.lab7;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();
        library.getCatalog().setBooksCatalog("books.txt");

        System.out.println(library.getAdministrator());
        System.out.println(library.getAdministrator().getInfo());

        Reader reader = new Reader();
        Reader.Order order = reader.makeOrder(new Book("B", "def"), Reader.Place.HOME);

        Set<Book> booksInLibrarySet = library.checkBooks(order);
        if (!booksInLibrarySet.isEmpty() && library.getAdministrator().checkReader(reader)) {
            library.getLibrarian().giveBooks(library.getCatalog(), booksInLibrarySet, reader, order.getPlace());
        } else {
            System.out.println("Данные книги в каталоге отсутствуют, или " +
                    "читатель не может делать заказы (находится в черном списке)!");
        }

        Connector connector = new Connector("library.dat");

        LinkedList<LibraryPart> linkedList = new LinkedList<>();
        linkedList.add(Librarian.getInstance());

        try {
            connector.write(linkedList.toArray(new LibraryPart[linkedList.size()]));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Object[] objects = connector.read();
            LibraryPart[] libraryParts = new LibraryPart[objects.length];

            for (int i = 0; i < objects.length; i++) {
                libraryParts[i] = (LibraryPart) objects[i];
            }

            for (LibraryPart libraryPart : libraryParts) {
                System.out.println(libraryPart);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage() + "; " + e.getCause());
        }

        library.getCatalog().showBooksCatalog();
    }
}
