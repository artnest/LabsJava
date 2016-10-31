package homework.lab9;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class PSAccounts {
    static boolean optionZip = true;

    static final String filename = "PSAccounts.dat";
    private static Scanner fin = new Scanner(System.in);

    static PubicServicesAccount readBill() {
        if (fin.hasNextLine()) {
            return PubicServicesAccount.read(fin);
        }
        return null;
    }

    static void deleteFile() {
        File f = new File(filename);
        f.delete();
    }

    static void appendFile() throws IOException {
        PubicServicesAccount pubicServicesAccount;
        System.out.println("Enter pubicServicesAccount data:");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            while ((pubicServicesAccount = readBill()) != null) {
                Buffer.writeObject(raf, pubicServicesAccount);
            }
        }
    }

    static void printFile() throws IOException, ClassNotFoundException {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long pos;
            while ((pos = raf.getFilePointer()) < raf.length()) {
                PubicServicesAccount pubicServicesAccount = (PubicServicesAccount) Buffer.readObject(raf, pos);
                System.out.println(pos + ": " + pubicServicesAccount);
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
                System.err.println("PSAccounts: Nothing to do!");
            }
        } catch (Exception e) {
            System.err.println("Runtime error" + e);
            System.exit(1);
        }

        System.out.println("PSAccounts finished...");
        System.exit(0);
    }
}
