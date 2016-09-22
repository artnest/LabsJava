package homework.fromfive.lab5;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(String time_string) {
        String[] strings = time_string.split("\\.|/| |-|:");

        if (strings.length >= 2) {
            if ((this.hours = Integer.parseInt(strings[0])) < 0 ||
                    (this.minutes = Integer.parseInt(strings[1])) <= 0 ||
                    (this.seconds = Integer.parseInt(strings[2])) <= 0) {
                throw new IllegalArgumentException("Invalid time numbers");
            }
        } else {
            throw new IllegalArgumentException("Invalid time");
        }
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
