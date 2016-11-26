package homework.lab11;

import java.applet.Applet;
import java.awt.*;

public class AppletGraph extends Applet {
    private static final int CX = 400;
    private static final int CY = 400;

    private Canvas canvas;
    private Canvas canvasStars[] = new Canvas[15];

    public Color getHtmlColor(String strRGB, Color color) {
        if (strRGB != null && strRGB.charAt(0) == '#') {
            try {
                return new Color(Integer.parseInt(strRGB.substring(1), 16));
            } catch (NumberFormatException e) {
                return color;
            }
        }

        return color;
    }

    @Override
    public void init() {
        setSize(CX, CY);
        setLayout(null);

        Color color = getHtmlColor(getParameter("AppBackgroundColor"), new Color(90, 90, 160));
        setBackground(color);

        Color colorx = getHtmlColor(getParameter("DrawBackgroundColor"), new Color(64, 64, 64));
        color = getHtmlColor(getParameter("DrawColor"), Color.WHITE);

        canvas = new DrawGraph(color, colorx);
        String s = getParameter("DrawImage");
        Image image = getImage(getCodeBase(), s == null ? "star.gif" : s);

        for (Canvas canvasStar : canvasStars) {
            canvasStar = new DrawImage(this, image);
            add(canvasStar);
        }
    }

    @Override
    public void start() {
        startThread();
    }

    @Override
    public void stop() {
        stopThread();
    }

    @Override
    public void destroy() {
        stopThread();
    }

    private AppletThread appletThread = null;

    private void createThread() {
        if (appletThread == null) {
            appletThread = new AppletThread(this);
        }
    }

    private void startThread() {
        createThread();
        appletThread.start();
    }

    private void stopThread() {
        if (appletThread != null) {
            appletThread.interrupt();
            appletThread = null;
        }
    }
}
