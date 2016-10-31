package homework.lab9;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PubicServicesAccount implements Serializable {
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

    public static PubicServicesAccount read(Scanner fin) {
        PubicServicesAccount pubicServicesAccount = new PubicServicesAccount();

        try {
            pubicServicesAccount.numberHouse = Integer.parseInt(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            pubicServicesAccount.numberApartment = Integer.parseInt(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            pubicServicesAccount.address = fin.nextLine();
            if (!fin.hasNextLine()) {
                return null;
            }

            String s = fin.nextLine();
            String[] strings = s.split(" ");
            StringBuilder sB = new StringBuilder();
            if (strings.length == 3) {
                pubicServicesAccount.owner = sB.append(strings[0]).append(" ")
                                .append(strings[1]).append(" ")
                                .append(strings[2]).toString();
            } else {
                throw new IllegalArgumentException("Invalid full name data");
            }
            if (!fin.hasNextLine()) {
                return null;
            }

//            pubicServicesAccount.paymentDate = new SimpleDateFormat("dd/MM/yy").parse(fin.nextLine());
            pubicServicesAccount.paymentDate = LocalDate.parse(fin.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (!fin.hasNextLine()) {
                return null;
            }

            pubicServicesAccount.paymentSum = Double.parseDouble(fin.nextLine());
            if (!fin.hasNextLine()) {
                return null;
            }

            strings = fin.nextLine().split("%");
            if (strings.length == 1) {
                pubicServicesAccount.penaltyPercent = strings[0];
            } else {
                throw new IllegalArgumentException("Invalid penalty data");
            }
            if (!fin.hasNextLine()) {
                return null;
            }

            pubicServicesAccount.daysExpired = Integer.parseInt(fin.nextLine());
        } catch (NumberFormatException e/* | ParseException e*/) {
            System.out.println(e.getMessage());
        }

        return pubicServicesAccount;
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
