package homework.lab11;

import java.applet.Applet;
import java.awt.*;
import java.util.LinkedList;

public class AppletMain extends Applet {
    private static final Dimension dimension = new Dimension(450, 450);
    private Canvas canvas;
    private LinkedList<Canvas> points = new LinkedList<>();

    public Color getHtmlColor(String stringRGB, Color defaultColor) {
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

        canvas = new DrawGraph(drawColor);

        String data = "param_";
        int i = 0;
        while (getParameter(data + i++) != null) {
            Canvas canvas = new DrawImage(this);
            points.add(canvas);
            add(canvas);
        }
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
