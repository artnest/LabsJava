package homework.lab8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Bills {
    static boolean optionZip = true;

    static final String filename = "Bills.dat";
    private static Scanner fin = new Scanner(System.in);

    static Bill readBill() {
        if (fin.hasNextLine()) {
            return Bill.read(fin);
        }
        return null;
    }

    static void deleteFile() {
        File f = new File(filename);
        f.delete();
    }

    static void appendFile() throws IOException {
        Bill bill;
        System.out.println("Enter bill data:");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            while ((bill = readBill()) != null) {
                Buffer.writeObject(raf, bill);
            }
        }
    }

    static void printFile() throws IOException, ClassNotFoundException {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long pos;
            while ((pos = raf.getFilePointer()) < raf.length()) {
                Bill bill = (Bill) Buffer.readObject(raf, pos);
                System.out.println(pos + ": " + bill);
            }
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length >= 1) {
                if (args[0].compareTo("-a") == 0) {
                    appendFile();
                } else if (args[0].compareTo("-p") == 0) {
                    printFile();
                } else if (args[0].compareTo("-d") == 0) {
                    deleteFile();
                }
            } else {
                System.err.println("Bills: Nothing to do!");
            }
        } catch (Exception e) {
            System.err.println("Runtime error" + e);
            System.exit(1);
        }

        System.out.println("Bills finished...");
        System.exit(0);
    }
}
