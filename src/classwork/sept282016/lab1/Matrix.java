package classwork.sept282016.lab1;

import java.util.Date;
import java.util.Random;

/**
 * Created by theme on 9/28/16.
 */
public class Matrix {
    static final int MAX_A = 10;
    int N = 0;
    int[][] a = null;

    public Matrix() {
        N = 0;
        a = null;
    }

    public Matrix(int n) {
        assert n > 0;
        init(n, MAX_A);
    }

    public Matrix(int n, int nm) {
        assert n > 0;
        assert nm > 0;
        init(n, nm);
    }

    private void init(int n, int m) {
        assert n > 0;
        assert m > 0;

        a = new int[n][n];
        Random r = new Random(new Date().getTime());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = r.nextInt(m);
            }
        }
    }

    public int norm_1() {
        assert N > 0;
        int norm = 0;

        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                temp += Math.abs(a[i][j]);
            }

            if (temp > norm) {
                norm = temp;
            }
        }

        return norm;
    }

    public int norm_2() {
        assert N > 0;
        int norm = 0;

        for (int j = 0; j < N; j++) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                temp += Math.abs(a[i][j]);
            }

            if (temp > norm) {
                norm = temp;
            }
        }

        return norm;
    }

    public void print() {
        assert N > 0: "Assertion failed: N > 0";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }
    }
}
