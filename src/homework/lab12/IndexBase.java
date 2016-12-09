package homework.lab12;

import java.util.Comparator;

interface IndexBase {
    String[] getKeys(Comparator<String> comparator);
    void put(String key, long value);
    boolean contains(String key);
    long[] get(String key);
}
