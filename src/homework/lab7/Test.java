package homework.lab7;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();
        //boolean bookIsInLibrary = library.checkBooks(new Book("B", "def"));
        //System.out.println(bookIsInLibrary);
        library.getCatalog().setBooksCatalog("books.txt");
        System.out.println(library.getAdministrator());

        Reader reader = new Reader();
//        System.out.println(library.checkBooks(new Order(new Book("B", "def"))));

        Book book = new Book("B", "def");
        Order order = new Order(book);

        Set<Book> booksInLibrarySet = library.checkBooks(order);
        if (!booksInLibrarySet.isEmpty()) {
            library.getLibrarian().giveBooks(booksInLibrarySet, reader, order.getPlace());
        } else {
            System.out.println("Данные книги в каталоге отсутствуют!");
        }

        Connector connector = new Connector("library.dat");
        LinkedList<LibraryPart> linkedList = new LinkedList<>();
        linkedList.add(Librarian.getInstance());
        try {
            connector.write(linkedList.toArray(new LibraryPart[linkedList.size()]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Object[] objects = connector.read();
            Object[] copyObjects = objects.clone();
            LibraryPart[] libraryParts = new LibraryPart[1];
            for (int i = 0; i < objects.length; i++) {
                libraryParts[i] = (LibraryPart) copyObjects[i];
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
