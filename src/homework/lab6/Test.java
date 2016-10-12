package homework.lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        Triangle[] triangles = new EquilateralTriangle[10];

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < triangles.length - 1; i++) {
            triangles[i] = new EquilateralTriangle(random.nextDouble());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the value of a side of a new equilateral triangle: ");
        triangles[triangles.length - 1] = new EquilateralTriangle(reader.readLine());

        System.out.println("Unsorted array:");
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }

        System.out.println("Choose a field to sort the array by:\n" +
                "1. side a\n" +
                "2. side b\n" +
                "3. angle\n" +
                "4. area\n" +
                "5. perimetr");
        Arrays.sort(triangles, TriangleComparator.getComparator(Integer.parseInt(reader.readLine())));
        reader.close();

        System.out.println("Sorted array:");
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }
}
