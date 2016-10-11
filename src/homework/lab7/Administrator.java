package homework.lab7;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by theme on 10/6/16.
 */
class Administrator {
    private static Administrator ourInstance = new Administrator();

    static Administrator getInstance() {
        return ourInstance;
    }

    private Administrator() {
    }

    private Set<Reader> blackList = new HashSet<>();

    void addToBlacklist(Book book, Reader reader) {
        /*if (!book.isInLibrary()) {
            blackList.add(reader);
        }*/
    }
}
