package homework.lab9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * Created by artem on 01.11.2016.
 */
public class KeyComparators {
    static class KeyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            try {
                Integer i1 = Integer.parseInt(o1);
                Integer i2 = Integer.parseInt(o2);

                return i1.compareTo(i2);
            } catch (Exception eI) {
                try {
                    LocalDate ld1 = LocalDate.parse(o1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate ld2 = LocalDate.parse(o2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    return ld1.compareTo(ld2);
                } catch (Exception eLD) {
                    return o1.compareTo(o2);
                }
            }
        }
    }

    static class KeyComparatorReverse implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            try {
                Integer i1 = Integer.parseInt(o1);
                Integer i2 = Integer.parseInt(o2);

                return i2.compareTo(i1);
            } catch (Exception eI) {
                try {
                    LocalDate ld1 = LocalDate.parse(o1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate ld2 = LocalDate.parse(o2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    return ld2.compareTo(ld1);
                } catch (Exception eLD) {
                    return o2.compareTo(o1);
                }
            }
        }
    }
}
