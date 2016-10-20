package homework.lab7;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class Test {
    static Locale createLocale(String[] args) {
        if (args.length == 2) {
            return new Locale(args[0], args[1]);
        } else if (args.length == 4) {
            return new Locale(args[2], args[3]);
        }

        return null;
    }

    static void setupConsole(String[] args) {
        if (args.length >= 2) {
            if (args[0].compareTo("-encoding") == 0) {
                try {
                    System.setOut(new PrintStream(System.out, true, args[1]));
                } catch (UnsupportedEncodingException e) {
                    System.err.println("Unsupported encoding: " + args[1]);
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        setupConsole(args);
        Locale locale = createLocale(args);

        if (locale == null) {
            System.err.println("Invalid argument(s)\n" +
                                "Syntax: [-encoding ENCODING_ID] language country\n" +
                                "Example: -encoding CP855 by BY");
            System.exit(1);
        }

        AppLocale.setLocale(locale);

        Library library1 = new Library(AppLocale.getString(AppLocale.library_part));

        library1.setInfo(AppLocale.getString(AppLocale.library));
        library1.getCatalog().setBooksCatalog("books1.txt");
        library1.getCatalog().setInfo(AppLocale.getString(AppLocale.catalog));

        library1.getAdministrator().setInfo(AppLocale.getString(AppLocale.administrator));
        library1.getLibrarian().setInfo(AppLocale.getString(AppLocale.librarian));

        Reader reader1 = new Reader("Andrew");
        Reader.Order order1 = reader1.makeOrder(new Book[] { new Book("The Grapes of Wrath", "John Steinbeck"),
                                                            new Book("1984", "George Orwell") },
                                                Reader.Place.HOME);
        library1.doOrder(reader1, order1);

        Library library2 = new Library(AppLocale.getString(AppLocale.library_part));

        library2.setInfo(AppLocale.getString(AppLocale.library));
        library2.getCatalog().setBooksCatalog("books2.txt");
        library2.getCatalog().setInfo(AppLocale.getString(AppLocale.catalog));

        library2.getAdministrator().setInfo(AppLocale.getString(AppLocale.administrator));
        library2.getLibrarian().setInfo(AppLocale.getString(AppLocale.librarian));

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
