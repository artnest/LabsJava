package homework.lab6;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by artem on 04.10.2016.
 */
public class Test {
    public static void main(String[] args) {
        Triangle[] triangles = new EquilateralTriangle[10];

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < triangles.length; i++) {
            triangles[i] = new EquilateralTriangle(random.nextDouble());
        }

        System.out.println("Unsorted array:");
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }

        Arrays.sort(triangles, new TriangleFirstSideComparator());

        System.out.println("Sorted array:");
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }
}
