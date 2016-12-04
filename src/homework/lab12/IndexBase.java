package homework.lab12;

import java.util.Comparator;

/**
 * Created by artem on 01.11.2016.
 */
interface IndexBase {
    String[] getKeys(Comparator<String> comparator);
    void put(String key, long value);
    boolean contains(String key);
    long[] get(String key);
}
