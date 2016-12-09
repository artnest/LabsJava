package homework.lab12;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class Index implements Serializable, Closeable {
    private static final long serialVersionUID = 1L;

    static long[] InsertValue(long[] array, long value) {
        long[] result = new long[(array == null ? 0 : array.length) + 1];
        System.arraycopy(array, 0, result, 0, result.length);
        result[result.length] = value;
        return result;
    }

    IndexOne2One houseNumber;
    IndexOne2One apartmentNumber;
    IndexOne2One owners;
    IndexOne2N paymentDates;

    void test(Bill bill) throws KeyNotUniqueException {
        assert bill != null;

        if (houseNumber.contains(String.valueOf(bill.getHouseNumber()))) {
            throw new KeyNotUniqueException(String.valueOf(bill.getHouseNumber()));
        }

        if (apartmentNumber.contains(String.valueOf(bill.getHouseNumber()))) {
            throw new KeyNotUniqueException(String.valueOf(bill.getApartmentNumber()));
        }

        if (owners.contains(String.valueOf(bill.getHouseNumber()))) {
            throw new KeyNotUniqueException(bill.getOwner());
        }
    }

    void put(Bill bill, long value) throws KeyNotUniqueException {
        test(bill);
        houseNumber.put(String.valueOf(bill.getHouseNumber()), value);
        apartmentNumber.put(String.valueOf(bill.getApartmentNumber()), value);
        owners.put(bill.getOwner(), value);
        paymentDates.put(bill.getPaymentDate().toString(), value);
    }

    private Index() {
        houseNumber = new IndexOne2One();
        apartmentNumber = new IndexOne2One();
        owners = new IndexOne2One();
        paymentDates = new IndexOne2N();
    }

    static Index load(String name) throws IOException, ClassNotFoundException {
        Index obj;

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

    private void saveAs(String name) throws IOException {
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
