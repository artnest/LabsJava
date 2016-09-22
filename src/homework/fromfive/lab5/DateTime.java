package homework.fromfive.lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        String[] el;
        Date date;
        Time time;

        System.out.print("Введите дату и время через пробел: ");
        while (!((s = reader.readLine()).isEmpty())) {
            try {
                if ((el = s.split(" ")).length != 2) {
                    throw new IOException("Input error");
                }

                date = new Date(el[0]);
                time = new Time(el[1]);

                System.out.println(date + ": " + time);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}