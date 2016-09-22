package homework.fromfive.lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите размерность матрицы: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();
        if (n <= 0) {
            System.out.println("Размерность матрицы не может быть отрицательной!");
            System.exit(1);
        }

        System.out.println("Исходная матрица:");
        double[][] a = new double[n][n];
        double[] averages = new double[n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = Math.random() * (-2*n) + n;
                averages[i] += a[i][j];
                System.out.printf("%10.4f ", a[i][j]);
            }
            averages[i] /= a[i].length;

            System.out.println();
        }

        System.out.println("Результат:");
        double[][] b = a.clone();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                b[i][j] -= averages[i];
                System.out.printf("%10.4f ", b[i][j]);
            }

            System.out.println();
        }

        System.exit(0);
    }
}
