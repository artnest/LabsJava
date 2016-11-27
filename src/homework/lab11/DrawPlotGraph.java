package homework.lab11;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;

public class DrawPlotGraph extends Canvas {
    private Color color;
    private Dimension dimension = new Dimension(300, 300);
    private List<Point2D.Double> series;

    DrawPlotGraph(Color drawColor, List<Point2D.Double> points) {
        color = drawColor;
        setMaximumSize(dimension);
//        setBounds(0, 0, dimension.width, dimension.height);
        series = points;
    }

    @Override
    public Dimension getMinimumSize() {
        return dimension;
    }

    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    @Override
    public void paint(Graphics g) {
        prepareDraw(g);
        draw(g);
    }

    private void prepareDraw(Graphics g) {
        g.translate(10, 10);
        g.setColor(color);
    }

    private void draw(Graphics g) {
        Graphics2D g2D = ((Graphics2D) g);
        g2D.drawLine(-10, -10, 10, 10); // OX // TODO change the coordinates
        g2D.drawLine(10, -10, -10, 10); // OY // TODO change the coordinates

        for (int i = 0; i < series.size() - 1; i++) {
            /*g2D.draw(new Line2D.Double(series.get(i).getX(), series.get(i).getY(), series.get(i + 1)
                    .getX(), series.get(i + 1)
                    .getY()));*/
            g2D.draw(new Line2D.Double(series.get(i), series.get(i + 1)));
        }
    }
}
