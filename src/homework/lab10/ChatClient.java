package homework.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ChatClient(String serverAddress, int serverPort) {
        System.out.println("Establishing connection. Please wait...");
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected: " + socket);
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexpected exception: " + ioe.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                out.write(message);
            }

            out.write(message);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String args[]) {
        ChatClient client = null;
        if (args.length != 2)
            System.out.println("Usage: java ChatClient [host] [port]");
        else
            client = new ChatClient(args[0], Integer.parseInt(args[1]));
    }
}
