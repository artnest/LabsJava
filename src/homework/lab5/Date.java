package homework.lab5;

class Date {
    private int day;
    private int month;
    private int year;

    Date(String date_string) {
        String[] strings = date_string.split("\\.|/| |-");

        if (strings.length == 3) {
            if ((this.day = Integer.parseInt(strings[0])) <= 0 ||
                    (this.month = Integer.parseInt(strings[1])) <= 0 ||
                    (this.year = Integer.parseInt(strings[2])) <= 0) {
                throw new IllegalArgumentException("Invalid date numbers");
            }
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    @Override
    public String toString() {
        return day + ", " + month + ", " + year;
    }
}
