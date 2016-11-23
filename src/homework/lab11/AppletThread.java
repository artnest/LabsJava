package homework.lab11;

import java.util.Date;
import java.util.Random;

public class AppletThread extends Thread {
    private AppletGraph appletGraph = null;
    private Random random = new Random(new Date().getTime());
    private volatile int m = 0;

    public AppletThread(AppletGraph appletGraph) {
        super();
        this.appletGraph = appletGraph;
    }
}
