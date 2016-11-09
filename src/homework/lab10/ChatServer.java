package homework.lab10;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by theme on 11/9/16.
 */
public class ChatServer implements Runnable {
    private ServerSocket server;
    private Thread thread;
    private ChatServerThread clients[] = new ChatServerThread[50]; // TODO change the amount
    private int clientCount = 0;

    public ChatServer(int port) {
        System.out.println("Binding to port " + port + ", please wait...");
        try {
            server = new ServerSocket(port);
            System.out.println("Server started: " + server);
            start();
        } catch (IOException e) {
            System.err.println("Cannot bind to port " + port + ": " + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (thread != null) {
            System.out.println("Waiting for a client...");
            try {
                addThread(server.accept());
            } catch (IOException e) {
                System.err.println("Server accept error: " + e.getMessage());
                stop();
            }
        }
    }

    private void start() {
        if (thread != null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    private void stop() {
        if (thread != null) {
            thread.stop(); // TODO don't use deprecated
            thread = null;
        }
    }
}
