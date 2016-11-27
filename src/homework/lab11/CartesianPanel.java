package homework.lab11;

import java.awt.*;

class CartesianPanel extends Canvas {
    public static final int X_AXIS_FIRST_X_COORD  = 50;
    public static final int X_AXIS_SECOND_X_COORD = 600;
    public static final int X_AXIS_Y_COORD        = 600;

    public static final int Y_AXIS_FIRST_Y_COORD  = 50;
    public static final int Y_AXIS_SECOND_Y_COORD = 600;
    public static final int Y_AXIS_X_COORD        = 50;

    public static final int FIRST_LENGTH = 10;
    public static final int SECOND_LENGTH = 5;

    public static final int ORIGIN_COORD_LENGTH  = 6;

    public static final int AXIS_STRING_DISTANCE = 20;

    private Graphics2D g2D;

    CartesianPanel(Graphics g) {
        g2D = (Graphics2D) g;
    }

    @Override
    public void paint(Graphics g) {
        g2D.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        g2D.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);

        g2D.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGTH, X_AXIS_Y_COORD - SECOND_LENGTH,
                X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        g2D.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGTH, X_AXIS_Y_COORD + SECOND_LENGTH,
                X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);

        g2D.drawLine(Y_AXIS_X_COORD - SECOND_LENGTH, Y_AXIS_FIRST_Y_COORD + FIRST_LENGTH,
                    Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);
    }
}
