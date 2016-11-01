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

    IndexOne2One numbersHouse;
    IndexOne2One numbersApartment;
    IndexOne2One owners;
    IndexOne2N paymentDates;

    public void test(PubicServicesAccount account) throws KeyNotUniqueException {

    }

    @Override
    public void close() throws IOException {

    }
}
