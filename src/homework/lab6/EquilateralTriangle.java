package homework.lab6;

/**
 * Created by artem on 04.10.2016.
 */
public class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double a) {
        super(a, a, Math.toRadians(60));
    }

    @Override
    protected double Area() {
        return getA() * getA() * getA();
    }

    @Override
    protected double Perimetr() {
        return 3 * getA();
    }
}
