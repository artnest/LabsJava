package homework.lab9;

import java.io.Serializable;
import java.util.Scanner;

public class Bill implements Serializable {
    private String numberHouse; // TODO make int, add check IntParse for exception
    private String numberApartment; // TODO make int, add check IntParse for exception
    private String address;
    private String owner; // TODO check on parsing to correspond 3 params(take from previous works)
    private String paymentDate; // TODO make use of Date class
    private String paymentSum; // TODO make int, add check IntParse for exception
    private String penaltyPercent; // TODO check on parsing to consist of a number and a penaltyPercent sign
    private String daysExpired; // TODO make int, add check IntParse for exception

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

        bill.paymentDate = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.paymentSum = fin.nextLine();
        if (!fin.hasNextLine()) {
            return null;
        }

        bill.penaltyPercent = fin.nextLine();
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
                paymentDate + " | " +
                paymentSum + " | " +
                penaltyPercent + " | " +
                daysExpired;
    }
}
