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

    private static final int ORIGIN_COORD_LENGTH = 6;
    private static final int AXIS_STRING_DISTANCE = 20;

    private List<Point2D.Double> points;

    {
        setBackground(Color.CYAN);
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

        //

        /*for (int i = 1; i < xCoordinateNumbers; i++) {
            g2D.drawLine(X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD - SECOND_LENGTH,
                    X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD + SECOND_LENGTH);
            g2D.drawString(Integer.toString(i),
                    X_AXIS_FIRST_X_COORD + i * xLength - 3, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }*/

        List<Point2D.Double> actualPoints = new LinkedList<>();

        /*double[] x = new double[points.size()];
        double[] y = new double[points.size()];*/

        for (int i = 0, j = -70; i < xCoordinateNumbers; i++, j += 10) {
            g2D.drawLine(X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD - SECOND_LENGTH,
                    X_AXIS_FIRST_X_COORD + i * xLength, X_AXIS_Y_COORD + SECOND_LENGTH);
            g2D.drawString(Integer.toString(j),
                    X_AXIS_FIRST_X_COORD + i * xLength - 3, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);

//            x[i - 1] = X_AXIS_FIRST_X_COORD + i * xLength;
        }

        /*for (int i = 1; i < yCoordinateNumbers; i++) {
            g2D.drawLine(Y_AXIS_X_COORD - SECOND_LENGTH, Y_AXIS_SECOND_Y_COORD - i * yLength,
                    Y_AXIS_X_COORD + SECOND_LENGTH, Y_AXIS_SECOND_Y_COORD - i * yLength);
            g2D.drawString(Integer.toString(i),
                    Y_AXIS_X_COORD - AXIS_STRING_DISTANCE, Y_AXIS_SECOND_Y_COORD - i * yLength);
        }*/

        for (int i = 0, j = 0; i < yCoordinateNumbers; i++, j += 5) {
            g2D.drawLine(Y_AXIS_X_CENTER_COORD - SECOND_LENGTH, Y_AXIS_SECOND_Y_COORD - i * yLength,
                    Y_AXIS_X_CENTER_COORD + SECOND_LENGTH, Y_AXIS_SECOND_Y_COORD - i * yLength);
            g2D.drawString(Integer.toString(j),
                    Y_AXIS_X_CENTER_COORD + AXIS_STRING_DISTANCE - 10, Y_AXIS_SECOND_Y_COORD - i * yLength + 5);

//            y[i - 1] = Y_AXIS_SECOND_Y_COORD - i * yLength;
        }

        g2D.translate(X_AXIS_FIRST_X_COORD, Y_AXIS_SECOND_Y_COORD);
        g2D.scale(1.0, -1.0);

        /*points.forEach(point -> {
            point.x *= xCoordinateNumbers;
            point.y *= yCoordinateNumbers;
        });*/

//        List<Point2D.Double> actualPoints = new LinkedList<>();
        for (Point2D.Double point : points) {
            actualPoints.add(new Point2D.Double(point.getX(), point.getY()));
        }

        /*for (int i = 0; i < points.size(); i++) {
            actualPoints.add(new Point2D.Double(x[i], y[i]));
        }*/

        for (int i1 = 1; i1 < actualPoints.size(); i1++) {
            actualPoints.get(i1).x += i1 * xLength;
            actualPoints.get(i1).y += i1 * yLength;
        }

        for (int i = 0; i < actualPoints.size() - 1; i++) {
            g2D.draw(new Line2D.Double(actualPoints.get(i), actualPoints.get(i + 1)));
        }
    }
}
