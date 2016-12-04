package homework.lab12;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        try {
            if (args.length >= 1) {
                if (args[0].equals("-?") || args[0].equals("-h")) {
                    System.out.println(
                            "Syntax:\n" +
                                    "\t-a   [file [encoding]] - append data\n" +
                                    "\t-az  [file [encoding]] - append data, compress every record\n" +
                                    "\t-d                     - clear all data\n" +
                                    "\t-dk  {h|a|o|d} key     - clear data by key\n" +
                                    "\t-p                     - print data unsorted\n" +
                                    "\t-ps  {h|a|o|d}         - print sorted by numberHouse/" +
                                                                                "numberApartment/" +
                                                                                "owner/" +
                                                                                "paymentDate\n" +
                                    "\t-psr {h|a|o|d}         - print data reverse sorted by numberHouse/" +
                                                                                            "numberApartment/" +
                                                                                            "owner/" +
                                                                                            "paymentDate\n" +
                                    "\t-f   {h|a|o|d}         - find records by key\n" +
                                    "\t-fr  {h|a|o|d}         - find records > key\n" +
                                    "\t-fl  {h|a|o|d}         - find records < key\n" +
                                    "\t-?, -h                 - command line syntax\n"
                    );
                } else if (args[0].equals("-a")) {
                    appendFile(args, false);
                } else if (args[0].equals("-az")) {
                    appendFile(args, true);
                } else if (args[0].equals("-p")) {
                    printFile();
                } else if (args[0].equals("-ps")) {
                    if (!printFile(args, false)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-psr")) {
                    if (!printFile(args, true)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-d")) {
                    if (args.length != 1) {
                        System.err.println("Invalid number of arguments");
                        System.exit(1);
                    }

                    deleteFile();
                } else if (args[0].equals("-dk")) {
                    if (!deleteFile(args)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-f")) {
                    if (!findByKey(args)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-fr")) {
                    if (!findByKey(args, new KeyComparators.KeyComparator())) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-fl")) {
                    if (!findByKey(args, new KeyComparators.KeyComparatorReverse())) {
                        System.exit(1);
                    }
                } else {
                    System.err.println("Option isn't realized: " + args[0]);
                    System.exit(1);
                }
            } else {
                System.err.println("PublicServicesAccounts: Nothing to do! Enter -? for options.");
            }
        } catch (Exception e) {
            System.err.println("Runtime error: " + e);
            System.exit(1);
        }

        System.out.println("Bill finished...");
        System.exit(0);
    }

    static final String filename    = "Bills.dat";
    static final String filenameBak = "Bills.~dat";
    static final String idxname     = "Bills.idx";
    static final String idxnameBak  = "Bills.~idx";

    private static String encoding = "CP866";
    private static PrintStream billsOut = System.out;

    static Bill readBill(Scanner fin) throws IOException {
        return Bill.nextRead(fin, billsOut) ? Bill.read(fin, billsOut) : null;
    }

    private static void deleteBackup() {
        new File(filename).delete();
        new File(idxname).delete();
    }

    private static void deleteFile() {
        deleteBackup();
        new File(filename).renameTo(new File(filenameBak));
        new File(idxname).renameTo(new File(idxnameBak));
    }

    private static void backup() {
        deleteBackup();
        new File(filename).renameTo(new File(filenameBak));
        new File(idxname).renameTo(new File(idxnameBak));
    }

    static boolean deleteFile(String[] args) throws IOException, ClassNotFoundException, KeyNotUniqueException {
        if (args.length != 4) {
            System.err.println("Invalid number of arguments");
            return false;
        }

        long[] positions = null;
        try (Index idx = Index.load(idxname)) {
            IndexBase pidx = indexByArg(args[1], idx);

            if (pidx == null) {
                return false;
            }
            if (!pidx.contains(args[2])) {
                System.err.println("Key not found: " + args[2]);
                return false;
            }

            positions = pidx.get(args[2]);
        }

        backup();
        Arrays.sort(positions);
        try (Index idx = Index.load(idxname);
            RandomAccessFile fileBak = new RandomAccessFile(filenameBak, "rw");
            RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            boolean[] wasZipped = new boolean[] { false };

            long pos;
            while ((pos = fileBak.getFilePointer()) < fileBak.length()) {
                    Bill bill = (Bill) Buffer.readObject(fileBak, pos, wasZipped);

                if (Arrays.binarySearch(positions, pos) < 0) {
                    long ptr = Buffer.writeObject(file, bill, wasZipped[0]);
                    idx.put(bill, ptr);
                }
            }

            return true;
        }
    }

    static void appendFile(String[] args, Boolean zipped) throws IOException, KeyNotUniqueException, ClassNotFoundException {
        if (args.length >= 2) {
            FileInputStream stdin = new FileInputStream(args[1]);
            System.setIn(stdin);

            if (args.length == 3) {
                encoding = args[2];
            }

            billsOut = new PrintStream("nul");
//            billsOut = new PrintStream("/dev/null");
        }

        appendFile(zipped);
    }

    static void appendFile(Boolean zipped) throws IOException, ClassNotFoundException, KeyNotUniqueException {
        Scanner fin = new Scanner(System.in, encoding);
        billsOut.println("Enter account data:");

        try (Index idx = Index.load(idxname);
             RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            for (;;) {
                Bill bill = readBill(fin);

                if (bill == null) {
                    break;
                }

                idx.test(bill);
                long pos = Buffer.writeObject(raf, bill, zipped);
                idx.put(bill, pos);
            }
        }
    }

    private static void printRecord(RandomAccessFile raf, long pos) throws IOException, ClassNotFoundException {
        boolean[] wasZipped = new boolean[] {
                false
        };

        Bill bill = (Bill) Buffer.readObject(raf, pos, wasZipped);
        if (wasZipped[0]) {
            System.out.println(" compressed");
        }
        System.out.println(" record at position " + pos + ": \n" + bill);
    }

    private static void printRecord(RandomAccessFile raf, String key, IndexBase pidx) throws IOException, ClassNotFoundException {
        long[] positions = pidx.get(key);

        for (long position : positions) {
            System.out.println("*** Key: " + key + " points to");
            printRecord(raf, position);
        }
    }

    static void printFile() throws IOException, ClassNotFoundException {
        long pos;
        int rec = 0;

        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            while ((pos = raf.getFilePointer()) < raf.length()) {
                System.out.println("#" + (++rec));
                printRecord(raf, pos);
            }
            System.out.flush();
        }
    }

    private static IndexBase indexByArg(String arg, Index idx) {
        IndexBase pidx = null;

        if (arg.equals("h")) {
            pidx = idx.numbersHouse;
        } else if (arg.equals("a")) {
            pidx = idx.numbersApartment;
        } else if (arg.equals("o")) {
            pidx = idx.owners;
        } else if (arg.equals("d")) {
            pidx = idx.paymentDates;
        } else {
            System.err.println("Invalid index specified: " + arg);
        }

        return pidx;
    }

    static boolean printFile(String[] args, boolean reverse) throws IOException, ClassNotFoundException {
        if (args.length != 2) {
            System.err.println("Invalid number of arguments");
            return false;
        }

        try (Index idx = Index.load(idxname);
            RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            IndexBase pidx = indexByArg(args[1], idx);

            if (pidx == null) {
                return false;
            }

            String[] keys = pidx.getKeys(reverse ? new KeyComparators.KeyComparatorReverse() : new KeyComparators.KeyComparator());

            for (String key : keys) {
                printRecord(raf, key, pidx);
            }

            return true;
        }
    }

    static boolean findByKey(String[] args) throws IOException, ClassNotFoundException {
        if (args.length != 3) {
            if (args[1].equals("o") && args.length > 3) {
                for (int i = 3; i < args.length; i++) {
                    args[2] += " " + args[i];
                }
            } else {
                System.err.println("Invalid number of arguments");
                return false;
            }
        }

        try (Index idx = Index.load(idxname);
            RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            IndexBase pidx = indexByArg(args[1], idx);

            if (!pidx.contains(args[2])) {
                System.err.println("Key not found: " + args[2]);
                return false;
            }

            printRecord(raf, args[2], pidx);
        }

        return true;
    }

    static boolean findByKey(String[] args, Comparator<String> comparator) throws ClassNotFoundException, IOException {
        if (args.length != 3) {
            if (args[1].equals("o") && args.length > 3) {
                for (int i = 3; i < args.length; i++) {
                    args[2] += " " + args[i];
                }
            } else {
                System.err.println("Invalid number of arguments");
                return false;
            }
        }

        try (Index idx = Index.load(idxname);
             RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            IndexBase pidx = indexByArg(args[1], idx);

            if (!pidx.contains(args[2])) {
                System.err.println("Key not found: " + args[2]);
                return false;
            }

            String[] keys = pidx.getKeys(comparator);
            for (String key : keys) {
                if (key.equals(args[2])) {
                    break;
                }

                printRecord(raf, key, pidx);
            }
        }

        return true;
    }
}
