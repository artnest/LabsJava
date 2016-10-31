package homework.lab8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class PSAccounts {
    static boolean optionZip = true;

    static final String filename = "PSAccounts.dat";
    private static Scanner fin = new Scanner(System.in);

    static PublicServicesAccount readBill() {
        if (fin.hasNextLine()) {
            return PublicServicesAccount.read(fin);
        }
        return null;
    }

    static void deleteFile() {
        File f = new File(filename);
        f.delete();
    }

    static void appendFile() throws IOException {
        PublicServicesAccount publicServicesAccount;
        System.out.println("Enter publicServicesAccount data:");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            while ((publicServicesAccount = readBill()) != null) {
                Buffer.writeObject(raf, publicServicesAccount);
            }
        }
    }

    static void printFile() throws IOException, ClassNotFoundException {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long pos;
            while ((pos = raf.getFilePointer()) < raf.length()) {
                PublicServicesAccount publicServicesAccount = (PublicServicesAccount) Buffer.readObject(raf, pos);
                System.out.println(pos + ": " + publicServicesAccount);
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
