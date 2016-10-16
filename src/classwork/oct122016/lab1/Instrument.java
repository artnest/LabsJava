package classwork.oct122016.lab1;

import java.io.Serializable;

/**
 * Created by theme on 10/12/16.
 */
public class Instrument implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public enum Type { PERCUSSION, STRINGED, WIND }

    private Type type;

    public Type getType() {
        return type;
    }

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Instrument: " + name +
                ", type: " + type.toString() + ", info: " + info;
    }

    public Instrument() {
    }

    public Instrument(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
