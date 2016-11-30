package homework.lab11;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
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

    private List<Point2D> points;

    {
        setBackground(Color.WHITE);
        setMaximumSize(AppletGraph.dimension);
        setBounds(0, 0, AppletGraph.dimension.width, AppletGraph.dimension.height);
    }

    CartesianFrame() {
    }

    CartesianFrame(List<Point2D> points) {
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

        g2D.drawString("t, Celsius",
                    X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        g2D.drawString("Humidity, % (percent)",
                    Y_AXIS_X_CENTER_COORD + AXIS_STRING_DISTANCE - 10, Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
        /*g2D.drawString("(0, 0)",
                        X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE, Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);*/

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

        final int X_CENTER_NEW_COORD = (X_AXIS_SECOND_X_COORD - 2 * X_AXIS_FIRST_X_COORD - 1) / 2;
        final int Y_CENTER_NEW_COORD = 0;
        g2D.translate(X_CENTER_NEW_COORD, Y_CENTER_NEW_COORD);

        List<Point2D.Double> actualPoints = new LinkedList<>();
        for (Point2D point : points) {
            actualPoints.add(new Point2D.Double(point.getX(), point.getY()));
        }

        for (Point2D.Double point : actualPoints) {
            point.x = xLength * point.x / xCoordinateNumbers * 1.3;
            point.y = yLength * point.y / yCoordinateNumbers * 4.18;
        }

        g2D.setColor(Color.BLUE);
        g2D.setStroke(new BasicStroke(2.0f));

        Path2D path2D = new Path2D.Double();
        path2D.moveTo(actualPoints.get(0).getX(), actualPoints.get(0).getY());
        for (Point2D point : actualPoints) {
            path2D.lineTo(point.getX(), point.getY());
        }
        g2D.draw(path2D);

        g2D.setColor(Color.RED);
        g2D.setStroke(new BasicStroke(4.0f));

        for (Point2D point : actualPoints) {
            g2D.draw(new Line2D.Double(point, point));
        }
    }
}
