package homework.lab8;

import java.io.Serializable;
import java.util.Scanner;

public class Bill implements Serializable {
    private String numberHouse;
    private String numberApartment;
    private String address;
    private String owner;
    private String date;
    private String sum;
    private String percent;
    private String daysExpired;

    public static Bill read(Scanner fin) {
        Bill bill = new Bill();

        bill.numberHouse = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.numberApartment = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.address = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.owner = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.date = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.sum = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.percent = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.daysExpired = fin.nextLine();

        return bill;
    }

    @Override
    public String toString() {
        return numberHouse + " | " +
                numberApartment + " | " +
                address + " | " +
                owner + " | " +
                date + " | " +
                sum + " | " +
                percent + " | " +
                daysExpired;
    }
}
