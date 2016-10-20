package classwork.oct192016.lab1;

import java.io.*;

/**
 * Created by theme on 10/19/16.
 */
public class Buffer {
    static byte[] toByteArray(Serializable obj) throws IOException {
        ByteArrayOutputStream bufOut = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bufOut)) {
            oos.writeObject(obj);
            oos.flush();
            return bufOut.toByteArray();
        }
    }

    static Object itemByteArray(byte[] arr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bufIn = new ByteArrayInputStream(arr);
        try (ObjectInputStream ois = new ObjectInputStream(bufIn)) {
            return ois.readObject();
        }
    }

    public static long writeObject(RandomAccessFile file, Serializable obj) throws IOException {
        long result = file.length();
        file.seek(result);
        byte[] what = toByteArray(obj);
        file.writeInt(what.length);
        file.write(what);
        //file.setLength(file.getFilePointer());
        return result;
    }

    public static Object readObject(RandomAccessFile file, long pos) throws IOException, ClassNotFoundException {
        file.seek(pos);
        int length = file.readInt();
        byte[] what = new byte[length];
        file.read(what);
        //return fromByteArray(what);
        return null;
    }
}
