package classwork.oct192016.lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by theme on 10/19/16.
 */
public class Books {
    static final String filename = "Books.dat";
    private static Scanner fin = new Scanner(System.in);

    static Book read_book() {
        if (fin.hasNextLine()) {
            return Book.read(fin);
        }

        return null;
    }

    static void delete_file() {
        File f = new File(filename);
        f.delete();
    }

    public static void main(String[] args) {
        try {
            if (args.length >= 1) {
                if (args[0].equals("_a")) {
                    append_file();
                } else if (args[0].equals("_p")) {
                    print_file();
                } else {
                    if (args[0].equals("_d")) {
                        delete_file();
                    } else {
                        System.err.println("Option isn't realized");
                        System.exit(1);
                    }
                }
            } else {
                System.err.println("Books : Nothing to do!");
            }
        } catch (Exception e) {
            System.err.println("RuntimeError: " + e);
        }
    }

    static void append_file() throws IOException, FileNotFoundException {
        Book book;
        System.out.println("Enter book data: ");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            while ((book = read_book()) != null) {
                Buffer.writeObject(raf, book);
            }
        }
    }

    static void print_file() throws IOException, ClassNotFoundException, FileNotFoundException {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long pos;
            while ((pos = raf.getFilePointer()) < raf.length()) {
                Book book = (Book) Buffer.readObject(raf, pos);
                System.out.println(pos + ": " + book);
            }
        }
    }
}
