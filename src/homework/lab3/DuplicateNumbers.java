package homework.lab3;

import java.util.Scanner;

public class DuplicateNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            StringBuffer str = new StringBuffer(input.nextLine());

            for (int i = 0; i < str.length() - 1; i++) {
                int count = 1;

                while ((i + 1) != str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    str.deleteCharAt(i + 1);
                }

                if (count > 1) {
                    if (i != str.length()) {
                        str.insert(i + 1, count);
                    }
                    else {
                        str.append(count);
                    }
                }
            }

            System.out.println(str);
        }

        input.close();
    }
}
