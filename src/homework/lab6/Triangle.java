package homework.lab6;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by artem on 04.10.2016.
 */
public abstract class Triangle implements Comparable<Triangle>, Iterable<Double> {
    private double a;
    private double b;
    private double angle;

    private double area;
    private double perimetr;

    public Triangle(String s) {
        assert !s.isEmpty();

        String[] strings = s.split(" ");

        assert strings.length == 3: "Not enough parameters";
        if ((this.a = Double.parseDouble(strings[0])) <= 0 ||
                (this.b = Double.parseDouble(strings[1])) <= 0 ||
                (this.angle = Double.parseDouble(strings[2])) <= 0) {
            throw new IllegalArgumentException("Invalid parameters");
        }
    }

    public Triangle(double a, double b, double angle) {
        assert a != 0 && b != 0 && angle != 0;

        this.a = a;
        this.b = b;
        this.angle = Math.toRadians(angle);

        area = Area();
        perimetr = Perimetr();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        assert a != 0;
        this.a = a;
    }

    public boolean hasA() {
        return a != 0;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        assert b != 0;
        this.b = b;
    }

    public boolean hasB() {
        return b != 0;
    }

    public double getAngle() {
        return Math.toDegrees(angle);
    }

    public void setAngle(double angle) {
        assert angle != 0;
        this.angle = Math.toRadians(angle);
    }

    public boolean hasAngle() {
        return angle != 0;
    }

    protected double Area() {
        return a * b * Math.sin(angle) / 2;
    }

    protected double Perimetr() {
        return a + b + Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(angle));
    }

    public double getArea() {
        return area;
    }

    public boolean hasArea() {
        return Area() != 0;
    }

    public double getPerimetr() {
        return perimetr;
    }

    public boolean hasPerimetr() {
        return perimetr != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.a, a) != 0) return false;
        if (Double.compare(triangle.b, b) != 0) return false;
        if (Double.compare(triangle.angle, angle) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(angle);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Triangle o) {
        int result;

        result = Double.compare(a, o.a);
        if (result != 0) {
            return result;
        }

        result = Double.compare(b, o.b);
        if (result != 0) {
            return result;
        }

        result = Double.compare(angle, o.angle);
        return result;
    }

    @Override
    public Iterator<Double> iterator() {
        return new TriangleIterator(this);
    }

    public Comparator<Triangle> comparator(int i) {
        switch (i) {
            case 1:
                return new TriangleFirstSideComparator();
            case 2:
                return new TriangleSecondSideComparator();
            case 3:
                return new TriangleAngleComparator();
            case 4:
                return new TriangleAreaComparator();
            case 5:
                return new TrianglePerimetrComparator();
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "First side: " + a + System.lineSeparator() +
                "Second side: " + b + System.lineSeparator() +
                "Angle (radians): " + angle + System.lineSeparator() +
                "Angle (degrees): " + Math.toDegrees(angle) + System.lineSeparator() +
                "Area: " + area + System.lineSeparator() +
                "Perimetr: " + perimetr + System.lineSeparator();
    }
}
