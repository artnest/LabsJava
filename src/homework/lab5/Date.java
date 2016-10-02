package homework.lab5;

enum months { январь, февраль, март, апрель, май, июнь, июль, август, сентябрь, октябрь, ноябрь, декабрь }

class Date {
    private int day;
    private int month;
    private int year;

    Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    Date(Date date) {
        this.day = date.getDay();
        this.month = date.getMonth();
        this.year = date.getYear();
    }

    Date(String date_string) {
        String[] strings = date_string.split("\\.|/| |-");

        assert strings.length == 3: "Invalid date";
        if ((this.day = Integer.parseInt(strings[0])) <= 0 ||
                (this.day = Integer.parseInt(strings[0])) > 31 ||
                (this.month = Integer.parseInt(strings[1])) <= 0 ||
                (this.month = Integer.parseInt(strings[1])) > 12 ||
                (this.year = Integer.parseInt(strings[2])) <= 0) {
            throw new IllegalArgumentException("Invalid date numbers");
        }
    }

    boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    int getDay() {
        return day;
    }

    void setDay(int day) {
        this.day = day;
    }

    int getMonth() {
        return month;
    }

    String getMonthName() {
        months[] monthsNames = months.values();
        return monthsNames[this.getMonth() - 1].name();
    }

    void setMonth(int month) {
        this.month = month;
    }

    int getYear() {
        return year;
    }

    void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d, %02d, %02d", day, month, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        return day == date.day && month == date.month && year == date.year;

    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }
}
