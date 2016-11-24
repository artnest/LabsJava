package homework.lab11;

import java.applet.Applet;
import java.awt.*;

public class DrawingImage extends Canvas {
    private Applet applet;
    private Image image;
    private Dimension dimension;

    public DrawingImage(Applet applet, Image image) {
        this.applet = applet;
        this.image = image;
        this.dimension = new Dimension(20,20);

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
    }
}
