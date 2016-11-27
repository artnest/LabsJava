package homework.lab11;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class AppletGraph extends Applet {
    private static final Dimension dimension = new Dimension(450, 450);
    private Canvas canvas;
    private List<Point2D.Double> points = new LinkedList<>();

    Color getHtmlColor(String stringRGB, Color defaultColor) {
        if (stringRGB != null && stringRGB.charAt(0) == '#') {
            try {
                return new Color(Integer.parseInt(stringRGB.substring(1), 16));
            } catch (NumberFormatException e) {
                return defaultColor;
            }
        }

        return defaultColor;
    }

    @Override
    public void init() {
        setSize(dimension);
        setLayout(null);

        Color backgroundColor = getHtmlColor(getParameter("AppletBackgroundColor"),
                                            new Color(215, 215, 215));
        setBackground(backgroundColor);

        Color drawColor = getHtmlColor(getParameter("DrawColor"), Color.BLACK);

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
        while ((data = getParameter(param + i++)) != null) {
            dataXY = data.split(" ");
            points.add(new Point2D.Double(Double.parseDouble(dataXY[0]), Double.parseDouble(dataXY[1])));
        }

        canvas = new DrawPlotGraph(drawColor, points);
        add(canvas);
    }

    void start() {
        startThread();
    }

    void stop() {
        stopThread();
    }

    void destroy() {
        stopThread();
    }

    private AppletThread thread = null;

    private void createThread() {
        if (thread == null) {
            thread = new AppletThread(this);
        }
    }

    private void startThread() {
        createThread();
        thread.start();
    }

    private void stopThread() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
    }
}
