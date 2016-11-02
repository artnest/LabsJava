package homework.lab9;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PublicServicesAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numberHouse;
    static final String P_numberHouse = "House number";
    private int numberApartment;
    static final String P_numberApartment = "Apartment number";
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

    public int getNumberHouse() {
        return numberHouse;
    }

    public int getNumberApartment() {
        return numberApartment;
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

    static Boolean nextRead(Scanner fin, PrintStream out) {
        return nextRead(P_numberHouse, fin, out);
    }

    private static Boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static PublicServicesAccount read(Scanner fin) {
        PublicServicesAccount publicServicesAccount = new PublicServicesAccount();

        try {
            publicServicesAccount.numberHouse = Integer.parseInt(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            publicServicesAccount.numberApartment = Integer.parseInt(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            publicServicesAccount.address = fin.nextLine();
            if (!fin.hasNextLine()) {
                return null;
            }

            String s = fin.nextLine();
            String[] strings = s.split(" ");
            StringBuilder sB = new StringBuilder();
            if (strings.length == 3) {
                publicServicesAccount.owner = sB.append(strings[0]).append(" ")
                                .append(strings[1]).append(" ")
                                .append(strings[2]).toString();
            } else {
                throw new IllegalArgumentException("Invalid full name data");
            }
            if (!fin.hasNextLine()) {
                return null;
            }

//            publicServicesAccount.paymentDate = new SimpleDateFormat("dd/MM/yy").parse(fin.nextLine());
            publicServicesAccount.paymentDate = LocalDate.parse(fin.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (!fin.hasNextLine()) {
                return null;
            }

            publicServicesAccount.paymentSum = Double.parseDouble(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            strings = fin.nextLine().split("%");
            if (strings.length == 1) {
                publicServicesAccount.penaltyPercent = strings[0];
            } else {
                throw new IllegalArgumentException("Invalid penalty data");
            }
            if (!fin.hasNextLine()) {
                return null;
            }

            publicServicesAccount.daysExpired = Integer.parseInt(fin.nextLine());
        } catch (NumberFormatException e/* | ParseException e*/) {
            System.out.println(e.getMessage());
        }

        return publicServicesAccount;
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
