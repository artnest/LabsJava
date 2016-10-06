package homework.lab7;

import java.util.Set;

/**
 * Created by theme on 10/6/16.
 */
public class Administrator {
    private static Administrator ourInstance = new Administrator();

    public static Administrator getInstance() {
        return ourInstance;
    }

    private Administrator() {
    }

    private Set<Reader> blackList;

    public void addToBlacklist(Book book, Reader reader) {
        /*if (!book.isInLibrary()) {
            blackList.add(reader);
        }*/
    }
}
