package classwork.sept072016.lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymbolsInput {
    public static void main(String[] args) throws IOException {
        String str = "";
        String envname = "";
        boolean inword = false;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int c;
        while ((c = reader.read()) != -1) {
            if (c == '\r') {
                continue;
            }
            if (c == '\n') {
                System.out.println(str);
                str = "";
                continue;
            }

            if (c == '%') {
                if (inword) {
                    String s = System.getenv(envname);
                    if (s != null) {
                        str += s;
                        inword = false;
                    }
                } else {
                    inword = true;
                    envname = "";
                }
            } else {
                if (inword) {
                    envname += ((char) c);
                } else {
                    str += ((char) c);
                }
            }
        }

        if (inword) {
            str += '%' + envname;
        }
        if (str.length() != 0) {
            System.out.println(str);
        }

        reader.close();
    }
}
