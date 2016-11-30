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

        int i = 0;
        while ((data = getParameter(param + i++)) != null) {
            dataXY = data.split(" ");
            points.add(new Point2D.Double(Double.parseDouble(dataXY[1].replace(',', '.')),
                    Double.parseDouble(dataXY[0].replace(',', '.'))));
        }

        CartesianFrame cartesianFrame = new CartesianFrame(points);
        add(cartesianFrame);
    }
}
