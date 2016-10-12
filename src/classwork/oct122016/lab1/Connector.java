package classwork.oct122016.lab1;

import java.io.*;

/**
 * Created by theme on 10/12/16.
 */
public class Connector {
    private String filename;

    public Connector(String n) {
        filename = n;
    }

    public void write(Instrument[] band) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(band.length);

            for (int i = 0; i < band.length; i++) {
                oos.writeObject(band[i]);
            }

            oos.flush();
        }
    }

    public Instrument[] read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        try(ObjectInput ois = new ObjectInputStream(fis)) {
            int length = ois.readInt();

            Instrument[] r = new Instrument[length];
            for (int i = 0; i < length; i++) {
                r[i] = ((Instrument) ois.readObject());
            }

            return r;
        }
    }
}
