package homework.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private ServerSocket serverSocket;
    private int port;
    private Set<String> names;
    private Set<PrintWriter> printWriters;

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

    private void acceptClients() {
        try {
            while (true) {
                System.out.println("Waiting for a client...");
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Accept failed on: " + port);

            try {
                serverSocket.close();
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
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
            String input;
            while ((input = in.readLine()) != null) {
                for (PrintWriter writer : printWriters) {
                    writer.println(name + ": " + input);
                }
            }

            out.println("> Goodbye, " + name);
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
