package homework.lab12;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Comparator;

class Bills {
    private static void deleteBackup() {
        new File(MainForm.getFilenamePath()).delete();
        new File(MainForm.getIdxnamePath()).delete();
    }

    static void deleteFile() {
        deleteBackup();
        new File(MainForm.getFilenamePath()).renameTo(new File(MainForm.getFilenameBakPath()));
        new File(MainForm.getIdxnamePath()).renameTo(new File(MainForm.getIdxnameBakPath()));
    }

    private static void backup() {
        deleteBackup();
        new File(MainForm.getFilenamePath()).renameTo(new File(MainForm.getFilenameBakPath()));
        new File(MainForm.getIdxnamePath()).renameTo(new File(MainForm.getIdxnameBakPath()));
    }

    static boolean deleteFile(String key, String value)
            throws IOException, ClassNotFoundException, IllegalArgumentException, KeyNotUniqueException {
        if (key.equals("owner")) {
            if (value.split(" ").length != 3) {
                throw new IllegalArgumentException("Invalid data!");
            }
        }

        long[] positions;
        try (Index idx = Index.load(MainForm.getIdxnamePath())) {
            IndexBase pidx = indexByArg(key, idx);

            if (pidx == null) {
                return false;
            }
            if (!pidx.contains(value)) {
                throw new IllegalArgumentException("Key not found: " + value);
            }

            positions = pidx.get(value);
        }

        backup();
        Arrays.sort(positions);
        try (Index idx = Index.load(MainForm.getIdxnamePath());
            RandomAccessFile fileBak = new RandomAccessFile(MainForm.getFilenameBakPath(), "rw");
            RandomAccessFile file = new RandomAccessFile(MainForm.getFilenamePath(), "rw")) {
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

    static void appendFile(Boolean zipped, Bill bill, String filePath)
            throws IOException, ClassNotFoundException, KeyNotUniqueException {
        try (Index idx = Index.load(MainForm.getIdxnamePath());
             RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
                if (bill == null) {
                    return;
                }

                idx.test(bill);
                long pos = Buffer.writeObject(raf, bill, zipped);
                idx.put(bill, pos);
        }
    }

    private static void printRecord(JTextPane textPane, RandomAccessFile raf, long pos, String text)
            throws IOException, ClassNotFoundException, BadLocationException {
        boolean[] wasZipped = new boolean[] { false };

        Bill bill = (Bill) Buffer.readObject(raf, pos, wasZipped);
        if (wasZipped[0]) {
            text += " compressed";
        }
        text += " record at position " + pos + ": \n" + bill;

        appendText(textPane, text);
    }

    private static void appendText(JTextPane textPane, String text) throws BadLocationException {
        StyledDocument document = textPane.getStyledDocument();
        document.insertString(document.getLength(), text + "\n\n", null);
    }

    private static void printRecord(JTextPane textPane, RandomAccessFile raf, String key, IndexBase pidx)
            throws IOException, ClassNotFoundException, BadLocationException {
        long[] positions = pidx.get(key);

        for (long position : positions) {
            String text = "** Key: " + key + " points to";
            printRecord(textPane, raf, position, text);
        }
    }

    static void printFile(JTextPane textPane)
            throws IOException, ClassNotFoundException, BadLocationException {
        textPane.setText(null);

        long pos;
        int rec = 0;

        String text = null;
        try (RandomAccessFile raf = new RandomAccessFile(MainForm.getFilenamePath(), "rw")) {
            while ((pos = raf.getFilePointer()) < raf.length()) {
                text = "#" + (++rec);
                printRecord(textPane, raf, pos, text);
            }
        }

        if (text == null) {
            throw new IOException("File is empty!");
        }
    }

    private static IndexBase indexByArg(String arg, Index idx) throws IllegalArgumentException {
        IndexBase pidx;

        if (arg.equals("houseNumber")) {
            pidx = idx.houseNumber;
        } else if (arg.equals("apartmentNumber")) {
            pidx = idx.apartmentNumber;
        } else if (arg.equals("owner")) {
            pidx = idx.owners;
        } else if (arg.equals("paymentDate")) {
            pidx = idx.paymentDates;
        } else {
            throw new IllegalArgumentException("Invalid index specified: " + arg);
        }

        return pidx;
    }

    static boolean printFile(JTextPane textPane, String key, boolean reverse)
            throws IOException, ClassNotFoundException, IllegalArgumentException, BadLocationException {
        textPane.setText(null);

        try (Index idx = Index.load(MainForm.getIdxnamePath());
            RandomAccessFile raf = new RandomAccessFile(MainForm.getFilenamePath(), "rw")) {
            IndexBase pidx = indexByArg(key, idx);

            if (pidx == null) {
                return false;
            }

            String[] keys = pidx.getKeys(reverse ?
                                        new KeyComparators.KeyComparatorReverse() :
                                        new KeyComparators.KeyComparator());

            for (String keyInFile : keys) {
                printRecord(textPane, raf, keyInFile, pidx);
            }

            return true;
        }
    }

    static boolean findByKey(JTextPane textPane, String key, String value)
            throws IOException, ClassNotFoundException, IllegalArgumentException, BadLocationException {
        if (key.equals("owner")) {
            if (value.split(" ").length != 3) {
                throw new IllegalArgumentException("Invalid data!");
            }
        }

        try (Index idx = Index.load(MainForm.getIdxnamePath());
            RandomAccessFile raf = new RandomAccessFile(MainForm.getFilenamePath(), "rw")) {
            IndexBase pidx = indexByArg(key, idx);

            if (!pidx.contains(value)) {
                throw new IllegalArgumentException("Key not found: " + value);
            }

            printRecord(textPane, raf, value, pidx);
        }

        return true;
    }

    static boolean findByKey(JTextPane textPane, String key, String value, Comparator<String> comparator)
            throws IOException, ClassNotFoundException, IllegalArgumentException, BadLocationException {
        if (key.equals("owner")) {
            if (value.split(" ").length != 3) {
                throw new IllegalArgumentException("Invalid data!");
            }
        }

        try (Index idx = Index.load(MainForm.getIdxnamePath());
             RandomAccessFile raf = new RandomAccessFile(MainForm.getFilenamePath(), "rw" )) {
            IndexBase pidx = indexByArg(key, idx);

            if (!pidx.contains(value)) {
                throw new IllegalArgumentException("Key not found: " + value);
            }

            String[] keys = pidx.getKeys(comparator);
            for (String keyInKeys : keys) {
                if (keyInKeys.equals(value)) {
                    break;
                }

                printRecord(textPane, raf, keyInKeys, pidx);
            }
        }

        return true;
    }
}
