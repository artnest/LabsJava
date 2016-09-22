package homework.lab2;

public class CoshSeries {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid number of arguments");
            System.exit(1);
        }

        double x = Double.parseDouble(args[0]);

        int k = Integer.parseInt(args[1]);
        if (k <= 1) {
            System.err.println("Invalid argument: " + k);
            System.exit(1);
        }

        double eps = 1 / Math.pow(10, k + 1);
        double result = 0;
        double step = 1;
        int n = 1;

        while (Math.abs(step) >= eps) {
            result += step;
            step = (step * x * x) / n / (n + 1);
            n += 2;
        }

        // 1 + x^2 / 2! + x^4 / 4! + ...

        String fmt = "%,." + k + "f\n";
        System.out.printf(fmt, result);
        System.out.printf(fmt, (Math.exp(x) + Math.exp(-x)) / 2);
        System.exit(0);
    }
}
