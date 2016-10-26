package homework.lab7.stage1;

import java.io.*;

public class Connector {
    private String filename;

    public Connector(String filename) {
        this.filename = filename;
    }

    public void write(Object[] libraryObjects) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);

        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(libraryObjects.length);

            for (Object libraryObject : libraryObjects) {
                oos.writeObject(libraryObject);
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
