package homework.lab11;

import java.awt.*;

public class DrawGraph extends Canvas {
    private Color color;
    private Dimension dimension = new Dimension(200, 200);

    public DrawGraph(Color drawColor) {
        super();
        color = drawColor;
        setMaximumSize(dimension);
        setBounds(0, 0, dimension.width, dimension.height);
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
        g.drawLine(-10, -10, 10, 10);
        g.drawLine(10, -10, -10, 10);
    }
}
