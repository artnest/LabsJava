package homework.lab7;

import java.util.HashSet;
import java.util.Set;

class Administrator extends LibraryPart {
    private static Administrator ourInstance = new Administrator();

    static Administrator getInstance() {
        return ourInstance;
    }

    private Administrator() {
        super("Administrator", Type.STAFF);
    }

    private Set<Reader> blackList = new HashSet<>();

    void addToBlacklist(Book book, Reader reader) {
        /*if (!book.isInLibrary()) {
            blackList.add(reader);
        }*/
    }
}
