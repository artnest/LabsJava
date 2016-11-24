package homework.lab11;

import java.awt.*;

public class Drawing extends Canvas {
    private Color color;
    private Dimension dimension = new Dimension(20, 20);

    public Drawing(Color foregroundColor, Color backgroundColor) {
        super();
        color = foregroundColor;
        setBackground(backgroundColor);
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
