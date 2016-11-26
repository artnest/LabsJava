package homework.lab11;

import java.applet.Applet;
import java.awt.*;

public class DrawImage extends Canvas {
    private Applet applet;
    private Dimension dimension;

    DrawImage(Applet applet, Image image) {
        this.applet = applet;
        this.dimension = new Dimension(10,10);

        setBackground(null);
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
        g.drawImage(image, 0, 0, applet);
        g.draw
    }
}
