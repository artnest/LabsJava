package homework.lab11;

import java.awt.*;

class CartesianFrame extends Canvas {
    private CartesianPanel panel;

    public CartesianFrame() {
        this.panel = new CartesianPanel(this);
    }
}
