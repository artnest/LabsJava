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

    public Set<Reader> getBlackList() {
        return blackList;
    }

    void showBlackList() {
        blackList.forEach(System.out::println);
    }

    void addToBlacklist(Reader reader) {
        if (!reader.getBookSet().isEmpty()) {
            blackList.add(reader);
        }
    }

    // removeFromBlackList()
}
