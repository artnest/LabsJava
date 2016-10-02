package homework.lab5;

class Time {
    private int hours;
    private int minutes;
    private int seconds;

    Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    Time(Time time) {
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();
    }

    Time(String time_string) {
        String[] strings = time_string.split("\\.|/| |-|:");

        assert strings.length == 3: "Invalid time";
        if ((this.hours = Integer.parseInt(strings[0])) < 0 ||
                (this.hours = Integer.parseInt(strings[0])) > 24 ||
                (this.minutes = Integer.parseInt(strings[1])) < 0 ||
                (this.minutes = Integer.parseInt(strings[1])) > 60 ||
                (this.seconds = Integer.parseInt(strings[2])) < 0 ||
                (this.seconds = Integer.parseInt(strings[2])) > 60) {
            throw new IllegalArgumentException("Invalid time numbers");
        }
    }

    static Time getCurrentTime() {
        long millis = System.currentTimeMillis();

        Time currentTime = new Time();
        currentTime.seconds = (int) ((millis / 1000) % 60);
        currentTime.minutes = (int) ((millis / (1000 * 60)) % 60);
        currentTime.hours = (int) ((millis / 1000 * 60 * 60) % 24);

        return currentTime;
    }

    String getTimeType() {
        if (this.hours <= 12) {
            return "a.m.";
        } else {
            return "p.m.";
        }
    }

    int getHours() {
        return hours;
    }

    void setHours(int hours) {
        this.hours = hours;
    }

    int getMinutes() {
        return minutes;
    }

    void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    int getSeconds() {
        return seconds;
    }

    void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return hours == time.hours && minutes == time.minutes && seconds == time.seconds;

    }

    @Override
    public int hashCode() {
        int result = hours;
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        return result;
    }
}
