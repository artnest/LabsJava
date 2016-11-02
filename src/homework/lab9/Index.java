package homework.lab9;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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
    IndexOne2N   paymentDates;

    public void test(PublicServicesAccount account) throws KeyNotUniqueException {
        assert account != null;

        if (numbersHouse.contains(String.valueOf(account.getNumberHouse()))) {
            throw new KeyNotUniqueException(String.valueOf(account.getNumberHouse()));
        }

        if (numbersApartment.contains(String.valueOf(account.getNumberHouse()))) {
            throw new KeyNotUniqueException(String.valueOf(account.getNumberApartment()));
        }

        if (owners.contains(String.valueOf(account.getNumberHouse()))) {
            throw new KeyNotUniqueException(account.getOwner());
        }
    }

    public void put(PublicServicesAccount account, long value) throws KeyNotUniqueException {
        test(account);
        numbersHouse.put(String.valueOf(account.getNumberHouse()), value);
        numbersApartment.put(String.valueOf(account.getNumberApartment()), value);
        owners.put(account.getOwner(), value);
        paymentDates.put(account.getPaymentDate().toString(), value);
    }

    public Index() {
        numbersHouse = new IndexOne2One();
        numbersApartment = new IndexOne2One();
        owners = new IndexOne2One();
        paymentDates = new IndexOne2N();
    }

    public static Index load(String name) throws IOException, ClassNotFoundException {
        Index obj = null;

        try {
            FileInputStream file = new FileInputStream(name);
            try (ZipInputStream zis = new ZipInputStream(file)) {
                ZipEntry zen = zis.getNextEntry();

                if (!zen.getName().equals(Buffer.zipEntryName)) {
                    throw new IOException("Invalid block format");
                }

                try (ObjectInputStream ois = new ObjectInputStream(zis)) {
                    obj = (Index) ois.readObject();
                }
            }
        } catch (FileNotFoundException e) {
            obj = new Index();
        }

        if (obj != null) {
            obj.save(name);
        }

        return obj;
    }

    private transient String filename = null;

    private void save(String name) {
        filename = name;
    }

    public void saveAs(String name) throws IOException {
        FileOutputStream file = new FileOutputStream(name);
        try (ZipOutputStream zos = new ZipOutputStream(file)) {
            zos.putNextEntry(new ZipEntry(Buffer.zipEntryName));
            zos.setLevel(ZipOutputStream.DEFLATED);

            try (ObjectOutputStream oos = new ObjectOutputStream(zos)) {
                oos.writeObject(this);
                oos.flush();

                zos.closeEntry();
                zos.flush();
            }
        }
    }

    @Override
    public void close() throws IOException {
        saveAs(filename);
    }
}
