package homework.lab11;

import java.applet.Applet;
import java.awt.*;

public class AppletSinFunction extends Applet {
    @Override
    public void paint(Graphics g) {
        int CYCLE = 4;
        int MAX = 1000;
        int WEIGHT = 100;
        int x1 = 0;
        int x2 = 0;

        g.setColor(Color.red);//color for axes

        g.drawLine(0, 150, 700, 150);//x-axis
        g.drawLine(240, 0, 240, 500);//y-axis

        g.drawString("X-Axis", 430, 140);//Label for x-axis
        g.drawString("Y-Axis", 200, 270);//Label for y-axis

        g.setColor(Color.blue);//color for the sin curve

        for (int i = -130; i <= 368; i++) {
            x1 = (int) (WEIGHT * Math.sin(((i) * 2 * Math.PI * CYCLE) / (MAX)));
            x2 = (int) (WEIGHT * Math.sin(((i + 1) * 2 * Math.PI * CYCLE) / (MAX)));

            g.drawLine(i + 121, x1 + 138, (i + 1) + 121, x2 + 138);
        }

        g.setFont(new Font("Times New Roman", Font.BOLD, 15));
        g.drawString("IT WORKS ; )", 100, 50);
    }
}
