package classwork.sept282016.lab1;

/**
 * Created by theme on 9/28/16.
 */
public class Test {
    static final int NUM = 10;

    public static void main(String[] args) {
        Matrix[] array = new Matrix[NUM];

        for (int i = 0; i < NUM; i++) {
            System.out.println(i + 1);
            array[i] = new Matrix(2);
            array[i].print();
        }

        int min = Integer.MAX_VALUE;
        int k = -1;

        for (int i = 0; i < NUM; i++) {
            int norm = array[i].norm_2();
            if (norm < min) {
                min = norm;
                k = i + 1;
            }
        }
        System.out.println("Matrix #" + k + " has min norm_2: " + min);

        Matrix m = new Matrix();
        m.print();
    }
}
