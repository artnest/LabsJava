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

        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // while ((data = reader.readLine()) != null) {
        //     data = getParameter(param + i++));
        //     dataXY = data.split(" ");
        //     ...
        // }

        int i = 0;
        /*while ((data = getParameter(param + i++)) != null) {
            dataXY = data.split(" ");
            points.add(new Point2D.Double(Double.parseDouble(dataXY[0]), Double.parseDouble(dataXY[1])));
        }*/

        points.add(new Point2D.Double(-5.2, 40.2));
        points.add(new Point2D.Double(-5.1, 45.8));
        points.add(new Point2D.Double(-4.0, 62.5));
        points.add(new Point2D.Double(0, 77.8));
        points.add(new Point2D.Double(1.2, 89.8));
        points.add(new Point2D.Double(3, 90.1));

        CartesianFrame cartesianFrame = new CartesianFrame(points);
        add(cartesianFrame);
    }
}
