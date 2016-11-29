package homework.lab11;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

class CartesianFrame extends Canvas {
    private static final int X_AXIS_FIRST_X_COORD = 50;
    private static final int X_AXIS_SECOND_X_COORD = 600;
    private static final int X_AXIS_Y_COORD = 600;

    private static final int Y_AXIS_FIRST_Y_COORD = 50;
    private static final int Y_AXIS_SECOND_Y_COORD = 600;
    private static final int Y_AXIS_X_COORD = 50;

    private static final int FIRST_LENGTH = 10;
    private static final int SECOND_LENGTH = 5;

//    private static final int ORIGIN_COORD_LENGTH = 6;
    private static final int AXIS_STRING_DISTANCE = 20;

    private List<Point2D.Double> points;

    {
        setBackground(Color.WHITE);
        setMaximumSize(AppletGraph.dimension);
        setBounds(0, 0, AppletGraph.dimension.width, AppletGraph.dimension.height);
    }

    CartesianFrame() {
    }

    CartesianFrame(List<Point2D.Double> points) {
        this.points = points;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        int xCoordinateNumbers = 15;
        int yCoordinateNumbers = 21;
        int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD) / xCoordinateNumbers;
        int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD) / yCoordinateNumbers;

        final int Y_AXIS_X_CENTER_COORD = Y_AXIS_X_COORD + 7 * xLength;

        g2D.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
//        g2D.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);
        g2D.drawLine(Y_AXIS_X_CENTER_COORD, Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_CENTER_COORD, Y_AXIS_SECOND_Y_COORD);

        g2D.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGTH, X_AXIS_Y_COORD - SECOND_LENGTH,
                    X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        g2D.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGTH, X_AXIS_Y_COORD + SECOND_LENGTH,
                    X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);

        g2D.drawLine(Y_AXIS_X_CENTER_COORD - SECOND_LENGTH, Y_AXIS_FIRST_Y_COORD + FIRST_LENGTH,
                    Y_AXIS_X_CENTER_COORD, Y_AXIS_FIRST_Y_COORD);
        g2D.drawLine(Y_AXIS_X_CENTER_COORD + SECOND_LENGTH, Y_AXIS_FIRST_Y_COORD + FIRST_LENGTH,
                    Y_AXIS_X_CENTER_COORD, Y_AXIS_FIRST_Y_COORD);

        /*g2D.fillOval(X_AXIS_FIRST_X_COORD - ORIGIN_COORD_LENGTH / 2,
                       Y_AXIS_SECOND_Y_COORD - ORIGIN_COORD_LENGTH / 2,
                       ORIGIN_COORD_LENGTH, ORIGIN_COORD_LENGTH);*/

        g2D.drawString("X",
                    X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        g2D.drawString("Y",
                    Y_AXIS_X_CENTER_COORD + AXIS_STRING_DISTANCE - 10, Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
        /*g2D.drawString("(0, 0)",
                        X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE, Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);*/

        List<Point2D.Double> actualPoints = new LinkedList<>();

        int i;
        int j;

        for (i = 0, j = -70; i < xCoordinateNumbers / 2; i++, j += 10) {
            g2D.drawLine(X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD - SECOND_LENGTH,
                    X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD + SECOND_LENGTH);
            g2D.drawString(Integer.toString(j),
                    X_AXIS_FIRST_X_COORD + i * xLength - 3, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }

        g2D.drawLine(X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD - SECOND_LENGTH,
                X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD + SECOND_LENGTH);
        g2D.drawString("(0, 0)",
                X_AXIS_FIRST_X_COORD + i * xLength - 12, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);

        i++;
        j += 10;
        for (; i < xCoordinateNumbers; i++, j += 10) {
            g2D.drawLine(X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD - SECOND_LENGTH,
                    X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD + SECOND_LENGTH);
            g2D.drawString(Integer.toString(j),
                    X_AXIS_FIRST_X_COORD + i * xLength - 3, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }

        for (i = 1, j = 5; i < yCoordinateNumbers; i++, j += 5) {
            g2D.drawLine(Y_AXIS_X_CENTER_COORD - SECOND_LENGTH, Y_AXIS_SECOND_Y_COORD - i * yLength,
                    Y_AXIS_X_CENTER_COORD + SECOND_LENGTH, Y_AXIS_SECOND_Y_COORD - i * yLength);
            g2D.drawString(Integer.toString(j),
                    Y_AXIS_X_CENTER_COORD + AXIS_STRING_DISTANCE - 10, Y_AXIS_SECOND_Y_COORD - i * yLength + 5);
        }

        g2D.translate(X_AXIS_FIRST_X_COORD, Y_AXIS_SECOND_Y_COORD);
        g2D.scale(1.0, -1.0);

//        List<Point2D.Double> actualPoints = new LinkedList<>();
        for (Point2D.Double point : points) {
            actualPoints.add(new Point2D.Double(point.getX(), point.getY()));
        }

        final int X_CENTER_NEW_COORD = (X_AXIS_SECOND_X_COORD - 2 * X_AXIS_FIRST_X_COORD - 1) / 2;
        final int Y_CENTER_NEW_COORD = 0;

        g2D.translate(X_CENTER_NEW_COORD, Y_CENTER_NEW_COORD);

        for (int i1 = 0; i1 < actualPoints.size(); i1++) {
//            actualPoints.get(i1).x = X_CENTER_NEW_COORD + xLength * actualPoints.get(i1).x;
            actualPoints.get(i1).x = xLength * actualPoints.get(i1).x / xCoordinateNumbers;
//            actualPoints.get(i1).y = Y_CENTER_NEW_COORD + yLength * actualPoints.get(i1).y;
            actualPoints.get(i1).y = yLength * actualPoints.get(i1).y / yCoordinateNumbers * 4.2;
        }

        g.setColor(Color.MAGENTA);

        for (i = 0; i < actualPoints.size() - 1; i++) {
            g2D.draw(new Line2D.Double(actualPoints.get(i), actualPoints.get(i + 1)));
        }
    }
}
