package homework.lab9;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

public class Index implements Serializable, Closeable {
    private static final long serialVersionUID = 1L;

    public static long[] InsertValue(long[] array, long value) {
        long[] result = new long[(array == null ? 0 : array.length) + 1];
        System.arraycopy(array, 0, result, 0, result.length);
        result[result.length] = value;
        return result;
    }

    @Override
    public void close() throws IOException {

    }
}
