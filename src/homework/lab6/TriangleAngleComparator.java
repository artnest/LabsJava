package homework.lab6;

import java.util.Comparator;

/**
 * Created by artem on 05.10.2016.
 */
class TriangleAngleComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Double.compare(o1.getAngle(), o2.getAngle());
    }
}
