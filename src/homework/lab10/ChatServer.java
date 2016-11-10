package homework.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by theme on 11/9/16.
 */
public class ChatServer implements Runnable {
    private ServerSocket serverSocket;
    private Thread thread; // TODO remove
    private int port;
    private Set<String> names;
    private Set<PrintWriter> printWriters;

//    private int clientCount = 50;
    //   private ChatServerThread clients[] = new ChatServerThread[clientCount]; // TODO change the amount
//    private Set<ChatServerThread> chatServerThreadSet = new LinkedHashSet<>();

    public ChatServer(int port) {
        this.port = port;
        this.names = new HashSet<>();
        this.printWriters = new HashSet<>();

        System.out.println("Binding to port " + port + ", please wait...");
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started: " + serverSocket);
            acceptClients();
        } catch (IOException e) {
            System.err.println("Cannot bind to port " + port + ": " + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (thread != null) {
            System.out.println("Waiting for a client...");
            try {
                addThread(serverSocket.accept());
            } catch (IOException e) {
                System.err.println("Server accept error: " + e.getMessage());
                stop();
            }
        }
    }

    private void acceptClients() {
        try {
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Accept failed on: " + port);
        } // TODO close serverSocket somewhere
    }

    private void stop() {
        if (thread != null) {
            thread.stop(); // TODO don't use deprecated
            thread = null;
        }
    }

    public synchronized void handle(int ID, String input) {
        if (input != null) {
            for (ChatServerThread client : clients) {
                client.send(ID + ": " + input);
            }
        } else {
            clients[findClientNumberByID(ID)].send("Goodbye!");
        }
    }

    public synchronized void remove(int ID) {
    }

    private void addThread(Socket socket) {
        if (clientCount < clients.length) {
            System.out.println("Client accepted: " + socket);
            clients[clientCount] = new ChatServerThread(this, socket);

            try {
                clients[clientCount].open();
                clients[clientCount].start();
                clientCount++;
            } catch (IOException e) {
                System.err.println("Error opening thread: " + e.getMessage());
            }
        } else {
            System.err.println("Client refused: maximum " + clients.length + " reached");
        }
    }

    private class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                if (inputName()) {
                    out.println("> Name accepted");
                    printWriters.add(out);
                }

                sendMessages();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                if (name != null) {
                    names.remove(name);
                }

                if (out != null) {
                    printWriters.remove(out);
                }

                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        private boolean inputName() throws IOException {
            while (true) {
                out.println("> Submit your name:");
                name = in.readLine();

                if (name == null) {
                    return false;
                }

                synchronized (names) {
                    if (!names.contains(name)) {
                        names.add(name);
                        return true;
                    }

                    out.println("> Your name ins't unique!");
                }
            }
        }

        private void sendMessages() throws IOException {
            while (true) {
                String input = in.readLine();

                if (input == null) {
                    out.println("> Goodbye, " + name);
                    return;
                }

                for (PrintWriter writer : printWriters) {
                    writer.println(name + ": " + input);
                }
            }
        }
    }

    public static void main(String[] args) {
        ChatServer server = null;
        if (args.length != 1) {
            System.out.println("Usage: java ChatServer [port]");
        } else {
            server = new ChatServer(Integer.parseInt(args[0]));
        }
    }
}
