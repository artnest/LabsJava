package homework.lab12;

import java.io.Serializable;
import java.time.LocalDate;

class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    private int houseNumber;
    private int apartmentNumber;
    private String address;
    private String owner;
    private LocalDate paymentDate;
    private double paymentSum;
    private String penaltyPercent;
    private int daysExpired;

    int getHouseNumber() {
        return houseNumber;
    }

    int getApartmentNumber() {
        return apartmentNumber;
    }

    String getAddress() {
        return address;
    }

    String getOwner() {
        return owner;
    }

    LocalDate getPaymentDate() {
        return paymentDate;
    }

    double getPaymentSum() {
        return paymentSum;
    }

    String getPenaltyPercent() {
        return penaltyPercent;
    }

    int getDaysExpired() {
        return daysExpired;
    }

    Bill(int houseNumber,
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

    private static final String areaDel = "\n";

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
