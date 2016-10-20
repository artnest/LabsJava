package homework.lab7;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        Library library1 = new Library("The National Library of Belarus");

        library1.setInfo("Belarus");
        library1.getCatalog().setBooksCatalog("books1.txt");
        library1.getCatalog().setInfo("Main catalog");

        library1.getAdministrator().setInfo("Library Administrator");
        library1.getLibrarian().setInfo("Old Librarian");

        Reader reader1 = new Reader("Andrew");
        Reader.Order order1 = reader1.makeOrder(new Book[] { new Book("The Grapes of Wrath", "John Steinbeck"),
                                                            new Book("1984", "George Orwell") },
                                                Reader.Place.HOME);
        library1.doOrder(reader1, order1);

        Library library2 = new Library("The London Library");

        library2.setInfo("The UK");
        library2.getCatalog().setBooksCatalog("books2.txt");
        library2.getCatalog().setInfo("Big catalog");

        library2.getAdministrator().setInfo("Sir Tom Stoppard");
        library2.getLibrarian().setInfo("Inez Lynn");

        Reader reader2 = new Reader("Steve");
        Reader.Order order2 = reader2.makeOrder(new Book[] { new Book("Gone with the Wind", "Margaret Mitchell"),
                        new Book("Memoirs of a Geisha", "Arthur Golden") },
                Reader.Place.HOME);
        library2.doOrder(reader2, order2);

        library1.getLibrarian().returnBooks(library1.getCatalog(), reader1);
        library2.getLibrarian().returnBooks(library2.getCatalog(), reader2);

        Connector connector = new Connector("libraries.dat");
        LibraryPart[] libraries = new LibraryPart[2];
        libraries[0] = library1;
        libraries[1] = library2;

        try {
            connector.write(libraries);

            Object[] objects = connector.read();
            LibraryPart[] copyLibraries = new LibraryPart[objects.length];

            for (int i = 0; i < copyLibraries.length; i++) {
                copyLibraries[i] = (LibraryPart) objects[i];
            }

            for (LibraryPart library : copyLibraries) {
                System.out.println(library);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage() + "; " + e.getCause());
        }

        library1.getCatalog().showBooksCatalog();
        library2.getCatalog().showBooksCatalog();
    }
}
