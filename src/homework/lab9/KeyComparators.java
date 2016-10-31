package homework.lab9;

import java.util.Comparator;

/**
 * Created by artem on 01.11.2016.
 */
public class KeyComparators {
    static class KeyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    static class KeyComparatorReverse implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
