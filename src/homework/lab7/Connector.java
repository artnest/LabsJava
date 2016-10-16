package homework.lab7;

import java.io.*;

/**
 * Created by artem on 13.10.2016.
 */
public class Connector {
    private String filename;

    public Connector(String filename) {
        this.filename = filename;
    }

    public void write(Object[] libraryObjects) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);

        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(libraryObjects.length);

            for (int i = 0; i < libraryObjects.length; i++) {
                oos.writeObject(libraryObjects[i]);
            }

            oos.flush();
        }
    }

    public Object[] read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);

        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            int length = ois.readInt();

            Object[] libraryObjects = new Object[length];
            for (int i = 0; i < length; i++) {
                libraryObjects[i] = ois.readObject();
            }

            return libraryObjects;
        }
    }
}
