package homework.lab11;

import java.util.Date;
import java.util.Random;

class AppletThread extends Thread {
    private AppletGraph appletGraph = null;
    private Random random = new Random(new Date().getTime());
    private volatile int m = 0;

    AppletThread(AppletGraph appletGraph) {
        super();
        this.appletGraph = appletGraph;
    }
}
