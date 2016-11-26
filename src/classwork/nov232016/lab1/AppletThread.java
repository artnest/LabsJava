package classwork.nov232016.lab1;

import java.util.Date;
import java.util.Random;

public class AppletThread extends Thread {
    private AppletGraph appletGraph = null;
    private Random random = new Random(new Date().getTime());
    private volatile int ni = 0;

    public AppletThread(AppletGraph appletGraph) {
        super();
        this.appletGraph = appletGraph;
    }
}
