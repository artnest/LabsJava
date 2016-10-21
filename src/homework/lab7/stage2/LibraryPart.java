package homework.lab7.stage2;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

abstract class LibraryPart implements Serializable {
    public final Date creationDate = new Date();

    public String getCreationDate() {
        DateFormat dateFormatter = DateFormat.getDateTimeInstance(
                DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.getLocale());

        return dateFormatter.format(creationDate);
    }

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
        return AppLocale.getString(AppLocale.library_part) + ": " + name + ", " +
                AppLocale.getString(AppLocale.type) + ": " + type + ", " +
                AppLocale.getString(AppLocale.info) + ": " + info + ", " +
                AppLocale.getString(AppLocale.creation) + ": " + getCreationDate();
    }
}
