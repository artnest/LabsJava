package homework.lab7;

import java.io.Serializable;

abstract class LibraryPart implements Serializable {
    enum Type { LIBRARY, ITEM, STAFF, USER, ORDER }

    private String name;
    private Type type;
    private String info;

    LibraryPart(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    LibraryPart() {
    }

    String getName() {
        return name;
    }

    Type getType() {
        return type;
    }

    String getInfo() {
        return info;
    }

    void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "LibraryPart: " + name + ", type: " + type + ", info: " + info;
    }
}
