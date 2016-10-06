package classwork.oct052016;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by theme on 10/5/16.
 */
public class Contact implements Comparable<Contact>, Iterable<String>, Iterator<String> {
    public static class ArgException extends Exception {
        public ArgException(String arg) {
            super("Invalid argument: " + arg);
        }
    }

    public static final String[] names = { "*Contact",
                                            "*Mobile",
                                            "Work",
                                            "Home",
                                            "E-mail",
                                            "WWW-page",
                                            "Address" };

    public static final String[] formatStr = { "%-9s",
                                                "%-9s",
                                                "%-9s",
                                                "%-9s",
                                                "%-17s",
                                                "%-17s",
                                                "%-9s" };

    private static int sortBy = 0;

    public static int getSortBy() {
        return sortBy;
    }

    public static void setSortBy(int i) {
        if (i < 0 || i >= names.length) {
            throw new IndexOutOfBoundsException();
        }
        sortBy = i;
    }

    public static String getSortByName() {
        return names[sortBy];
    }

    protected boolean validXXX(String str) {
        return str != null && str.length() > 0;
    }

    private String[] areas = null;

    public int length() {
        return areas.length;
    }

    public String getArea(int idx) {
        if (idx < 0 || idx >= length()) {
            throw new IndexOutOfBoundsException();
        }
        return areas[idx];
    }

    public void setArea(int idx, String val) throws ArgException {
        if (idx >= length() || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        /*if ((idx == 0 && valName(val) == false) ||
                (idx == 1 && validMobile(val) == false) || *//*...*//*) {
            throw new ArgException(val);
            areas[idx] = val;
        }*/
    }

    public Iterator<String> iterator() {
        reset();
        return this;
    }

    private int iterator_idx = 0;

    public void reset() {
        iterator_idx = 0;
    }

    public boolean hasNext() {
        return iterator_idx < areas.length;
    }

    @Override
    public void remove() {
        /*nothing*/
    }

    @Override
    public String next() {
        if (iterator_idx < areas.length) {
            return areas[iterator_idx++];
        }
        reset();
        return null;
    }

    @Override
    public int compareTo(Contact c) {
        return areas[sortBy].compareTo(c.areas[sortBy]);
    }

    @Override
    public String toString() {
        if (areas == null) {
            return " | | | | | | ";
        }
        String res = areas[0];
        for (int i = 0; i < areas.length; i++) {
            res += "|" + areas[i];
        }

        return res;
    }

    private void setup(String[] args) throws ArgException {
        if (args == null) {
            throw new ArgException("null int setup");
        }

        if (args.length < 2 || args.length > names.length) {
            throw new ArgException(Arrays.toString(args));
        }

        areas = new String[names.length];
        int i = 0;

        for (i = 0; i < args.length; i++) {
            setArea(i, args[i]);
        }

        while (i < areas.length) {
            areas[i] = "";
        }
    }

    public Contact(String str) throws ArgException {
        if (str == null) {
            throw new ArgException("null ptr in construct");
        }

        int num = 1;
        int idx = 0;
        int idxFrom = 0;

        while ((idx = str.indexOf('|', idxFrom)) != -1) {
            idxFrom = idx + 1;
            num++;
        }

        String[] args = new String[num];
        num = idx = idxFrom = 0;

        //while () {}
    }

    public Contact(String[] args) throws ArgException {
        setup(args);
    }

    private static String format(Iterable<String> what) {
        String result = "";
        int idx = 0;

        for (String str : what) {
            result += String.format(formatStr[idx++], str);
        }

        return result;
    }

    public static String format() {
        return format(Arrays.asList(names));
    }

    public static String format(Contact cn) {
        //return format((Iterator<String>) cn);
        return format(cn);
    }
}
