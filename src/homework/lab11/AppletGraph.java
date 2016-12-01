package homework.lab11;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class AppletGraph extends Applet {
    static final Dimension dimension = new Dimension(650, 650);
    private List<Point2D> points = new LinkedList<>();

    @Override
    public void init() {
        setSize(dimension);
        setLayout(null);
        setBackground(new Color(215, 215, 215));

        String param = "param_";
        String data;
        String[] dataXY;

        boolean validArgumentsFlag = true;
        int i = 0;
        while ((data = getParameter(param + i++)) != null) {
            dataXY = data.split(" ");
            double dataX = Double.parseDouble(dataXY[1].replace(',', '.'));
            double dataY = Double.parseDouble(dataXY[0].replace(',', '.'));

            if ((dataX >= -70 && dataX <= 70) &&
                    (dataY > 0 && dataY <= 100)) {
                points.add(new Point2D.Double(dataX, dataY));
            } else {
                points.clear();
                validArgumentsFlag = false;
                break;
            }
        }

        /*points.add(new Point2D.Double(-5.2, 40.2));
        points.add(new Point2D.Double(-5.1, 45.8));
        points.add(new Point2D.Double(-4.0, 62.5));
        points.add(new Point2D.Double(0, 77.8));
        points.add(new Point2D.Double(1.2, 89.8));
        points.add(new Point2D.Double(3, 90.1));*/
        // test

        CartesianFrame cartesianFrame;
        points.sort((o1, o2) -> new Double(o1.getX()).compareTo(o2.getX()));
        if (validArgumentsFlag) {
            cartesianFrame = new CartesianFrame(points);
        } else {
            cartesianFrame = new CartesianFrame();
        }
        add(cartesianFrame);
    }
}
