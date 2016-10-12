package classwork.oct122016.lab1;

import java.io.Serializable;

/**
 * Created by theme on 10/12/16.
 */
public class Wind extends Instrument implements Serializable {
    public Wind(String name) {
        super(name, Instrument.Type.WIND);
    }
}
