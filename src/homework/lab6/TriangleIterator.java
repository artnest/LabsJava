package homework.lab6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by artem on 04.10.2016.
 */
public class TriangleIterator implements Iterator<Double> {
    private Triangle triangle;
    private int index = -1;

    public TriangleIterator(Triangle triangle) {
        this.triangle = triangle;
    }

    @Override
    public boolean hasNext() {
        switch (index) {
            case -1:
                return triangle.hasA() ||
                        triangle.hasB() ||
                        triangle.hasAngle() ||
                        triangle.hasArea() ||
                        triangle.hasPerimetr();
            case 0:
                return  triangle.hasB() ||
                        triangle.hasAngle() ||
                        triangle.hasArea() ||
                        triangle.hasPerimetr();
            case 1:
                return triangle.hasAngle() ||
                        triangle.hasArea() ||
                        triangle.hasPerimetr();
            case 2:
                return triangle.hasArea() ||
                        triangle.hasPerimetr();
            case 3:
                return triangle.hasPerimetr();
            default:
                return false;
        }
    }

    @Override
    public Double next() {
        switch (index) {
            case -1:
                if (triangle.hasA()) {
                    index = 0;
                    return triangle.getA();
                }
                if (triangle.hasB()) {
                    index = 1;
                    return triangle.getB();
                }
                if (triangle.hasAngle()) {
                    index = 2;
                    return triangle.getAngle();
                }
                if (triangle.hasArea()) {
                    index = 3;
                    return triangle.getArea();
                }
                if (triangle.hasPerimetr()) {
                    index = 4;
                    return triangle.getPerimetr();
                }
                break;
            case 0:
                if (triangle.hasB()) {
                    index = 1;
                    return triangle.getB();
                }
                if (triangle.hasAngle()) {
                    index = 2;
                    return triangle.getAngle();
                }
                if (triangle.hasArea()) {
                    index = 3;
                    return triangle.getArea();
                }
                if (triangle.hasPerimetr()) {
                    index = 4;
                    return triangle.getPerimetr();
                }
                break;
            case 1:
                if (triangle.hasAngle()) {
                    index = 2;
                    return triangle.getAngle();
                }
                if (triangle.hasArea()) {
                    index = 3;
                    return triangle.getArea();
                }
                if (triangle.hasPerimetr()) {
                    index = 4;
                    return triangle.getPerimetr();
                }
                break;
            case 2:
                if (triangle.hasArea()) {
                    index = 3;
                    return triangle.getArea();
                }
                if (triangle.hasPerimetr()) {
                    index = 4;
                    return triangle.getPerimetr();
                }
                break;
            case 3:
                if (triangle.hasPerimetr()) {
                    index = 4;
                    return triangle.getPerimetr();
                }
                break;
        }
        throw new NoSuchElementException();
    }
}
