package homework.lab12;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    private int houseNumber;
    static final String P_houseNumber = "House number";
    private int apartmentNumber;
    static final String P_apartmentNumber = "Apartment number";
    private String address;
    static final String P_address = "Address";
    private String owner;
    static final String P_owner = "Owner";
//    private Date paymentDate;
    private LocalDate paymentDate;
    static final String P_paymentDate = "Payment date";
    private double paymentSum;
    static final String P_paymentSum = "Payment sum";
    private String penaltyPercent;
    static final String P_penaltyPercent = "Penalty percent";
    private int daysExpired;
    static final String P_daysExpired = "Days expired";

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getOwner() {
        return owner;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentSum() {
        return paymentSum;
    }

    public String getPenaltyPercent() {
        return penaltyPercent;
    }

    public int getDaysExpired() {
        return daysExpired;
    }

    /*private static GregorianCalendar curCalendar = new GregorianCalendar();
    static Boolean validYear(int year) {
        return year > 0 && year <= curCalendar.get(Calendar.YEAR);
    }*/

    public Bill(int houseNumber,
                int apartmentNumber,
                String address,
                String owner,
                LocalDate paymentDate,
                double paymentSum,
                String penaltyPercent,
                int daysExpired) {
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.address = address;
        this.owner = owner;
        this.paymentDate = paymentDate;
        this.paymentSum = paymentSum;
        this.penaltyPercent = penaltyPercent;
        this.daysExpired = daysExpired;
    }

    static Boolean nextRead(Scanner fin, PrintStream out) {
        return nextRead(P_houseNumber, fin, out);
    }

    private static Boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static Bill read(Scanner fin, PrintStream out) {
        Bill bill = null;

        bill.houseNumber = Integer.parseInt(fin.nextLine());
        if (!nextRead(P_apartmentNumber, fin, out)) {
            return null;
        }

        bill.apartmentNumber = Integer.parseInt(fin.nextLine());
        if (!nextRead(P_address, fin, out)) {
            return null;
        }

        bill.address = fin.nextLine();
        if (!nextRead(P_owner, fin, out)) {
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
        if (!nextRead(P_paymentDate, fin, out)) {
            return null;
        }

//            bill.paymentDate = new SimpleDateFormat("dd/MM/yy").parse(fin.nextLine());
        bill.paymentDate = LocalDate.parse(fin.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (!nextRead(P_paymentSum, fin, out)) {
            return null;
        }

        bill.paymentSum = Double.parseDouble(fin.nextLine());
        if (!nextRead(P_penaltyPercent, fin, out)) {
            return null;
        }

        strings = fin.nextLine().split("%");
        if (strings.length == 1) {
            bill.penaltyPercent = strings[0];
        } else {
            throw new IllegalArgumentException("Invalid penalty data");
        }
        if (!nextRead(P_daysExpired, fin, out)) {
            return null;
        }

        bill.daysExpired = Integer.parseInt(fin.nextLine());

        return bill;
    }

    public static final String areaDel = "\n";

    @Override
    public String toString() {
        return houseNumber + areaDel +
                apartmentNumber + areaDel +
                address + areaDel +
                owner + areaDel +
                paymentDate + areaDel +
                paymentSum + areaDel +
                penaltyPercent + areaDel +
                daysExpired;
    }
}
