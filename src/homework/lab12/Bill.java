package homework.lab12;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bill implements Serializable {
    private int numberHouse;
    private int numberApartment;
    private String address;
    private String owner;
    //    private Date paymentDate;
    private LocalDate paymentDate;
    private double paymentSum;
    private String penaltyPercent;
    private int daysExpired;

    public static Bill read(Scanner fin) {
        Bill bill = new Bill();

        try {
            bill.numberHouse = Integer.parseInt(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            bill.numberApartment = Integer.parseInt(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            bill.address = fin.nextLine();
            if (!fin.hasNextLine()) {
                return null;
            }

            String s = fin.nextLine();
            String[] strings = s.split(" ");
            StringBuilder sB = new StringBuilder();
            if (strings.length == 3) {
                bill.owner = sB.append(strings[0]).append(" ")
                        .append(strings[1]).append(" ")
                        .append(strings[2]).toString();
            } else {
                throw new IllegalArgumentException("Invalid full name data");
            }
            if (!fin.hasNextLine()) {
                return null;
            }

//            bill.paymentDate = new SimpleDateFormat("dd/MM/yy").parse(fin.nextLine());
            bill.paymentDate = LocalDate.parse(fin.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (!fin.hasNextLine()) {
                return null;
            }

            bill.paymentSum = Double.parseDouble(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            strings = fin.nextLine().split("%");
            if (strings.length == 1) {
                bill.penaltyPercent = strings[0];
            } else {
                throw new IllegalArgumentException("Invalid penalty data");
            }
            if (!fin.hasNextLine()) {
                return null;
            }

            bill.daysExpired = Integer.parseInt(fin.nextLine());
        } catch (NumberFormatException e/* | ParseException e*/) {
            System.out.println(e.getMessage());
        }

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
