package homework.lab7.stage1;

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

    private Set<Reader> blacklistSet = new HashSet<>();

    public Set<Reader> getBlacklist() {
        return blacklistSet;
    }

    void showBlacklist() {
        blacklistSet.forEach(System.out::println);
    }

    boolean checkReader(Reader reader) {
        if (reader.getBookSet().isEmpty() && !blacklistSet.contains(reader)) {
            return true;
        } else if (reader.getBookSet().isEmpty() && blacklistSet.contains(reader)) {
            blacklistSet.remove(reader);
            return true;
        } else {
            blacklistSet.add(reader);
            return false;
        }
    }

    void addToBlacklist(Reader reader) {
        blacklistSet.add(reader);
    }

    void removeFromBlacklist(Reader reader) {
        blacklistSet.remove(reader);
    }
}
